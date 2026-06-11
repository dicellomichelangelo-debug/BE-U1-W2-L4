package michelangelodicello;

import entities.Customer;
import entities.Order;
import entities.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

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

        
        System.out.println("---Esercizio 2---");
        System.out.println("---Esercizio 3---");
        System.out.println("---Esercizio 4---");
        System.out.println("---Esercizio 5---");
    }
}
