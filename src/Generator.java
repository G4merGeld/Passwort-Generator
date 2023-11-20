import java.util.Random;
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
        setGeneratorConditions();
        this.password = generatePassword(length);
    }
    //generates password according to given length and conditions for explanation see below:
    /*
    * Stringbuilder is used to append characters from the respective set of characters from class Alphabet
    * for loop to iterate trough each letter
    * determiner is assigned a random value between 0 (inclusive) and 4 (exclusive)
    * 0 = append random character from lowercase
    * 1 = append random character from uppercase
    * 2 = append random character from numbers
    * 3 = append random characters from special characters
    * if number matches a condition that is false counter i is set 1 back
    * else the for loop continues for the next character
    * converts StringBuilder genPassword to String and returns it
    */
    public String generatePassword(int length) {
        Random random = new Random();
        StringBuilder genPassword = new StringBuilder(length);
        for(int i = 0; i < length; i++) {
            int determiner = random.nextInt(4);
            switch (determiner) {
                case 0:
                    if(hasLowerCase) {
                        int alphabetIndex = random.nextInt(Alphabet.lowerCaseLetters.length());
                        genPassword.append(Alphabet.lowerCaseLetters.charAt(alphabetIndex));
                    } else {
                        i--;
                    }
                    break;
                case 1:
                    if(hasUpperCase) {
                        int alphabetIndex = random.nextInt(Alphabet.upperCaseLetters.length());
                        genPassword.append(Alphabet.upperCaseLetters.charAt(alphabetIndex));
                    } else {
                        i--;
                    }
                    break;
                case 2:
                    if(hasNumber) {
                        int alphabetIndex = random.nextInt(Alphabet.numbers.length());
                        genPassword.append(Alphabet.numbers.charAt(alphabetIndex));
                    } else {
                        i--;
                    }
                    break;
                case 3:
                    if(hasSpecial) {
                        int alphabetIndex = random.nextInt(Alphabet.specialCharacters.length());
                        genPassword.append(Alphabet.specialCharacters.charAt(alphabetIndex));
                    } else {
                        i--;
                    }
                    break;
            }
        }
        return genPassword.toString();
    }

    private void setGeneratorConditions() {
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

    public String getPassword() {
        return password;
    }


}
