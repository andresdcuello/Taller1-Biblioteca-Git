package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        // Aquí irá el menú (Fase 8)
    }
    public static void createClient() {
    System.out.println("--- Register New Client ---");
    System.out.print("ID: ");
    String id = sc.nextLine();
    System.out.print("Name: ");
    String name = sc.nextLine();
    System.out.print("Phone: ");
    String phone = sc.nextLine();
    System.out.print("Email: ");
    String email = sc.nextLine();

    Client client = new Client(id, name, phone, email);
    clients.add(client);
    System.out.println("Client successfully registered.");
}
    public static void listClients() {
    if (clients.isEmpty()) {
        System.out.println("No clients registered.");
        return;
    }
    System.out.println("--- Client List ---");
    for (Client c : clients) {
        System.out.println(c);
    }
}
    public static Client searchClient(String id) {
    for (Client c : clients) {
        if (c.getId().equals(id)) {
            return c;
        }
    }
    return null;
}
    public static void updateClient(String id) {
    Client c = searchClient(id);
    if (c == null) {
        System.out.println("Client not found.");
        return;
    }
    System.out.println("--- Update Client ---");
    System.out.print("New name (current: " + c.getName() + "): ");
    c.setName(sc.nextLine());
    System.out.print("New phone (current: " + c.getPhone() + "): ");
    c.setPhone(sc.nextLine());
    System.out.print("New email (current: " + c.getEmail() + "): ");
    c.setEmail(sc.nextLine());
    System.out.println("Client successfully updated.");
}
    public static void deleteClient(String id) {
    Client c = searchClient(id);
    if (c == null) {
        System.out.println("Client not found.");
        return;
    }
    clients.remove(c);
    System.out.println("Client successfully deleted.");
}
    public static void createBook() {
    System.out.println("--- Register New Book ---");
    System.out.print("Code: ");
    String code = sc.nextLine();
    System.out.print("Title: ");
    String title = sc.nextLine();
    System.out.print("Publication Year: ");
    int year = Integer.parseInt(sc.nextLine());
    System.out.print("Author: ");
    String author = sc.nextLine();

    Book book = new Book(code, title, year, author);
    books.add(book);
    System.out.println("Book successfully registered.");
}
    public static void listBooks() {
    if (books.isEmpty()) {
        System.out.println("No books registered.");
        return;
    }
    System.out.println("--- Book List ---");
    for (Book b : books) {
        System.out.println(b);
    }
}
    public static Book searchBook(String code) {
    for (Book b : books) {
        if (b.getCode().equals(code)) {
            return b;
        }
    }
    return null;
}
    public static void updateBook(String code) {
    Book b = searchBook(code);
    if (b == null) {
        System.out.println("Book not found.");
        return;
    }
    System.out.println("--- Update Book ---");
    System.out.print("New title (current: " + b.getTitle() + "): ");
    b.setTitle(sc.nextLine());
    System.out.print("New author (current: " + b.getAuthor() + "): ");
    b.setAuthor(sc.nextLine());
    System.out.println("Book successfully updated.");
}
    
}
