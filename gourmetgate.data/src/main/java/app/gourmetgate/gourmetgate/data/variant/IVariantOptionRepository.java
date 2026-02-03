package app.gourmetgate.gourmetgate.data.variant;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.List;
import java.util.UUID;
import java.util.stream.Stream;

@ApplicationScoped
public interface IVariantOptionRepository extends IEntityRepository<VariantOptionDo> {

  Stream<VariantOptionDo> getByVariantIds(List<UUID> variantIds);

  void deleteByVariantId(UUID variantId);
}
