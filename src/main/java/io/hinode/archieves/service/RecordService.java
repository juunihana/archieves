package io.hinode.archieves.service;

import io.hinode.archieves.dto.RecordDto;
import io.hinode.archieves.dto.UpdateRecordDto;
import io.hinode.archieves.exception.NoRecordFoundException;
import java.util.List;

public interface RecordService {

  RecordDto getRecordById(String id) throws NoRecordFoundException;

  List<RecordDto> getAllRecords();

  RecordDto save(UpdateRecordDto record);

  RecordDto updateRecord(String id, UpdateRecordDto record) throws NoRecordFoundException;

  void deleteRecord(String id) throws NoRecordFoundException;
}
