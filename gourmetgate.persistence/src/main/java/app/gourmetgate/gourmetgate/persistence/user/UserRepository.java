package app.gourmetgate.gourmetgate.persistence.user;

import app.gourmetgate.gourmetgate.data.user.UserDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.User;
import app.gourmetgate.gourmetgate.persistence.tables.records.UserRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;

public class UserRepository extends AbstractEntityRepository<User, UserRecord, UserDo> {
  @Override
  public Field<OffsetDateTime> getSortColumn() {
    return User.USER.SORT_CODE;
  }

  @Override
  public Field<String> getStatusColumn() {
    return User.USER.STATUS;
  }

  @Override
  protected UserRecord toNewRecord(UserDo sourceDo) {
    return fromDoToRecord(sourceDo, new UserRecord());
  }

  @Override
  protected UserDo toNewDo(UserRecord sourceRecord) {
    return fromRecordToDo(sourceRecord, BEANS.get(UserDo.class));
  }

  @Override
  protected DoEntityBeanMappings<UserDo, UserRecord> mappings() {
    return new DoEntityBeanMappings<UserDo, UserRecord>()
      .with(UserDo::userId, UserRecord::getUserId, UserRecord::setUserId)
      .with(UserDo::userName, UserRecord::getUserName, UserRecord::setUserName)
      .with(UserDo::password, UserRecord::getPassword, UserRecord::setPassword);
  }

  @Override
  public User getTable() {
    return User.USER;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return User.USER.USER_ID;
  }
}
