import java.util.List;
import java.util.Scanner;

public class Utils {

    static int totalBet = 0;

    public static String askForText(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        //sc.close();
        return sc.next();
    }

    public static int askForInt(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        //sc.close();
        return sc.nextInt();
    }

    public static void printAll() {
        for (int i = 0; i < Registration.racerList.size(); i++) {
            System.out.println(Registration.racerList.get(i).getName() + " --- " + Registration.racerList.get(i).getMoney());
        }
    }

    public static void chooseParticipants() {
        int betAmount = askForInt("Enter bet amount:");
        String[] names = askForText("Enter Names of users that want to bet:").split(",");
        for (String name : names) {
            findPersonByName(Registration.racerList, name).subtractMoney(betAmount);
            totalBet += betAmount;
        }
    }

    public static Racers findPersonByName(List<Racers> users, String name) {
        for (Racers user : users) {
            if (user.getName().equalsIgnoreCase(name)) {
                return user;
            }
        }
        return null;
    }

    public static int menuShowAndPick() {
        System.out.println("""
                Menu:
                1. Register Users
                2. Show Users and Balances
                3. Place Bets
                4. Start Race
                5. Exit
                """);

        return askForInt("");
    }
}