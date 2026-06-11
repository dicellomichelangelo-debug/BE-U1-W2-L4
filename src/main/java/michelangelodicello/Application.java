package michelangelodicello;

import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        Random idCasuale = new Random();

        Product p1 = new Product(idCasuale.nextInt(10000), "Harry Potter", "Books", 129.99);
        Product p2 = new Product(idCasuale.nextInt(10000), "Il Signore degli Anelli", "Books", 15.50);
        Product p3 = new Product(idCasuale.nextInt(10000), "Biberon Anticolica", "Baby", 12.00);
        Product p4 = new Product(idCasuale.nextInt(10000), "Passeggino", "Baby", 120.00);
        Product p5 = new Product(idCasuale.nextInt(10000), "T-Shirt", "Boys", 19.99);

        List<Product> prodotti = new ArrayList<>(List.of(p1, p2, p3, p4, p5));

        Customer c1 = new Customer(idCasuale.nextInt(10000), "Mario Rossi", 1);
        Customer c2 = new Customer(idCasuale.nextInt(10000), "Luigi Bianchi", 2);
        Customer c3 = new Customer(idCasuale.nextInt(10000), "Anna Verdi", 2);

        List<Customer> clienti = new ArrayList<>(List.of(c1, c2, c3));

        Order o1 = new Order(idCasuale.nextInt(10000), "DELIVERED", LocalDate.now().minusDays(5), LocalDate.now().minusDays(2), List.of(p1, p2), c1);
        Order o2 = new Order(idCasuale.nextInt(10000), "PENDING", LocalDate.now().minusDays(1), LocalDate.now().plusDays(2), List.of(p3, p4), c2);
        Order o3 = new Order(idCasuale.nextInt(10000), "DELIVERED", LocalDate.now().minusDays(10), LocalDate.now().minusDays(7), List.of(p1, p5), c3);

        List<Order> ordini = new ArrayList<>(List.of(o1, o2, o3));

        System.out.println("---Esercizio 1---");

        // Raggruppare gli ordini per cliente utilizzando Stream e Lambda Expressions. Crea una mappa in cui la chiave
        // è il cliente e il valore è una lista di ordini effettuati da quel cliente

        Map<Customer, List<Order>> orderByClient = ordini.stream().collect(Collectors.groupingBy(Order::getCustomer));
        orderByClient.forEach((customer, order) -> System.out.println("Cliente: " + customer + "Order: " + order));

        System.out.println("---Esercizio 2---");

        // Dato un elenco di ordini, calcola il totale delle vendite per ogni cliente utilizzando Stream e Lambda Expressions. Crea una mappa in cui la chiave
        // è il cliente e il valore è l'importo totale dei suoi acquisti (Tip: potrebbe essere molto utile avere all'interno della classe Order un metodo
        // calculateTotal() che ci dia il totale dei prodotti ordinati)

        Map<Customer, Double> sumOrderClient = ordini.stream().collect(Collectors.groupingBy(Order::getCustomer, Collectors.summingDouble(Order::calcolateTot)));
        sumOrderClient.forEach((customer, sum) -> System.out.println("Cliente: " + customer + "Spesa totale: " + sum));

        System.out.println("---Esercizio 3---");

        // Dato un elenco di prodotti, trova i prodotti più costosi utilizzando Stream e Lambda Expressions

        List<Product> prodottiCostosi = prodotti.stream().sorted(Comparator.comparingDouble(Product::getPrice).reversed()).limit(2).toList();
        prodottiCostosi.forEach(System.out::println);

        System.out.println("---Esercizio 4---");

        // Dato un elenco di ordini, calcola la media degli importi degli ordini utilizzando Stream e Lambda Expressions

        OptionalDouble mediaOrdini = ordini.stream().mapToDouble(Order::calcolateTot).average();
        if (mediaOrdini.isPresent()) System.out.println("La media degli ordini è: " + mediaOrdini.getAsDouble());
        else System.out.println("La media non è possibile");

        System.out.println("---Esercizio 5---");

        // Dato un elenco di prodotti, raggruppa i prodotti per categoria e calcola la somma degli importi per ogni categoria utilizzando Stream e Lambda Expressions
        
        Map<String, Double> totalePerCategoria = prodotti.stream().collect(Collectors.groupingBy(Product::getCategory, Collectors.summingDouble(Product::getPrice)));
        totalePerCategoria.forEach((categoria, tot) -> System.out.println("Categoria: " + categoria + " Prezzo totale: " + tot));
    }
}
