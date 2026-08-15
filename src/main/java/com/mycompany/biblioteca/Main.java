package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
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
}
