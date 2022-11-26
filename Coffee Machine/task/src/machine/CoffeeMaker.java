package machine;

import java.util.Scanner;

public class CoffeeMaker {
    private static int water = 400;
    private static int milk = 540;
    private static int coffeeBeans = 120;
    private static int disposableCups = 9;
    private static int money = 550;

    public static void takeCoffee(Scanner scanner) {
        System.out.println("I gave you $" + money);
        CoffeeMaker.money = 0;
    }

    public static void fillCoffee(Scanner scanner) {
        System.out.println("Write how many ml of water you want to add:");
        int water = scanner.nextInt();
        System.out.println("Write how many ml of milk the coffee machine you want to add:");
        int milk = scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        int coffee = scanner.nextInt();
        System.out.println("Write how many disposable cups you want to add:");
        int cups = scanner.nextInt();

        CoffeeMaker.water += water;
        CoffeeMaker.milk += milk;
        CoffeeMaker.coffeeBeans += coffee;
        CoffeeMaker.disposableCups += cups;
    }

    public static void buyCoffee(Scanner scanner) {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String coffeeType = scanner.nextLine();

        int waterPerCup = 0;
        int milkPerCup = 0;
        int coffeePerCup = 0;
        int costPerCup = 0;

        switch (coffeeType) {
            case "1" -> {
                waterPerCup = 250;
                milkPerCup = 0;
                coffeePerCup = 16;
                costPerCup = 4;
            }
            case "2" -> {
                waterPerCup = 350;
                milkPerCup = 75;
                coffeePerCup = 20;
                costPerCup = 7;
            }
            case "3" -> {
                waterPerCup = 200;
                milkPerCup = 100;
                coffeePerCup = 12;
                costPerCup = 6;
            }
            case "back" -> {
                return;
            }
        }

        CoffeeMaker.water -= waterPerCup;
        CoffeeMaker.milk -= milkPerCup;
        CoffeeMaker.coffeeBeans -= coffeePerCup;
        CoffeeMaker.disposableCups -= 1;
        CoffeeMaker.money += costPerCup;


        if (CoffeeMaker.water < 0) {
            System.out.println("Sorry, not enough water!");
        }
        if (CoffeeMaker.milk < 0) {
            System.out.println("Sorry, not enough milk!");
        }
        if (CoffeeMaker.coffeeBeans < 0) {
            System.out.println("Sorry, not enough coffee beans!");
        }
        if (CoffeeMaker.disposableCups < 0) {
            System.out.println("Sorry, not enough disposable cups!");
        }
        if (CoffeeMaker.water >= 0 && CoffeeMaker.milk >= 0 && CoffeeMaker.coffeeBeans >= 0 && CoffeeMaker.disposableCups >= 0) {
            System.out.println("I have enough resources, making you a coffee!");
        } else {
            reverseTransaction(waterPerCup,
                    milkPerCup,
                    coffeePerCup,
                    costPerCup);
        }


//        int waterCups = water / 200;
//        int milkCups = milk / 50;
//        int coffeeCups = coffeeBeans / 15;

//        int minCups = Math.min(waterCups,
//                Math.min(milkCups,
//                        coffeeCups));
//
//        if (minCups == cups) {
//            System.out.println("Yes, I can make that amount of coffee");
//        } else if (minCups > cups) {
//            System.out.println("Yes, I can make that amount of coffee (and even " + (minCups - cups) + " more than that)");
//        } else {
//            System.out.println("No, I can make only " + minCups + " cup(s) of coffee");
//        }
    }

    public static void reverseTransaction(int waterPerCup, int milkPerCup, int coffeePerCup, int costPerCup) {
        CoffeeMaker.water += waterPerCup;
        CoffeeMaker.milk += milkPerCup;
        CoffeeMaker.coffeeBeans += coffeePerCup;
        CoffeeMaker.disposableCups += 1;
        CoffeeMaker.money -= costPerCup;
    }

    public static void printState() {
        System.out.println("The coffee machine has:");
        System.out.printf("%d ml of water%n",
                water);
        System.out.printf("%d ml of milk%n",
                milk);
        System.out.printf("%d g of coffee beans%n",
                coffeeBeans);
        System.out.printf("%d disposable cups%n",
                disposableCups);
        System.out.printf("$%d of money%n",
                money);
    }
}
