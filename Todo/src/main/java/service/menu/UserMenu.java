package service.menu;


import entity.Activity;
import entity.User;
import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.util.Scanner;

public class UserMenu implements UserMenuInterface {


    @Override
    public void signup() {
        User user = new User();
        String name = ApplicationObject.getValidation().isValid(Constant.FIRST_NAME_REGEX,
                Constant.ENTER_NAME, Constant.INVALID_INPUT);
        if (name.equals("0")) Menu.runPublicMenu();
        user.setName(name);
        String lastName = ApplicationObject.getValidation().isValid(Constant.LAST_NAME_REGEX,
                Constant.ENTER_LAST_NAME, Constant.INVALID_INPUT);
        if (lastName.equals("0")) Menu.runPublicMenu();
        user.setlName(lastName);
        do {
            String username = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                    Constant.CHOOSE_USERNAME, Constant.INVALID_INPUT);
            if (username.equals("0")) Menu.runPublicMenu();
            user.setUsername(username);

        } while (!ApplicationObject.getUserRepo().isExist(user));

        String password = ApplicationObject.getValidation().isValid(Constant.PASSWORD_REGEX,
                Constant.CHOOSE_PASSWORD, Constant.INVALID_INPUT);
        if (password.equals("0")) Menu.runPublicMenu();
        user.setPassword(password);
        ApplicationObject.getUserRepo().insert(user);
        Menu.runPublicMenu();
    }

    @Override
    public void login() {
        User user=new User();
        String username = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                Constant.ENTER_YOUR_USERNAME, Constant.INVALID_INPUT);
        String password = ApplicationObject.getValidation().isValid(Constant.PASSWORD_REGEX,
                Constant.ENTER_YOUR_PASSWORD, Constant.INVALID_INPUT);
        user.setUsername(username);
        user.setPassword(password);
        user=ApplicationObject.getUserRepo().authentication(user);
        if (user!=null){
            Menu.runDashboardMenu(user);
            Menu.runPublicMenu();
        }else PrintMessage.showMsg(Constant.INCORRECT_DATA);

    }

    @Override
    public void addActivity() {
        Activity activity=new Activity();


    }

    @Override
    public void sortActivity() {

    }


}
