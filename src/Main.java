import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Generator t = new Generator();
        System.out.println(t.getHasLowerCase() +" "+ t.getHasUpperCase() + " " + t.getHasNumber() + " " + t.getHasSpecial());
        System.out.println(t.getPassword());
    }
}
