public class Main {

    static String adminName = "Admin";
    static String adminPass = "12345";

    public static void main(String[] args) {
        int menuMode;
        boolean isReady = false;
        if (Login.adminLogin(adminName, adminPass)) {
            System.out.println("Welcome to the System!");
            while (true) {
                menuMode = Utils.menuShowAndPick();
                switch (menuMode) {
                    case 1:
                        Registration.regUsers(Utils.askForInt("Enter the number of racers to register:"));
                        break;
                    case 2:
                        Utils.printAll();
                        break;
                    case 3:
                        if (isReady) {
                            System.out.println("Bets have already been placed. Start the race!");
                            break;
                        }
                        isReady = Utils.pickUsersToBet();
                        break;
                    case 4:
                        if (!isReady) {
                            System.out.println("Place the bets first!");
                            break;
                        }
                        isReady = Utils.startRace();
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        }
    }
}