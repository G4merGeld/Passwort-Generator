import java.util.Scanner;

public class Generator {
    private int length;
    private String password;
    private static Scanner scanner = new Scanner(System.in);
    private boolean hasLowerCase;
    private boolean hasUpperCase;
    private boolean hasNumber;
    private boolean hasSpecial;

    public Generator(int length) {
        this.length = length;
        //this.password = password;
        checkGeneratorConditions();
    }


    public String generatePassword(int length) {
        StringBuilder gen = new StringBuilder(length);

        return "error";
    }

    private void checkGeneratorConditions() {
        String y = "Y";
        String n = "N";
        System.out.println("Should generated password include lowercase letters? Y/N");
        String answer;
        while(true) {
            answer = scanner.next();
            if (answer.equals(y)) {
                this.hasLowerCase = true;
                break;
            } else if (answer.equals(n)) {
                this.hasLowerCase = false;
                break;
            }
            System.out.println("Say Y or N");
        }
        System.out.println("Should generated password include uppercase letters? Y/N");
        while(true) {
            answer = scanner.next();
            if (answer.equals(y)) {
                this.hasUpperCase = true;
                break;
            } else if (answer.equals(n)) {
                this.hasUpperCase = false;
                break;
            }
            System.out.println("Say Y or N");
        }
        System.out.println("Should generated password include numbers? Y/N");
        while(true) {
            answer = scanner.next();
            if (answer.equals(y)) {
                this.hasNumber = true;
                break;
            } else if (answer.equals(n)) {
                this.hasNumber = false;
                break;
            }
            System.out.println("Say Y or N");
        }
        System.out.println("Should generated password include special characters? Y/N");
        while(true) {
            answer = scanner.next();
            if (answer.equals(y)) {
                this.hasSpecial = true;
                break;
            } else if (answer.equals(n)) {
                this.hasSpecial = false;
                break;
            }
            System.out.println("Say Y or N");
        }
    }

    public boolean getHasLowerCase() {
        return hasLowerCase;
    }

    public boolean getHasUpperCase() {
        return hasUpperCase;
    }

    public boolean getHasNumber() {
        return hasNumber;
    }

    public boolean getHasSpecial() {
        return hasSpecial;
    }
}
