package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.ItemToVariantEntity;

import java.util.List;

public class ItemToVariantDataProvider extends AbstractInitialDataProvider<ItemToVariantEntity> {

  @Override
  public List<ItemToVariantEntity> getInitialData() {
    ItemToVariantEntity friesToSauce = new ItemToVariantEntity();
    friesToSauce.itemId = ItemDataProvider.FRIES_ID;
    friesToSauce.variantId = VariantDataProvider.VARIANT_SAUCE_ID;

    ItemToVariantEntity hotDogToSauce = new ItemToVariantEntity();
    hotDogToSauce.itemId = ItemDataProvider.HOT_DOG_ID;
    hotDogToSauce.variantId = VariantDataProvider.VARIANT_SAUCE_ID;

    ItemToVariantEntity hotDogToAllergies = new ItemToVariantEntity();
    hotDogToAllergies.itemId = ItemDataProvider.HOT_DOG_ID;
    hotDogToAllergies.variantId = VariantDataProvider.VARIANT_ALLERGIES_ID;

    ItemToVariantEntity burgerToAllergies = new ItemToVariantEntity();
    burgerToAllergies.itemId = ItemDataProvider.BURGER_ID;
    burgerToAllergies.variantId = VariantDataProvider.VARIANT_ALLERGIES_ID;

    return List.of(friesToSauce, hotDogToSauce, hotDogToAllergies, burgerToAllergies);
  }
}
