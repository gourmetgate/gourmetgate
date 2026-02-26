package app.gourmetgate.gourmetgate.core.auth;

import app.gourmetgate.gourmetgate.data.auth.CreateTokenDo;
import app.gourmetgate.gourmetgate.data.auth.TokenDo;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.eclipse.scout.rt.platform.BEANS;
import org.eclipse.scout.rt.platform.config.CONFIG;
import org.eclipse.scout.rt.platform.service.IService;
import org.eclipse.scout.rt.platform.util.date.DateUtility;

import java.nio.charset.StandardCharsets;
import java.nio.file.AccessDeniedException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import java.util.Date;

public class AuthService implements IService {

  public TokenDo createToken(CreateTokenDo createTokenDo) {
    String userId = findUser(createTokenDo.getUserName(), createTokenDo.getPassword());
    String accessToken = JWT.create()
      .withIssuer("gourmetgate")
      .withClaim("userId", userId)
      .withExpiresAt(DateUtility.addSeconds(new Date(), CONFIG.getPropertyValue(AuthProperties.AccessTokenExpirationProperty.class)))
      .sign(getAlgorithm());
    String refreshToken = JWT.create()
      .withIssuer("gourmetgate")
      .withClaim("userId", userId)
      .withExpiresAt(DateUtility.addSeconds(new Date(), CONFIG.getPropertyValue(AuthProperties.RefreshTokenExpirationProperty.class)))
      .sign(getAlgorithm());

    return BEANS.get(TokenDo.class)
      .withAccessToken(accessToken)
      .withRefreshToken(refreshToken);
  }

  private String findUser(String userName, String password) {
    return null;
  }

  public void validateToken(String token) throws AccessDeniedException {
    try {
      JWTVerifier verifier = JWT.require(getAlgorithm())
        .withIssuer("gourmetgate")
        .build();
      verifier.verify(token);
    } catch (JWTVerificationException exception) {
      throw new AccessDeniedException(exception.getMessage());
    }
  }

  private Algorithm getAlgorithm() {
    try {
      RSAPrivateKey rsaPrivateKey = (RSAPrivateKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(
        CONFIG.getPropertyValue(AuthProperties.PrivateKeyProperty.class).getBytes(StandardCharsets.UTF_8)));
      RSAPublicKey rsaPublicKey = (RSAPublicKey) KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(
        CONFIG.getPropertyValue(AuthProperties.PublicKeyProperty.class).getBytes(StandardCharsets.UTF_8)));
      return Algorithm.RSA256(rsaPublicKey, rsaPrivateKey);
    } catch (InvalidKeySpecException | NoSuchAlgorithmException e) {
      throw new RuntimeException(e);
    }
  }
}
