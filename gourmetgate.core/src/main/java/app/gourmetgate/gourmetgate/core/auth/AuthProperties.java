package app.gourmetgate.gourmetgate.core.auth;

import org.eclipse.scout.rt.platform.config.AbstractIntegerConfigProperty;
import org.eclipse.scout.rt.platform.config.AbstractStringConfigProperty;

public class AuthProperties  {

  private AuthProperties(){}

  public static class PrivateKeyProperty extends AbstractStringConfigProperty {

    @Override
    public String getKey() {
      return "auth.privateKey";
    }

    @Override
    public String description() {
      return "Private key for singin Access Tokens";
    }
  }

  public static class PublicKeyProperty extends AbstractStringConfigProperty {

    @Override
    public String getKey() {
      return "auth.publicKey";
    }

    @Override
    public String description() {
      return "Public key for verifying Access Tokens";
    }
  }

  public static class AccessTokenExpirationProperty extends AbstractIntegerConfigProperty {
    @Override
    public String getKey() {
      return "auth.accessTokenExpiration";
    }

    @Override
    public String description() {
      return "Time in seconds for access token expiration";
    }
  }

  public static class RefreshTokenExpirationProperty extends AbstractIntegerConfigProperty {
    @Override
    public String getKey() {
      return "auth.refreshTokenExpiration";
    }

    @Override
    public String description() {
      return "Time in seconds for refresh token expiration";
    }
  }
}
