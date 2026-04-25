package app.gourmetgate.gourmetgate.persistence.user;

import app.gourmetgate.gourmetgate.data.query.UserRestrictionDo;
import app.gourmetgate.gourmetgate.data.status.Status;
import app.gourmetgate.gourmetgate.data.user.IUserRepository;
import app.gourmetgate.gourmetgate.data.user.UserDo;
import app.gourmetgate.gourmetgate.persistence.common.AbstractEntityRepository;
import app.gourmetgate.gourmetgate.persistence.common.DoEntityBeanMappings;
import app.gourmetgate.gourmetgate.persistence.tables.User;
import app.gourmetgate.gourmetgate.persistence.tables.records.UserRecord;
import org.eclipse.scout.rt.platform.BEANS;
import org.jooq.Field;

import java.time.OffsetDateTime;
import java.util.UUID;
import java.util.stream.Stream;

import static app.gourmetgate.gourmetgate.persistence.JooqSqlService.jooq;
import static org.jooq.impl.DSL.noCondition;

public class UserRepository extends AbstractEntityRepository<User, UserRecord, UserDo> implements IUserRepository {
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
      .with(UserDo::password, UserRecord::getPassword, UserRecord::setPassword)
      .with(UserDo::salt, UserRecord::getSalt, UserRecord::setSalt);
  }

  @Override
  public User getTable() {
    return User.USER;
  }

  @Override
  public Field<UUID> getIdColumn() {
    return User.USER.USER_ID;
  }

  @Override
  public Stream<UserDo> list(UserRestrictionDo restriction) {
    return jooq()
      .selectFrom(getTable())
      .where(
        getTable().STATUS.eq(Status.ACTIVE.id),
        restriction.userId().exists() ? getIdColumn().eq(restriction.getUserId()) : noCondition(),
        restriction.userName().exists() ? getTextMatchingCondition(getTable().USER_NAME, restriction.getUserName()) : noCondition()
      )
      .fetchStream()
      .map(this::toNewDo);
  }
}
