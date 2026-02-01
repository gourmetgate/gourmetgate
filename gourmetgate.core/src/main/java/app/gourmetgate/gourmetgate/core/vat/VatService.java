package app.gourmetgate.gourmetgate.core.vat;

import app.gourmetgate.gourmetgate.data.query.VatRestrictionDo;
import app.gourmetgate.gourmetgate.data.vat.IVatRepository;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

import java.util.List;

public class VatService implements IService {

  public List<VatDo> list(VatRestrictionDo restriction) {
    return BEANS.get(IVatRepository.class).getAllActive()
      .toList();
  }
}
