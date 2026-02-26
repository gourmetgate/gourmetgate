package app.gourmetgate.gourmetgate.data.auth;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.Token")
public class TokenDo extends DoEntity {
    public DoValue<String> accessToken() {
        return doValue("accessToken");
    }

    public DoValue<String> refreshToken() {
        return doValue("refreshToken");
    }

    /* **************************************************************************
     * GENERATED CONVENIENCE METHODS
     * *************************************************************************/

    @Generated("DoConvenienceMethodsGenerator")
    public TokenDo withAccessToken(String accessToken) {
        accessToken().set(accessToken);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getAccessToken() {
        return accessToken().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public TokenDo withRefreshToken(String refreshToken) {
        refreshToken().set(refreshToken);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getRefreshToken() {
        return refreshToken().get();
    }
}
