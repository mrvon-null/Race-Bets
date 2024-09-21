import java.util.ArrayList;
import java.util.List;

public class Registration {

    static List<Racers> racerList = new ArrayList<>();

    public static void regRacers(int num) {
        for (int i = 0; i < num; i++) {
            Racers racer = new Racers(Utils.askForText("Name of User: "), Utils.askForInt("Money the User has: "));
            racerList.add(racer);
        }
    }
}
