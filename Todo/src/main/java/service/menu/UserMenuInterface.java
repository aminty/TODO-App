package service.menu;

import entity.User;

import java.sql.SQLException;

public interface UserMenuInterface {
    void signup() ;
    void login() ;
    void addActivity(User user);
    void sortActivity(int id);
    void manageActivity(int id);

}
