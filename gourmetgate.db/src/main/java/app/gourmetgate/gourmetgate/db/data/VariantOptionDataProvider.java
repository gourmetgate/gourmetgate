package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.VariantOptionEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class VariantOptionDataProvider extends AbstractInitialDataProvider<VariantOptionEntity> {

  public static final UUID KETCHUP_ID = UUID.randomUUID();
  public static final UUID MAYONNAISE_ID = UUID.randomUUID();
  public static final UUID VEGETARIAN_ID = UUID.randomUUID();
  public static final UUID VEGAN_ID = UUID.randomUUID();
  public static final UUID LACTOSE_FREE_ID = UUID.randomUUID();
  public static final UUID GLUTEN_FREE_ID = UUID.randomUUID();

  @Override
  public List<VariantOptionEntity> getInitialData() {
    VariantOptionEntity ketchup = new VariantOptionEntity();
    ketchup.variantOptionId = KETCHUP_ID;
    ketchup.variantId = VariantDataProvider.VARIANT_SAUCE_ID;
    ketchup.name = "Ketchup";
    ketchup.additionalPrice = new BigDecimal("0.5");

    VariantOptionEntity mayonnaise = new VariantOptionEntity();
    mayonnaise.variantOptionId = MAYONNAISE_ID;
    mayonnaise.variantId = VariantDataProvider.VARIANT_SAUCE_ID;
    mayonnaise.name = "Mayonnaise";
    mayonnaise.additionalPrice = new BigDecimal("0.5");

    VariantOptionEntity vegetarian = new VariantOptionEntity();
    vegetarian.variantOptionId = VEGETARIAN_ID;
    vegetarian.variantId = VariantDataProvider.VARIANT_ALLERGIES_ID;
    vegetarian.name = "Vegetarian";
    vegetarian.additionalPrice = BigDecimal.ZERO;

    VariantOptionEntity vegan = new VariantOptionEntity();
    vegan.variantOptionId = VEGAN_ID;
    vegan.variantId = VariantDataProvider.VARIANT_ALLERGIES_ID;
    vegan.name = "Vegan";
    vegan.additionalPrice = BigDecimal.ZERO;

    VariantOptionEntity lactoseFree = new VariantOptionEntity();
    lactoseFree.variantOptionId = LACTOSE_FREE_ID;
    lactoseFree.variantId = VariantDataProvider.VARIANT_ALLERGIES_ID;
    lactoseFree.name = "Lactose free";
    lactoseFree.additionalPrice = BigDecimal.ZERO;

    VariantOptionEntity glutenFree = new VariantOptionEntity();
    glutenFree.variantOptionId = GLUTEN_FREE_ID;
    glutenFree.variantId = VariantDataProvider.VARIANT_ALLERGIES_ID;
    glutenFree.name = "Gluten free";
    glutenFree.additionalPrice = BigDecimal.ZERO;

    return List.of(ketchup, mayonnaise, vegetarian, vegan, lactoseFree, glutenFree);
  }
}
