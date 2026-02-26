package app.gourmetgate.gourmetgate.core.auth;

import org.apache.hc.core5.http.NotImplementedException;
import org.eclipse.scout.rt.platform.ApplicationScoped;
import org.eclipse.scout.rt.platform.exception.PlatformException;
import org.eclipse.scout.rt.platform.security.ICredentialVerifier;
@ApplicationScoped
public class GourmetgateCredentialVerifier implements ICredentialVerifier {
  @Override
  public int verify(String username, char[] password) {
    return AUTH_OK;
    // throw new PlatformException("Not Implemented");
  }
}
