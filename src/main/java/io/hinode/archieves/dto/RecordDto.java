package io.hinode.archieves.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RecordDto {

  private String id;
  private LocalDateTime initialTimestamp;
  private LocalDateTime editTimestamp;
  private String title;
  private String data;
}
