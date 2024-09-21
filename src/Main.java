public class Main {
    static String adminName = "Admin";
    static String adminPass = "12345";

    public static void main(String[] args) {
        if(Login.adminLogin(adminName,adminPass)){
            System.out.println("Welcome to the System!");
            for (int i = 0; i < 2; i++) {
                Racers racer = new Racers(Utils.askForText("Name of User: "), Utils.askForInt("Money the User has: ") );
                Utils.racerList.add(racer);
            }
            Utils.printAll();
        }
    }
}