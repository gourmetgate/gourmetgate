package app.gourmetgate.gourmetgate.api.user;

import app.gourmetgate.gourmetgate.core.common.DoHelper;
import app.gourmetgate.gourmetgate.core.user.UserService;
import app.gourmetgate.gourmetgate.data.query.UserRestrictionDo;
import app.gourmetgate.gourmetgate.data.user.UserDo;
import app.gourmetgate.gourmetgate.data.user.UserResponseDo;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

import java.util.UUID;

@Path("user")
public class UserResource implements IRestResource {

  @POST
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public UserDo create(UserDo user) {
    return BEANS.get(UserService.class).create(user);
  }

  @PUT
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public UserDo update(@PathParam("id") String id, UserDo user) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(UserService.class).update(uuid, user);
  }

  @DELETE
  @Path("/{id}")
  public void delete(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    BEANS.get(UserService.class).delete(uuid);
  }

  @GET
  @Path("/{id}")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public UserDo find(@PathParam("id") String id) {
    UUID uuid = BEANS.get(DoHelper.class).ensureUuid(id);
    return BEANS.get(UserService.class).getById(uuid);
  }

  @GET
  @Path("/")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public UserResponseDo getAll() {
    return BEANS.get(UserResponseDo.class)
      .withUsers(BEANS.get(UserService.class).list(BEANS.get(UserRestrictionDo.class)));
  }
}
