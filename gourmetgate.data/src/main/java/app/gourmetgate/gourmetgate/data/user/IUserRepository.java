package app.gourmetgate.gourmetgate.data.user;

import app.gourmetgate.gourmetgate.data.common.IEntityRepository;
import app.gourmetgate.gourmetgate.data.query.UserRestrictionDo;

import java.util.stream.Stream;

public interface IUserRepository extends IEntityRepository<UserDo> {
  Stream<UserDo> list(UserRestrictionDo restriction);
}
