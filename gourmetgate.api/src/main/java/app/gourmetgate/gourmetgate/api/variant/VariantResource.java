package app.gourmetgate.gourmetgate.api.variant;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.item.ItemService;
import app.gourmetgate.gourmetgate.core.variant.VariantService;
import app.gourmetgate.gourmetgate.core.vat.VatService;
import app.gourmetgate.gourmetgate.data.query.VariantRestrictionDo;
import app.gourmetgate.gourmetgate.data.variant.VariantDo;
import app.gourmetgate.gourmetgate.data.variant.VariantResponseDo;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import java.util.UUID;

@Path("variant")
public class VariantResource implements IRestResource {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public VariantResponseDo getAll() {
    return BEANS.get(VariantResponseDo.class)
      .withVariants(BEANS.get(VariantService.class).list(BEANS.get(VariantRestrictionDo.class)));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public VariantDo getById(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(VariantService.class).getById(uuid);
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public VariantDo create(VariantDo variant) {
    return BEANS.get(VariantService.class).create(variant);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public VariantDo update(@PathParam("id") String id, VariantDo variant) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(VariantService.class).update(uuid, variant);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    BEANS.get(VariantService.class).delete(uuid);
  }
}
