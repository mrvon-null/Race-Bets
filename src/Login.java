public class Login {

    public static boolean adminLogin(String username, String password) {
        boolean nameCheck = false;
        for (int i = 0; i < 3; i++) {
            if (username.equals(Utils.askForText("Name: ")) || nameCheck) {
                nameCheck = true;
            }

            if (password.equals(Utils.askForText("Password: ")) && nameCheck) {
                return true;
            }
        }
        System.out.println("You are not allowed to login");
        return false;
    }

}