import java.util.Scanner;

class library_function {

    String available_books[] = new String[100];
    int count = 0;
    String issued_books[] = new String[100];
    int issuedCount = 0;

    public void addBook(String bookname) {
        available_books[count] = bookname;
        count++;
        System.out.println("Book added successfully!");
    }

    public void issueBook(String issuedbook) {
        for (int i = 0; i < count; i++) {
            if (available_books[i] != null && available_books[i].equalsIgnoreCase(issuedbook)) {
                available_books[i] = null;
                issued_books[issuedCount] = issuedbook;
                issuedCount++;
                System.out.println("Book issued successfully!");
                return; //
            }
        }
        System.out.println("Book not available!");
    }

    public void showAvailableBooks() {
        boolean found = false;
        for (int i = 0; i < count; i++) {
            if (available_books[i] != null) {
                System.out.println("- " + available_books[i]);
                found = true;
            }
        }
        if (!found) System.out.println("No books available.");
    }

    public void returnBook(String book) {
        for (int i = 0; i < issuedCount; i++) {
            if (issued_books[i] != null && issued_books[i].equalsIgnoreCase(book)) {
                issued_books[i] = null;
                available_books[count] = book; // put back
                count++;
                System.out.println("Book returned successfully!");
                return;
            }
        }
        System.out.println("This book was not issued from our library.");
    }
    public void showIssuedBooks() {
        if(issuedCount > 0) {
            for (int i = 0; i < issuedCount; i++) {
                System.out.println("- " + issued_books[i]);
            }
        }
        else  {
            System.out.println("No issued books available.");
        }
    }
}

public class Library_management extends library_function {
    public static void main(String[] args) {
        library_function recipient = new library_function();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Library Menu ---");
            System.out.println("1. Add Book");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Show Available Books");
            System.out.println("5. show issued books");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 6) break;

            switch (choice) {
                case 1:
                    System.out.print("Enter the book name: ");
                    String bookname = sc.nextLine();
                    recipient.addBook(bookname);
                    break;
                case 2:
                    System.out.print("Which book do you need: ");
                    String issuebook = sc.nextLine();
                    recipient.issueBook(issuebook);
                    break;
                case 3:
                    System.out.print("Which book do you want to return: ");
                    String returnbook = sc.nextLine();
                    recipient.returnBook(returnbook);
                    break;
                case 4:
                    recipient.showAvailableBooks();
                    break;
                case 5:
                    recipient.showIssuedBooks();
                    break;
                default:
                    System.out.println("Invalid choice, try again.");
            }
        }

        System.out.println("Goodbye!");
        sc.close();
    }
}