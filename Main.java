import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        CoffeeShop coffeeShop = CoffeeShop.getInstance();

        while (true){
            System.out.println("CoffeeShop Console App");
            System.out.println("1. Create Order");
            System.out.println("2. View Orders");
            System.out.println("3. Exit");
            System.out.println("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter coffee type (Espresso or Cappuccino): ");
                    String coffeeType = scanner.nextLine();

                    CoffeeDecorator coffee = new BasicCoffee();
                    coffee = new ExtraDecorator(coffee, "Milk", 0.5);
                    coffee=new ExtraDecorator(coffee, "Sugar", 0.3);

                    CoffeeOrder order = new CoffeeOrder(coffeeType, coffee);

                    coffeeShop.addOrder(order);
                    System.out.println("Order created.");
                    break;

                case 2:
                    System.out.println("Orders:");
                    List<CoffeeOrder> ordersList = coffeeShop.getOrders();
                    for (int i=0; i<ordersList.size();i++){
                        System.out.println("Order "+(i+1)+":");
                        ordersList.get(i).printOrder();
                        System.out.println("----------------------");
                    }
                    break;

                case 3:
                    System.out.println("Existing CoffeeShopApp. Have a nice day!");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}