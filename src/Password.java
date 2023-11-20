public class Password {
    private String password;
    private int length;

    public Password(String password) {
        this.password = password;
        this.length = password.length();
    }

    public int getLength() {
        return length;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void ratePassword() {
        int points = this.awardPoints();
        switch (points) {
            case 0:
                System.out.println("Your password is very weak.");
                break;
            case 1:
                System.out.println("Your password is weak.");
                break;
            case 2:
                System.out.println("Your password is a bit weak.");
                break;
            case 3:
                System.out.println("Your password is good!");
                break;
            case 4:
                System.out.println("Your password is strong!");
                break;
            case 5:
                System.out.println("Your password is very strong!");
                break;

        }
    }

    public  int awardPoints() {

        /*gives points according to these factors
         * +1 has letters and numbers
         * +1 has lower and uppercase letters
         * +1 uses special characters e.g. .,;:_-!"
         * +1 longer than 6 characters
         * +2 longer than 10 characters
         * lose all points if it matches 10 most used passwords according to
         * "https://www.beckershospitalreview.com/cybersecurity/30-most-common-passwords-of-2023.html"*/

        boolean hasLowercase = false;
        boolean hasUpperCase = false;
        boolean hasNumbers = false;
        boolean hasSpecialCharacters = false;
        int points = 0;

        for(int i = 0; i < password.length(); i++) {
            boolean isSpecial = true;
            for (int j = 0; j < Alphabet.lowerCaseLetters.length(); j++) {
                if (password.charAt(i) == Alphabet.lowerCaseLetters.charAt(j)) {
                    hasLowercase = true;
                    isSpecial = false;
                    break;
                }
            }
            for (int j = 0; j < Alphabet.upperCaseLetters.length(); j++) {
                if (password.charAt(i) == Alphabet.upperCaseLetters.charAt(j)) {
                    hasUpperCase = true;
                    isSpecial = false;
                    break;
                }
            }
            for (int j = 0; j < Alphabet.numbers.length(); j++) {
                if (password.charAt(i) == Alphabet.numbers.charAt(j)) {
                    hasNumbers = true;
                    isSpecial = false;
                    break;
                }
            }
            if(isSpecial){
                hasSpecialCharacters = true;
            }
        }
        if(hasLowercase && hasUpperCase) {
            points++;
        }
        if(hasNumbers && (hasLowercase || hasUpperCase)) {
            points++;
        }
        if(hasSpecialCharacters) {
            points++;
        }
        if(password.length() > 10) {
            points += 2;
        } else if(password.length() > 6) {
            points++;
        } else {
            System.out.println("Password too short.");
            return 0;
        }
        for(int i = 0; i < Alphabet.mostUsedPasswords.length; i++) {
            if(password.equals(Alphabet.mostUsedPasswords[i])) {
                System.out.println("Password matches often used password \"" + Alphabet.mostUsedPasswords[i] + "\".");
                return 0;
            }
        }

        /*
        System.out.println("Has lowercase: " + hasLowercase);
        System.out.println("Has uppercase: " + hasUpperCase);
        System.out.println("Has numbers: " + hasNumbers);
        System.out.println("Has Special: " + hasSpecialCharacters);
         */
        return points;
    }
}
