package app.gourmetgate.gourmetgate.data.vat;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@ApplicationScoped
public interface IVatRepository extends IEntityRepository<VatDo> {

  Map<UUID, VatDo> getVatByItemId(List<UUID> itemIds);
}
