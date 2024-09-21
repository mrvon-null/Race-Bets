import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Utils {

    static List<Racers> racerList = new ArrayList<>();

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
        for (int i = 0; i < Utils.racerList.size(); i++) {
            System.out.println(Utils.racerList.get(i).getName() + " has " + Utils.racerList.get(i).getMoney());
        }
    }
}
