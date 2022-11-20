package io.hinode.archieves.service.impl;

import io.hinode.archieves.dto.RecordDto;
import io.hinode.archieves.dto.UpdateRecordDto;
import io.hinode.archieves.entity.Record;
import io.hinode.archieves.exception.NoRecordFoundException;
import io.hinode.archieves.mapper.RecordMapper;
import io.hinode.archieves.repository.RecordRepository;
import io.hinode.archieves.service.RecordService;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RecordServiceImpl implements RecordService {

  private final RecordMapper archiveMapper = Mappers.getMapper(RecordMapper.class);
  private final RecordRepository recordRepository;

  @Autowired
  public RecordServiceImpl(RecordRepository recordRepository) {
    this.recordRepository = recordRepository;
  }

  @Override
  public RecordDto getRecordById(String id) throws NoRecordFoundException {
    return recordRepository.findById(id).map(archiveMapper::entityToDto)
        .orElseThrow(NoRecordFoundException::new);
  }

  @Override
  public List<RecordDto> getAllRecords() {
    List<RecordDto> records = new ArrayList<>();
    recordRepository.findAll().forEach(record -> records.add(archiveMapper.entityToDto(record)));

    return records;
  }

  @Override
  public RecordDto save(UpdateRecordDto record) {
    Record entity = archiveMapper.updateDtoToEntity(record);
    entity.setId(UUID.randomUUID().toString());
    entity.setInitialTimestamp(LocalDateTime.now());
    entity.setEditTimestamp(LocalDateTime.now());
    return archiveMapper.entityToDto(recordRepository.save(entity));
  }

  @Override
  public RecordDto updateRecord(String id, UpdateRecordDto record) throws NoRecordFoundException {
    Record entity = recordRepository.findById(id).orElseThrow(NoRecordFoundException::new);
    entity.setEditTimestamp(LocalDateTime.now());
    entity.setTitle(record.getTitle());
    entity.setData(record.getData());
    return archiveMapper.entityToDto(recordRepository.save(entity));
  }

  @Override
  public void deleteRecord(String id) throws NoRecordFoundException {
    Record entity = recordRepository.findById(id).orElseThrow(NoRecordFoundException::new);
    recordRepository.delete(entity);
  }
}
