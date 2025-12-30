package app.gourmetgate.gourmetgate.core.vat;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.common.EntityNotFoundException;
import app.gourmetgate.gourmetgate.data.item.IItemRepository;
import app.gourmetgate.gourmetgate.data.query.VatRestrictionDo;
import app.gourmetgate.gourmetgate.data.vat.IVatRepository;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.LazyValue;

import java.util.List;
import java.util.UUID;

public class VatService implements IService {

  protected LazyValue<DoHelper> helper = new LazyValue<>(DoHelper.class);

  public List<VatDo> list(VatRestrictionDo restriction) {
    return BEANS.get(IVatRepository.class).getAllActive()
      .toList();
  }

  public VatDo getById(UUID id) {
    // Permission check required

    return BEANS.get(IVatRepository.class).getById(id)
      .orElseThrow(() -> new EntityNotFoundException("Vat", id));
  }

  public VatDo create(VatDo vat) {
    // Permission check required
    helper.get().validateRequiredProperty(vat.percentage());

    return BEANS.get(IVatRepository.class).create(vat);
  }

  public VatDo update(UUID id, VatDo vat) {
    // Permission check required
    helper.get().validateRequiredProperty(vat.vatId());
    helper.get().validateRequiredProperty(vat.percentage());
    helper.get().validateSameId(id, vat.vatId());

    int affectedRows = BEANS.get(IVatRepository.class).store(id, vat);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Vat", id);
    }
    return vat;
  }

  public void delete(UUID id, UUID replacement) {
    // Check permissions
    helper.get().validateReplacementId(id, replacement);

    // Replace category
    BEANS.get(IItemRepository.class).replaceVat(id, replacement);

    int affectedRows = BEANS.get(IVatRepository.class).delete(id);
    if (affectedRows != 1) {
      throw new EntityNotFoundException("Vat", id);
    }
  }
}
