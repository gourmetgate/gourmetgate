package app.gourmetgate.gourmetgate.api.vat;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.vat.VatService;
import app.gourmetgate.gourmetgate.data.VatResponseDo;
import app.gourmetgate.gourmetgate.data.query.VatRestrictionDo;
import app.gourmetgate.gourmetgate.data.vat.VatDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import java.util.UUID;

@Path("vat")
public class VatResource implements IRestResource {

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  public VatResponseDo getAll() {
    return BEANS.get(VatResponseDo.class)
      .withVat(BEANS.get(VatService.class).list(BEANS.get(VatRestrictionDo.class)));
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  public VatDo getById(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(VatService.class).getById(uuid);
  }

  @POST
  @Path("/")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public VatDo create(VatDo category) {
    return BEANS.get(VatService.class).create(category);
  }

  @PUT
  @Path("/{id}")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  public VatDo update(@PathParam("id") String id, VatDo vat) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(VatService.class).update(uuid, vat);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id, @QueryParam("replacementId") String replacementId) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    UUID replacement = BEANS.get(DoHelper.class).ensureUuid(replacementId);
    BEANS.get(VatService.class).delete(uuid, replacement);
  }
}
