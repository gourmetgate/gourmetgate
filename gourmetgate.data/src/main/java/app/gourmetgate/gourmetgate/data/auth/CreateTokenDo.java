package app.gourmetgate.gourmetgate.data.auth;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoValue;
import org.eclipse.scout.rt.dataobject.TypeName;

@TypeName("gourmetgate.CreateToken")
public class CreateTokenDo extends DoEntity {

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
    public CreateTokenDo withUserName(String userName) {
        userName().set(userName);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getUserName() {
        return userName().get();
    }

    @Generated("DoConvenienceMethodsGenerator")
    public CreateTokenDo withPassword(String password) {
        password().set(password);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public String getPassword() {
        return password().get();
    }
}
