package sat.recruitment.api.repository;

import java.util.List;
import sat.recruitment.api.entity.User;

public interface IUserRepository {
	User save(User user);
	List<User> findAllUser();
}
