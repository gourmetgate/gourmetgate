package app.gourmetgate.gourmetgate.core.vat;

import app.gourmetgate.gourmetgate.data.vat.IVatRepository;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class VatService implements IService {

  public Map<UUID, VatDo> getVatByItemId(List<UUID> itemIds) {
    return BEANS.get(IVatRepository.class).getVatByItemId(itemIds);
  }
}
