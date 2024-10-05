package ra.project.dao.user;

import ra.project.model.entity.User;

public interface IUserDao {
    void save(User user);
    User loadUserByUsername(String username);
}
