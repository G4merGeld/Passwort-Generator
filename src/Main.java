import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password to check:");
        Password p = new Password(scanner.next());
        System.out.println(p.awardPoints());
        p.ratePassword();
         */
        Generator t = new Generator(10);
        System.out.println(t.getHasLowerCase() +" "+ t.getHasUpperCase() + " " + t.getHasNumber() + " " + t.getHasSpecial());
    }
}
