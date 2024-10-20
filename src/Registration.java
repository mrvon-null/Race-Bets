import java.util.HashMap;
import java.util.Map;

public class Registration {
    static Map<String, Users> userTable = new HashMap<>();

    public static void regUsers(int num) {
        int reference = userTable.size();
        while (userTable.size() - reference < num) {
            String name = Utils.askForText("Name of the User: ");
            int money = Utils.askForInt("Money of the User: ");
            Users user = new Users(name, money);
            userTable.put(name, user);
        }
    }
}