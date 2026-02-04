package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.ItemEntity;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

public class ItemDataProvider extends AbstractInitialDataProvider<ItemEntity> {

  public static final UUID FRIES_ID = UUID.randomUUID();
  public static final UUID COKE_ID = UUID.randomUUID();
  public static final UUID BURGER_ID = UUID.randomUUID();
  public static final UUID HOT_DOG_ID = UUID.randomUUID();

  @Override
  public List<ItemEntity> getInitialData() {
    ItemEntity fries = new ItemEntity();
    fries.itemId = FRIES_ID;
    fries.categoryId = CategoryDataProvider.FOOD_CATEGORY_ID;
    fries.vatId = VatDataProvider.VAT_STANDARD_CH_ID;
    fries.name = "Fries";
    fries.price = new BigDecimal("5.50");
    fries.cost = new BigDecimal("2.24");

    ItemEntity coke = new ItemEntity();
    coke.itemId = COKE_ID;
    coke.categoryId = CategoryDataProvider.DRINKS_CATEGORY_ID;
    coke.vatId = VatDataProvider.VAT_STANDARD_CH_ID;
    coke.name = "Coca cola";
    coke.price = new BigDecimal("5");
    coke.cost = new BigDecimal("1.20");

    ItemEntity burger = new ItemEntity();
    burger.itemId = BURGER_ID;
    burger.categoryId = CategoryDataProvider.FOOD_CATEGORY_ID;
    burger.vatId = VatDataProvider.VAT_STANDARD_CH_ID;
    burger.name = "Burger";
    burger.price = new BigDecimal("17.00");
    burger.cost = new BigDecimal("8.40");

    ItemEntity hotDog = new ItemEntity();
    hotDog.itemId = HOT_DOG_ID;
    hotDog.categoryId = CategoryDataProvider.FOOD_CATEGORY_ID;
    hotDog.vatId = VatDataProvider.VAT_STANDARD_CH_ID;
    hotDog.name = "Hot Dog";
    hotDog.price = new BigDecimal("5.00");
    hotDog.cost = new BigDecimal("2.10");

    return List.of(fries, coke, burger, hotDog);
  }
}
