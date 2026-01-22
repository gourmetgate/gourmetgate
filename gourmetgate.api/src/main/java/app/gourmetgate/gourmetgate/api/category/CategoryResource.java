package app.gourmetgate.gourmetgate.api.category;

import app.gourmetgate.gourmetgate.core.category.CategoryService;
import app.gourmetgate.gourmetgate.data.category.CategoryResponseDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

@Path("categories")
public class CategoryResource implements IRestResource {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public CategoryResponseDo getAll(@DefaultValue("true") @QueryParam("onlyAvailable") boolean onlyAvailable) {
    return BEANS.get(CategoryResponseDo.class)
      .withCategories(BEANS.get(CategoryService.class).getCategories(onlyAvailable));
  }
}
