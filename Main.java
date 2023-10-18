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
            System.out.println("4.State");
            System.out.println("Select an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice){
                case 1:
                    System.out.print("Enter coffee type (Espresso or Cappuccino): ");
                    String coffeeType = scanner.nextLine();

                    CoffeeDecorator coffee = new BasicCoffee();

                    System.out.print("Enter milk type (Almond, Regular, Coconut): ");
                    String milkType = scanner.nextLine();
                    coffee = new ExtraDecorator(coffee, "Milk (" + milkType + ")", 0.5);

                    System.out.print("Enter sugar type (White, Brown, Splenda): ");
                    String sugarType = scanner.nextLine();
                    coffee = new ExtraDecorator(coffee, "Sugar (" + sugarType + ")", 0.1);

                    System.out.print("Add syrup? (yes or no): ");
                    String addSyrup = scanner.nextLine();
                    if (addSyrup.equalsIgnoreCase("yes")) {
                        System.out.print("Add syrups (Vanilla, Caramel): ");
                        String syrupInput = scanner.nextLine();
                        String[] syrups = syrupInput.split(",");
                        for (String syrup : syrups) {
                            coffee = new ExtraDecorator(coffee, "Syrup (" + syrup.trim() + ")", 0.3);
                        }
                    }

                    System.out.print("Add cinnamon? (yes or no): ");
                    String addCinnamon = scanner.nextLine();
                    if (addCinnamon.equalsIgnoreCase("yes")) {
                        coffee = new ExtraDecorator(coffee, "Cinnamon", 0.2);
                    }

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

//                case 4:
//
//                     // Consume the newline character
//
//                    if (orderNumber >= 1 && orderNumber <= orders.size()) {
//                        order = orders.get(orderNumber - 1);
//                        System.out.println("Order " + orderNumber + " is in the state: " + order.getCurrentState());
//                    } else {
//                        System.out.println("Invalid order number.");
//                    }
//                    break;

                case 4:
                    System.out.print("Enter the order number to check its state: ");
                    int orderNumber = scanner.nextInt();
                    scanner.nextLine();
                    List<CoffeeOrder> orders = coffeeShop.getOrders();

                    for (int i = 0; i < orders.size(); i++) {
                        order = orders.get(i);
                        order.checkAndTransitionState(); // Проверить и выполнить автоматический переход состояний

                        System.out.println("Order " + (i + 1) + ":");
                        orders.get(i).printOrder();
                        System.out.println("-------------------------");
                    }
                    break;


                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
