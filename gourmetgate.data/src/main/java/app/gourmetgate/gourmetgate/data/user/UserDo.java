package app.gourmetgate.gourmetgate.data.user;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.UUID;

@TypeName("gourmetgate.UserDo")
public class UserDo extends DoEntity {

    public DoValue<UUID> userId() {
        return doValue("userId");
    }

    public DoValue<String> userName() {
        return doValue("userName");
    }

    public DoValue<String> password() {
        return doValue("password");
    }

    /* **************************************************************************
     * GENERATED CONVENIENCE METHODS
     * *************************************************************************/

    @Generated("DoConvenienceMethodsGenerator")
    public UserDo withUserId(UUID userId) {
        userId().set(userId);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UUID getUserId() {
        return userId().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UserDo withUserName(String userName) {
        userName().set(userName);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getUserName() {
        return userName().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UserDo withPassword(String password) {
        password().set(password);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getPassword() {
        return password().get();
    }
}
