package io.hinode.archieves.mapper;

import io.hinode.archieves.dto.RecordDto;
import io.hinode.archieves.dto.UpdateRecordDto;
import io.hinode.archieves.entity.Record;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RecordMapper {

  RecordMapper INSTANCE = Mappers.getMapper(RecordMapper.class);

  RecordDto entityToDto(Record record);

  Record dtoToEntity(RecordDto recordDto);

  Record updateDtoToEntity(UpdateRecordDto updateRecordDto);
}
