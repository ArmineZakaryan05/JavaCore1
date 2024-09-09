package homework.bookStorage;

import java.util.Scanner;

public class Library implements LibraryCommands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();

    public static void main(String[] args) {
        bookStorage.add(new Book("A001", "Տերն ու ծառան", " Հովհաննես Թումանյան", 30, 1));
        bookStorage.add(new Book("A002", "Գիքորը", "Հովհաննես Թումանյան", 100, 3));
        bookStorage.add(new Book("A003", "Girq 1", "Poxos", 200, 5));
        boolean isRun = true;
        while (isRun) {
            LibraryCommands.printCommands();
            String command = scanner.nextLine();
            switch (command) {
                case EXIT:
                    isRun = false;
                    break;
                case ADD_BOOK:
                    addBook();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case SEARCH_BOOK_BY_NAME:
                    searchBookByName();
                    break;
                case UPDATE_BOOK:
                    updateBook();
                    break;
                case SEARCH_BOOK_BY_PRICE_RANGE:
                    searchBookByPriceRange();
                    break;
                case DELETE_BOOK_BY_ID:
                    deleteBookById();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }


    private static void deleteBookById() {
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById == null) {
            System.err.println("Book with  " + bookId + " ID does not exists!!! ");
            return;
        }
        bookStorage.deleteBookById(bookId);
    }


    private static void updateBook() {
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById != null) {
            System.out.println("Please input book's new title");
            String title = scanner.nextLine();
            System.out.println("Please input author's new name ");
            String authorName = scanner.nextLine();
            System.out.println("Please input book's new price ");
            String priceStr = scanner.nextLine();
            System.out.println("Please input book's new quantity ");
            String quantityStr = scanner.nextLine();
            int quantity = Integer.parseInt(quantityStr);
            if (title != null && !title.isEmpty()) {
                bookById.setTitle(title);
            }
            if (authorName != null && !authorName.isEmpty()) {
                bookById.setAuthorName(authorName);
            }
            if (priceStr != null && !priceStr.isEmpty()) {
                bookById.setPrice(Double.parseDouble(priceStr));
            }
            if (!quantityStr.isEmpty()) {
                bookById.setQuantity(quantity);
            }
            System.out.println("Update was successfully");

        }
    }

    private static void searchBookByPriceRange() {
        System.out.println("Please input min-max prices:");
        String pricesStr = scanner.nextLine();
        String[] pricesArray = pricesStr.split("-");
        if (pricesArray.length == 2) {
            double min = Double.parseDouble(pricesArray[0]);
            double max = Double.parseDouble(pricesArray[1]);
            bookStorage.searchBookByPriceRange(min, max);
        }
    }

    private static void searchBookByName() {
        System.out.println("Please input book keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchByBookName(keyword);
    }

    private static void addBook() {
        System.out.println("Please input book id");
        String id = scanner.nextLine();
        System.out.println("Please input book title");
        String title = scanner.nextLine();
        System.out.println("Please input author's name ");
        String authorName = scanner.nextLine();
        System.out.println("Please input book price ");
        double price = Double.parseDouble(scanner.nextLine());
        System.out.println("Please input book's quantity ");
        int quantity = Integer.parseInt(scanner.nextLine());
        Book book = new Book(id, title, authorName, price, quantity);
        Book bookById = bookStorage.getBookById(id);
        if (bookById == null) {
            bookStorage.add(book);
            System.out.println("Book added!");
        } else {
            System.err.println("Book with " + id + " id already exists!");
        }
    }

}
