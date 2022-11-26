package machine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String action = "";
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            switch (action) {
                case "buy" -> CoffeeMaker.buyCoffee(scanner);
                case "fill" -> CoffeeMaker.fillCoffee(scanner);
                case "take" -> CoffeeMaker.takeCoffee(scanner);
                case "remaining" -> CoffeeMaker.printState();
                case "exit" -> {
                    return;
                }
            }
        } while (action != "exit");
    }

}
