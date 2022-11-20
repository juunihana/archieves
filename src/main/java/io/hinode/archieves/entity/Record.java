package io.hinode.archieves.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "records")
public class Record {

  @Id
  private String id;

  @Column(name = "create_time")
  private LocalDateTime initialTimestamp;

  @Column(name = "edit_time")
  private LocalDateTime editTimestamp;

  private String title;

  @Column(name = "content")
  private String data;
}
