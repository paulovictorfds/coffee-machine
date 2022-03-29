package machine;
import java.util.Scanner;

public class CoffeeMachine {
    private int money = 550;
    private int water = 400;
    private int milk = 540;
    private int coffeeBeans = 120;
    private int disposableCups = 9;
    String action;
    Scanner scanner = new Scanner(System.in);

    public void chooseAction() {
        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            System.out.println();
            switch (action) {
                case "buy":
                    this.buy();
                    System.out.println();
                    break;
                case "fill":
                    this.fill();
                    System.out.println();
                    break;
                case "take":
                    this.take();
                    System.out.println();
                    break;
                case "remaining":
                    System.out.println(this);
                    System.out.println();
                    break;
                case "exit":
                    return;
                default:
                    System.out.println("Invalid option.");
                    System.out.println();
                    break;
            }
        }
    }

    private void fill() {
        System.out.println("Write how many ml of water you want to add:");
        this.water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        this.milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        this.coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        this.disposableCups += scanner.nextInt();
        scanner.nextLine();
    }

    private void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.nextLine();
        switch (option) {
            case "1":
                if (checkSupply(TypesOfCoffee.ESPRESSO)) {
                    break;
                }
                this.water -= TypesOfCoffee.ESPRESSO.getWater();
                this.coffeeBeans -= TypesOfCoffee.ESPRESSO.getCoffeeBeans();
                this.money += TypesOfCoffee.ESPRESSO.getCost();
                this.disposableCups -= 1;
                break;
            case "2":
                if (checkSupply(TypesOfCoffee.LATTE)) {
                    break;
                }
                this.water -= TypesOfCoffee.LATTE.getWater();
                this.milk -= TypesOfCoffee.LATTE.getMilk();
                this.coffeeBeans -= TypesOfCoffee.LATTE.getCoffeeBeans();
                this.money += TypesOfCoffee.LATTE.getCost();
                this.disposableCups -= 1;
                break;
            case "3":
                if (checkSupply(TypesOfCoffee.CAPPUCCINO)) {
                    break;
                }
                this.water -= TypesOfCoffee.CAPPUCCINO.getWater();
                this.milk -= TypesOfCoffee.CAPPUCCINO.getMilk();
                this.coffeeBeans -= TypesOfCoffee.CAPPUCCINO.getCoffeeBeans();
                this.money += TypesOfCoffee.CAPPUCCINO.getCost();
                this.disposableCups -= 1;
                break;
            case "back":
                break;
            default:
                System.out.println("Invalid Option.");
                break;
        }
    }

    private void take() {
        System.out.println("I gave you $" + this.money);
        this.money -= money;
    }

    private boolean checkSupply(TypesOfCoffee coffee) {
        if (this.water < coffee.getWater()) {
            System.out.println("Sorry, not enough water!");
            return true;
        } else if (this.milk < coffee.getMilk()) {
            System.out.println("Sorry, not enough milk!");
            return true;
        } else if (this.coffeeBeans < coffee.getCoffeeBeans()) {
            System.out.println("Sorry, not enough coffee beans!");
            return true;
        } else {
            System.out.println("I have enough resources, making you a coffee!");
            return false;
        }
    }

    @Override
    public String toString() {
        return "The coffee machine has:\n" +
                water + " ml of water\n" +
                milk + " ml of milk\n" +
                coffeeBeans + " g of coffee beans\n" +
                disposableCups + " disposable cups\n" +
                "$" + money + " of money";
    }
}
