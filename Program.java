import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import entities.enums.OrderStatus;


public class Program {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter client data:");
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Email: ");
        String email = sc.next();
        System.out.println("Birth date (DD/MM/YYYY)");
        Date birthDate = sdf.parse(sc.next());
        
        Client cli = new Client(name, email, birthDate);
        
        System.out.println("Enter order data:\n");
        System.out.println("Option: PEDING_PAYMENT, PROCESSING, SHIPPED, DELIVERED");
        System.out.print("Status: ");
        OrderStatus status = OrderStatus.valueOf(sc.next());

        
        Order order = new Order(new Date(),status, cli);

        System.out.print("How many item to this order? ");
        int n = sc.nextInt();
        for (int i = 1; i<=n; i++){
            System.out.println("Enter #" + i + " item data");
            System.out.println("Product name: ");
            sc.nextLine();
            String productName = sc.nextLine();
            System.out.print("Product price: ");
            double productPrice = sc.nextDouble();
            System.out.println("Quantity: ");
            int quantity = sc.nextInt();

            Product product = new Product(productName,productPrice);
            OrderItem it = new OrderItem(quantity,productPrice,product);

            order.addItems(it);


        }

        System.out.println();
        System.out.println(order);

        sc.close();

    }
}