package app.gourmetgate.gourmetgate.api.auth;

import app.gourmetgate.gourmetgate.core.auth.AuthService;
import app.gourmetgate.gourmetgate.data.auth.CreateTokenDo;
import app.gourmetgate.gourmetgate.data.auth.TokenDo;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.rest.IRestResource;

@Path("auth")
public class AuthenticationResource implements IRestResource {

  @POST
  @Path("")
  @Produces(MediaType.APPLICATION_JSON)
  @Consumes(MediaType.APPLICATION_JSON)
  public TokenDo createToken(CreateTokenDo createTokenDo) {
    return BEANS.get(AuthService.class).createToken(createTokenDo);
  }

}
