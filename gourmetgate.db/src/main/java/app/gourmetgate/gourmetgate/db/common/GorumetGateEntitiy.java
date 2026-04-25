package app.gourmetgate.gourmetgate.db.common;

import app.gourmetgate.gourmetgate.data.status.Status;
import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import org.hibernate.annotations.CreationTimestamp;

import java.time.Instant;

@MappedSuperclass
public class GorumetGateEntitiy implements ISchemaEntity {
  @Column(columnDefinition = "DEFAULT 'ACTIVE'", nullable = false, length = 80)
  public String status = Status.ACTIVE.id;
  @CreationTimestamp
  @Column(columnDefinition = "TIMESTAMPTZ DEFAULT NOW()", nullable = false)
  public Instant sortCode;
}
