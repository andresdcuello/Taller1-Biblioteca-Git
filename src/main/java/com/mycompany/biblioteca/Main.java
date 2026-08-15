package com.mycompany.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;
import java.time.LocalDate;
public class Main {
    static ArrayList<Client> clients = new ArrayList<>();
    static ArrayList<Book> books = new ArrayList<>();
    static ArrayList<Loan> loans = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
    int option;
    do {
        System.out.println("\n===== LIBRARY MANAGEMENT SYSTEM =====");
        System.out.println("1. Register client");
        System.out.println("2. List clients");
        System.out.println("3. Search client");
        System.out.println("4. Update client");
        System.out.println("5. Delete client");
        System.out.println("6. Register book");
        System.out.println("7. List books");
        System.out.println("8. Search book");
        System.out.println("9. Update book");
        System.out.println("10. Delete book");
        System.out.println("11. Register loan");
        System.out.println("12. Return book");
        System.out.println("13. List active loans");
        System.out.println("0. Exit");
        System.out.print("Choose an option: ");
        option = Integer.parseInt(sc.nextLine());

        switch (option) {
            case 1 -> createClient();
            case 2 -> listClients();
            case 3 -> {
                System.out.print("Enter client ID: ");
                Client c = searchClient(sc.nextLine());
                System.out.println(c != null ? c : "Client not found.");
            }
            case 4 -> {
                System.out.print("Enter client ID: ");
                updateClient(sc.nextLine());
            }
            case 5 -> {
                System.out.print("Enter client ID: ");
                deleteClient(sc.nextLine());
            }
            case 6 -> createBook();
            case 7 -> listBooks();
            case 8 -> {
                System.out.print("Enter book code: ");
                Book b = searchBook(sc.nextLine());
                System.out.println(b != null ? b : "Book not found.");
            }
            case 9 -> {
                System.out.print("Enter book code: ");
                updateBook(sc.nextLine());
            }
            case 10 -> {
                System.out.print("Enter book code: ");
                deleteBook(sc.nextLine());
            }
            case 11 -> createLoan();
            case 12 -> {
                System.out.print("Enter loan ID: ");
                returnLoan(sc.nextLine());
            }
            case 13 -> listLoans();
            case 0 -> System.out.println("Goodbye!");
            default -> System.out.println("Invalid option.");
        }
    } while (option != 0);
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
    public static void deleteBook(String code) {
    Book b = searchBook(code);
    if (b == null) {
        System.out.println("Book not found.");
        return;
    }
    books.remove(b);
    System.out.println("Book successfully deleted.");
}
    public static void createLoan() {
    System.out.println("--- Register New Loan ---");
    System.out.print("Loan ID: ");
    String loanId = sc.nextLine();
    System.out.print("Client ID: ");
    String clientId = sc.nextLine();
    Client client = searchClient(clientId);
    if (client == null) {
        System.out.println("Client not found.");
        return;
    }
    System.out.print("Book code: ");
    String bookCode = sc.nextLine();
    Book book = searchBook(bookCode);
    if (book == null) {
        System.out.println("Book not found.");
        return;
    }
    if (!book.isAvailable()) {
        System.out.println("Book is not available.");
        return;
    }

    Loan loan = new Loan(loanId, client, book, LocalDate.now(), "ACTIVE");
    loans.add(loan);
    book.setAvailable(false);
    System.out.println("Loan successfully registered.");
}
    public static void returnLoan(String loanId) {
    for (Loan l : loans) {
        if (l.getLoanId().equals(loanId)) {
            if (l.getStatus().equals("RETURNED")) {
                System.out.println("This loan was already returned.");
                return;
            }
            l.setStatus("RETURNED");
            l.getBook().setAvailable(true);
            System.out.println("Book successfully returned.");
            return;
        }
    }
    System.out.println("Loan not found.");
}
    public static void listLoans() {
    boolean hasActive = false;
    System.out.println("--- Active Loans ---");
    for (Loan l : loans) {
        if (l.getStatus().equals("ACTIVE")) {
            System.out.println(l);
            hasActive = true;
        }
    }
    if (!hasActive) {
        System.out.println("No active loans.");
    }
}
}
