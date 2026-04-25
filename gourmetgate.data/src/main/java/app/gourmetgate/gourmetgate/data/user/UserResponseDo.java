package app.gourmetgate.gourmetgate.data.user;

import jakarta.annotation.Generated;
import org.eclipse.scout.rt.dataobject.DoEntity;
import org.eclipse.scout.rt.dataobject.DoList;
import org.eclipse.scout.rt.dataobject.TypeName;

import java.util.Collection;
import java.util.List;

@TypeName("gourmetgate.UserResponseDo")
public class UserResponseDo extends DoEntity {
    public DoList<UserDo> users() {
        return doList("users");
    }

    /* **************************************************************************
     * GENERATED CONVENIENCE METHODS
     * *************************************************************************/

    @Generated("DoConvenienceMethodsGenerator")
    public UserResponseDo withUsers(Collection<? extends UserDo> users) {
        users().updateAll(users);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public UserResponseDo withUsers(UserDo... users) {
        users().updateAll(users);
        return this;
    }

    @Generated("DoConvenienceMethodsGenerator")
    public List<UserDo> getUsers() {
        return users().get();
    }
}
