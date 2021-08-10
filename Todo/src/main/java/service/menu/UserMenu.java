package service.menu;


import entity.Activity;
import entity.User;
import entity.enumeration.ActivityStatus;
import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.util.List;
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
        User user = new User();
        String username = ApplicationObject.getValidation().isValid(Constant.USERNAME_REGEX,
                Constant.ENTER_YOUR_USERNAME, Constant.INVALID_INPUT);
        String password = ApplicationObject.getValidation().isValid(Constant.PASSWORD_REGEX,
                Constant.ENTER_YOUR_PASSWORD, Constant.INVALID_INPUT);
        user.setUsername(username);
        user.setPassword(password);
        user = ApplicationObject.getUserRepo().authentication(user);
        if (user != null) {
            Menu.runDashboardMenu(user);
            Menu.runPublicMenu();
        } else PrintMessage.showMsg(Constant.INCORRECT_DATA);

    }

    @Override
    public void addActivity(User user) {
        System.out.println("Id---->" + user.getId());
        while (true) {
            Activity activity = new Activity();

            System.out.print("Enter new activity :");
            String activityName = new Scanner(System.in).nextLine();
            if (activityName.equals("0")) break;
            activity.setActivityName(activityName);
            //todo require id --> passed user
            activity.setUser(user);
            activity.setStatus(ActivityStatus.OPEN);
            activity.setDate(java.time.LocalDate.now());
            ApplicationObject.getActivityRepo().insert(activity);
        }


    }

    @Override
    public void sortActivity() {

    }

    @Override
    public void manageActivity(int userId) {
        int count = 1;
        List<Activity> list=ApplicationObject.getActivityRepo().sellectAll(userId);
        while (true) {
            if (!list.isEmpty()) {
            String id = ApplicationObject.getValidation().isValid(Constant.SINGLE_NUMBER_REGEX, "Enter id to change: ", Constant.INVALID_INPUT);
            Activity activity = ApplicationObject.getActivityRepo().find(Integer.parseInt(id));
            if (activity!=null && activity.getUser().getId()==userId){
                for (ActivityStatus ac : ActivityStatus.values()) {
                    System.out.printf("%d : %s \n", count, ac);
                    count++;
                }
                int status = Integer.parseInt(ApplicationObject.getValidation().isValid(Constant.SINGLE_NUMBER_REGEX, "Choose status: ", Constant.INVALID_INPUT));
                switch (status) {
                    case 1 -> activity.setStatus(ActivityStatus.OPEN);
                    case 2 -> activity.setStatus(ActivityStatus.INPROGRESS);
                    case 3 -> activity.setStatus(ActivityStatus.COMPLETED);
                    default -> PrintMessage.showErr(Constant.INVALID_INPUT);
                }
                ApplicationObject.getActivityRepo().update(activity);
                break;
            }

            }else{
                PrintMessage.showMsg("Any activity does not exist.");
            break;}
        }
    }

}
