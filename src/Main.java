import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter password to check:");
        Password p = new Password(scanner.next());
        System.out.println(p.awardPoints());
        p.ratePassword();

    }
}
