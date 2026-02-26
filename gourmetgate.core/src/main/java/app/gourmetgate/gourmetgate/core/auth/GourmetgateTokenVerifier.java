package app.gourmetgate.gourmetgate.core.auth;

import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.util.Base64Utility;
import org.eclipse.scout.rt.server.commons.authentication.token.ITokenVerifier;

import java.nio.file.AccessDeniedException;
import java.util.List;

@ApplicationScoped
public class GourmetgateTokenVerifier implements ITokenVerifier {
  @Override
  public int verify(List<byte[]> tokenParts)  {
    StringBuilder token = new StringBuilder();
    for (byte[] tokenPart : tokenParts) {
      token.append(Base64Utility.encode(tokenPart));
    }
    try {
      BEANS.get(AuthService.class).validateToken(tokenParts.toString());
    } catch (AccessDeniedException e) {
      return AUTH_FORBIDDEN;
    }
    return AUTH_OK;
  }
}
