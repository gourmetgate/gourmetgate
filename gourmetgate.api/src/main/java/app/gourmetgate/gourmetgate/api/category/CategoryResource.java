package app.gourmetgate.gourmetgate.api.category;

import app.gourmetgate.gourmetgate.core.category.CategoryService;
import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.data.category.CategoryDo;
import app.gourmetgate.gourmetgate.data.category.CategoryResponseDo;
import app.gourmetgate.gourmetgate.data.query.CategoryRestrictionDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import java.util.UUID;

@Path("categories")
public class CategoryResource implements IRestResource {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public CategoryResponseDo getAll() {
    return BEANS.get(CategoryResponseDo.class)
      .withCategories(BEANS.get(CategoryService.class).list(BEANS.get(CategoryRestrictionDo.class)));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public CategoryDo getById(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(CategoryService.class).getById(uuid);
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public CategoryDo create(CategoryDo category) {
    return BEANS.get(CategoryService.class).create(category);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public CategoryDo update(@PathParam("id") String id, CategoryDo category) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(CategoryService.class).update(uuid, category);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    BEANS.get(CategoryService.class).delete(uuid);
  }
}
