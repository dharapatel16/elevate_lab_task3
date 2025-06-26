import java.util.*;

public class LibraryManagementSimple {

    static class Book {
        String title;
        boolean isIssued;

        Book(String title) {
            this.title = title;
            this.isIssued = false;
        }

        public String toString() {
            return title + (isIssued ? " [Issued]" : " [Available]");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Book> books = new ArrayList<>();

        books.add(new Book("Java Basics"));
        books.add(new Book("OOP in Java"));
        books.add(new Book("Data Structures"));

        while (true) {
            System.out.println("\nLibrary Menu:");
            System.out.println("1. Show Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            
            // Defensive: check if next input is int
            if (!sc.hasNextInt()) {
                System.out.println("Please enter a valid number.");
                sc.nextLine(); // clear buffer
                continue;
            }

            int choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            if (choice == 1) {
                System.out.println("\nBooks in Library:");
                int i = 1;
                for (Book b : books) {
                    System.out.println(i++ + ". " + b);
                }

            } else if (choice == 2) {
                System.out.print("Enter book title to issue: ");
                String title = sc.nextLine().trim();
                boolean found = false;

                for (Book b : books) {
                    if (b.title.equalsIgnoreCase(title)) {
                        found = true;
                        if (!b.isIssued) {
                            b.isIssued = true;
                            System.out.println("Book issued successfully.");
                        } else {
                            System.out.println("Book is already issued.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }

            } else if (choice == 3) {
                System.out.print("Enter book title to return: ");
                String title = sc.nextLine().trim();
                boolean found = false;

                for (Book b : books) {
                    if (b.title.equalsIgnoreCase(title)) {
                        found = true;
                        if (b.isIssued) {
                            b.isIssued = false;
                            System.out.println("Book returned successfully.");
                        } else {
                            System.out.println("Book was not issued.");
                        }
                        break;
                    }
                }
                if (!found) {
                    System.out.println("Book not found.");
                }

            } else if (choice == 4) {
                System.out.println("Goodbye!");
                break;

            } else {
                System.out.println("Invalid choice. Please select from the menu.");
            }
        }

        sc.close();
    }
}
