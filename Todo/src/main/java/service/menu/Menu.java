package service.menu;

import entity.User;
import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;

import java.sql.SQLException;

public class Menu {

    public static void runPublicMenu()  {
        PrintMessage.printMenu(Constant.PUBLIC_MENU_ITEM, Constant.WELCOM);
        {
            while (true) {
                switch (Integer.parseInt(ApplicationObject.getValidation().isValid(
                        Constant.SINGLE_NUMBER_REGEX,
                        Constant.ENTER_NUMERIC_CHOICE,
                        Constant.INVALID_INPUT
                ))) {
                    case 1 -> ApplicationObject.getUserMenu().login();
                    case 2 -> ApplicationObject.getUserMenu().signup();
                    case 3 -> {
                        PrintMessage.showMsg(Constant.APPLICATION_CLOSED);
                        System.exit(0);
                    }
                    default -> PrintMessage.showErr(Constant.INVALID_INPUT);
                }
            }
        }
    }

    public static void runDashboardMenu(User user){
        PrintMessage.printMenu(Constant.Dashboard_MENU_ITEM, Constant.WELCOM + " (" + user.getName() + ")");
        outer:
        {
            while (true) {
                switch (Integer.parseInt(ApplicationObject.getValidation().isValid(
                        Constant.SINGLE_NUMBER_REGEX,
                        Constant.ENTER_NUMERIC_CHOICE,
                        Constant.INVALID_INPUT
                ))) {
                    case 1 -> ApplicationObject.getUserMenu().addActivity();
                    case 2 -> {
                        ApplicationObject.getUserMenu().sortActivity();
                        break outer;
                    }
                    case 3 -> {
                        break outer;
                    }

                    default -> PrintMessage.showErr(Constant.INVALID_INPUT);
                }
            }
        }
    }

}
