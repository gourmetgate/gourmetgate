package app.gourmetgate.gourmetgate.data.vat;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.query.VatRestrictionDo;
import org.eclipse.scout.rt.platform.ApplicationScoped;

import java.util.stream.Stream;

@ApplicationScoped
public interface IVatRepository extends IEntityRepository<VatDo> {

  Stream<VatDo> list(VatRestrictionDo restriction);
}
