import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {



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
            System.out.println(Registration.racerList.get(i).getName() + " has " + Registration.racerList.get(i).getMoney());
        }
    }

    public static int menuShowAndPick() {
        System.out.println("Menu:\n"
                + "1. Register Racers\n"
                + "2. Exit\n");

        return askForInt("");
    }
}