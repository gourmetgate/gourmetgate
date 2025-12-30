package app.gourmetgate.gourmetgate.db.data;

import app.gourmetgate.gourmetgate.db.common.AbstractInitialDataProvider;
import app.gourmetgate.gourmetgate.db.schema.CategoryEntity;

import java.util.List;
import java.util.UUID;

public class CategoryDataProvider extends AbstractInitialDataProvider<CategoryEntity> {

  public static final UUID FOOD_CATEGORY_ID = UUID.randomUUID();
  public static final UUID DRINKS_CATEGORY_ID = UUID.randomUUID();

  @Override
  public List<CategoryEntity> getInitialData() {
    CategoryEntity food = new CategoryEntity();
    food.categoryId = FOOD_CATEGORY_ID;
    food.name = "Food";

    CategoryEntity drinks = new CategoryEntity();
    drinks.categoryId = DRINKS_CATEGORY_ID;
    drinks.name = "Drinks";

    return List.of(food, drinks);
  }
}
