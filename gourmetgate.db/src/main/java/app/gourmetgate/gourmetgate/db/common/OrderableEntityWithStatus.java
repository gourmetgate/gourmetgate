package app.gourmetgate.gourmetgate.db.common;

import app.gourmetgate.gourmetgate.data.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@MappedSuperclass
public class OrderableEntityWithStatus implements ISchemaEntity {

  @CreationTimestamp
  @Column(nullable = false)
  public Instant sortCode;

  @Column(nullable = false)
  public String status = Status.ACTIVE.id;
}
