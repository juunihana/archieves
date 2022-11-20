package io.hinode.archieves.controller;

import io.hinode.archieves.dto.RecordDto;
import io.hinode.archieves.dto.UpdateRecordDto;
import io.hinode.archieves.exception.NoRecordFoundException;
import io.hinode.archieves.service.RecordService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RecordController {

  private final RecordService recordService;

  @Autowired
  public RecordController(RecordService recordService) {
    this.recordService = recordService;
  }

  @GetMapping("/records/{id}")
  public ResponseEntity<RecordDto> getRecord(
      @PathVariable String id
  ) {
    try {
      return ResponseEntity.ok(recordService.getRecordById(id));
    } catch (NoRecordFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @GetMapping("/records/all")
  public List<RecordDto> getRecords() {
    return recordService.getAllRecords();
  }

  @PostMapping("/records")
  public ResponseEntity<?> saveRecord(
      @RequestBody UpdateRecordDto record
  ) {
    return ResponseEntity.ok(recordService.save(record));
  }

  @PutMapping("/records/{id}")
  public ResponseEntity<?> updateRecord(
      @PathVariable String id,
      @RequestBody UpdateRecordDto record
  ) {
    try {
      return ResponseEntity.ok(recordService.updateRecord(id, record));
    } catch (NoRecordFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
  }

  @DeleteMapping("/records/{id}")
  public ResponseEntity<?> deleteRecord(
      @PathVariable String id
  ) {
    try {
      recordService.deleteRecord(id);
    } catch (NoRecordFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok().build();
  }
}
