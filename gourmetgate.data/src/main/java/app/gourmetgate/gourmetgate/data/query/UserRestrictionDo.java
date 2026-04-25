package app.gourmetgate.gourmetgate.data.query;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;

import java.util.UUID;

public class UserRestrictionDo extends DoEntity {

    public DoValue<UUID> userId() {
        return doValue("userId");
    }

    public DoValue<String> userName() {
        return doValue("userName");
    }

    /* **************************************************************************
     * GENERATED CONVENIENCE METHODS
     * *************************************************************************/

    @Generated("DoConvenienceMethodsGenerator")
    public UserRestrictionDo withUserId(UUID userId) {
        userId().set(userId);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UUID getUserId() {
        return userId().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UserRestrictionDo withUserName(String userName) {
        userName().set(userName);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getUserName() {
        return userName().get();
    }
}
