package app.gourmetgate.gourmetgate.db.common;

import app.gourmetgate.gourmetgate.data.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@MappedSuperclass
public class OrderableEntityWithStatus implements ISchemaEntity {

  @CreationTimestamp
  @Column(columnDefinition = "TIMESTAMPTZ NOT NULL DEFAULT NOW()")
  public Instant sortCode;

  @Column(columnDefinition = "varchar(80) NOT NULL DEFAULT 'ACTIVE'")
  public String status = Status.ACTIVE.id;
}
