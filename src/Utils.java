import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Utils {

    static int totalBet = 0;
    static boolean isReady = false;

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

    public static String[] chooseParticipants() {
        if (isReady) {
            System.out.println("Bets have already been placed. Start the race!");
            return null;
        }
        int betAmount = askForInt("Enter bet amount:");
        String[] names = askForText("Enter Names of users that want to bet:").split(",");
        for (String name : names) {
            findPersonByName(Registration.racerList, name).subtractMoney(betAmount);
            totalBet += betAmount;
        }
        isReady = true;
        return names;
    }

    public static void startRace(String[] betters) {
        if (!isReady) {
            System.out.println("Place the bets first!");
            return;
        }
        Random rand = new Random();
        int winner = rand.nextInt(10);
        List<Racers> winnerList = new ArrayList<>();
        //System.out.println("secret: " + winner);
        for (String name : betters) {
            Racers curr = findPersonByName(Registration.racerList, name);
            System.out.print(curr.getName());
            curr.setGuess(askForInt(" who do you bet on?\n"));
            if (curr.getGuess() == winner) {
                winnerList.add(curr);
            }
        }

        for (Racers racer : winnerList) {
            int earning = totalBet / winnerList.size();
            System.out.println(racer.getName() + " you won! You will receive " + earning);
            racer.addMoney(earning);
        }

        totalBet = 0;
        isReady = false;
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