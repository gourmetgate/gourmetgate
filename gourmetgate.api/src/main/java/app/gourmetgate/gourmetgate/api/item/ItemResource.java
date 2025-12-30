package app.gourmetgate.gourmetgate.api.item;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.item.ItemService;
import app.gourmetgate.gourmetgate.data.item.ItemDo;
import app.gourmetgate.gourmetgate.data.item.ItemResponseDo;
import app.gourmetgate.gourmetgate.data.query.ItemRestrictionDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import java.util.UUID;

@Path("items")
public class ItemResource implements IRestResource {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public ItemResponseDo getAll() {
    return BEANS.get(ItemResponseDo.class)
      .withItems(BEANS.get(ItemService.class).list(BEANS.get(ItemRestrictionDo.class)));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public ItemDo getById(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(ItemService.class).getById(uuid);
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ItemDo create(ItemDo item) {
    return BEANS.get(ItemService.class).create(item);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public ItemDo update(@PathParam("id") String id, ItemDo item) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(ItemService.class).update(uuid, item);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    BEANS.get(ItemService.class).delete(uuid);
  }
}
