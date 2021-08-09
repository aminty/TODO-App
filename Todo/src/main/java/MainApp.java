import service.ApplicationObject;
import service.Constant;
import service.PrintMessage;
import service.menu.Menu;

import java.sql.SQLException;

public class MainApp {
    public static void main(String[] args) {
        ApplicationObject appObject=new ApplicationObject();
        try {
            Menu.runPublicMenu();
        }catch (Exception e){
            PrintMessage.showErr(Constant.SOMETHING_WENT_WRONG);
            PrintMessage.showErr(e.getMessage());
        }
        finally {
            Menu.runPublicMenu();
        }
    }
}
