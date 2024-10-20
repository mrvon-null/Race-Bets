import java.util.*;

public class Utils {
    static List<Users> foundUsers = new ArrayList<>();
    static int totalBet = 0;

    public static String askForText(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        return sc.next();
    }

    public static int askForInt(String text) {
        Scanner sc = new Scanner(System.in);
        System.out.print(text);
        try {
            return sc.nextInt();
        } catch (Exception e) {
            System.out.println("Enter an integer");
        }
        return 0;
    }

    public static void printAll() {
        for (Users user : Registration.userTable.values()) {
            System.out.println(user.getName() + " --- " + user.getMoney());
        }
    }

    public static boolean pickUsersToBet() {
        String[] names = askForText("Enter Names of users that want to bet:").split(",");
        int betAmount = askForInt("Enter bet amount:");
        foundUsers = findUsers(Registration.userTable, names);
        if (foundUsers == null) {
            System.out.println("No users found");
            return false;
        } else {
            if (!usersSufficientBalanceCheck(foundUsers, betAmount)) {
                System.out.println("Someone doesn't have enough money for this.\nReturning to menu.");
                return false;
            }
        }

        for (Users user : foundUsers) {
            user.subtractMoney(betAmount);
            totalBet += betAmount;
        }
        System.out.println("Bets are placed! You may start the race!");

        return true;
    }

    public static boolean startRace() {
        Random rand = new Random();
        int winner = rand.nextInt(10);
        System.out.println(winner + " but shhhhh!");
        Map<Integer, List<Users>> winnerList = new HashMap<>();

        for (Users user : foundUsers) {
            System.out.print(user.getName());
            Integer guess = askForInt(" enter your guess:");
            if (!winnerList.containsKey(guess)) {
                winnerList.put(guess, new ArrayList<>());
                winnerList.get(guess).add(user);
            } else {
                winnerList.get(guess).add(user);
            }
        }

        if (!winnerList.containsKey(winner)) {
            System.out.println("No users won. Winning number was " + winner);
        } else {
            int howManyWinners = winnerList.get(winner).size();
            int prize = totalBet / howManyWinners;
            for (Users user : winnerList.get(winner)) {
                System.out.print(user.getName() + " ");
                user.addMoney(prize);
            }
            if (howManyWinners == 1) {
                System.out.println("wins " + prize + "!");
            } else {
                System.out.print("each win " + prize + "!");
            }
        }

        totalBet = 0;
        foundUsers.clear();

        return false;
    }

    public static boolean usersSufficientBalanceCheck(List<Users> users, int amount) {
        for (Users user : users) {
            if (!user.doIHaveEnoughMoney(amount)) {
                return false;
            }
        }
        return true;
    }

    public static List<Users> findUsers(Map<String, Users> users, String[] names) {
        List<Users> foundUsers = new ArrayList<>();
        for (String name : names) {
            if (users.containsKey(name)) {
                foundUsers.add(users.get(name));
            } else {
                System.out.println("Check names again!");
                return null;
            }
        }
        return foundUsers;
    }

    public static int menuShowAndPick() {
        System.out.print("""
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