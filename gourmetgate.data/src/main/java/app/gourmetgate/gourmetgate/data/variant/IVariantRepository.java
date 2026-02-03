package app.gourmetgate.gourmetgate.data.variant;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.query.VariantRestrictionDo;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.stream.Stream;

@ApplicationScoped
public interface IVariantRepository extends IEntityRepository<VariantDo> {

  Stream<VariantDo> list(VariantRestrictionDo variantRestriction);
}
