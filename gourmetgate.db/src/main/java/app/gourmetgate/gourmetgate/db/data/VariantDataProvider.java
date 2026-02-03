package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.VariantEntity;

import java.util.List;
import java.util.UUID;

public class VariantDataProvider extends AbstractInitialDataProvider<VariantEntity> {

  public static final UUID VARIANT_SAUCE_ID = UUID.randomUUID();
  public static final UUID VARIANT_ALLERGIES_ID = UUID.randomUUID();

  @Override
  public List<VariantEntity> getInitialData() {
    VariantEntity sauce = new VariantEntity();
    sauce.variantId = VARIANT_SAUCE_ID;
    sauce.name = "Sauce";
    sauce.singleOption = true;

    VariantEntity allergies = new VariantEntity();
    allergies.variantId = VARIANT_ALLERGIES_ID;
    allergies.name = "Allergies";
    allergies.singleOption = false;
    return List.of(sauce, allergies);
  }
}
