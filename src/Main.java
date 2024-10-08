public class Main {

    static String adminName = "Admin";
    static String adminPass = "12345";

    public static void main(String[] args) {
        int menuMode;
        String[] betters = null;

        if (Login.adminLogin(adminName, adminPass)) {
            System.out.println("Welcome to the System!");


            while (true) {
                menuMode = Utils.menuShowAndPick();

                switch (menuMode) {
                    case 1:
                        Registration.regRacers(Utils.askForInt("Enter the number of racers to register:"));
                        break;
                    case 2:
                        Utils.printAll();
                        break;
                    case 3:
                        betters = Utils.chooseParticipants();
                        break;
                    case 4:
                        Utils.startRace(betters);
                        break;
                    case 5:
                        System.exit(0);
                }
            }
        }
    }
}