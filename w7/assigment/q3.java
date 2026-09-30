// Problem 3: The Password Checker

class PasswordChecker {

    private final String password;

    PasswordChecker(String password) {
        this.password = password;
    }

    String getStrength() {

        if (password.length() < 6) {
            return "Weak";
        } 
        else if (password.length() <= 9) {
            return "Medium";
        } 
        else {
            return "Strong";
        }
    }
}

public class Main {
    public static void main(String[] args) {

        PasswordChecker pc = new PasswordChecker("abcd");
        System.out.println(pc.getStrength());

        PasswordChecker pc2 = new PasswordChecker("abcdefghij");
        System.out.println(pc2.getStrength());
    }
}
