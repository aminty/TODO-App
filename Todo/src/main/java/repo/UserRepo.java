package repo;

import entity.User;

public interface UserRepo {
    User authentication(User user);
}
