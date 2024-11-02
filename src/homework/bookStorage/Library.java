package homework.bookStorage;

import homework.bookStorage.model.Author;
import homework.bookStorage.model.Book;
import homework.bookStorage.model.Gender;
import homework.bookStorage.storage.AuthorStorage;
import homework.bookStorage.storage.BookStorage;
import homework.bookStorage.util.DateUtil;

import java.text.ParseException;
import java.util.Date;
import java.util.Scanner;

public class Library implements LibraryCommands {

    private static Scanner scanner = new Scanner(System.in);
    private static BookStorage bookStorage = new BookStorage();
    private static AuthorStorage authorStorage = new AuthorStorage();

    public static void main(String[] args) {
        //  bookStorage.add(new Book("A001", "Տերն ու ծառան", " Հովհաննես Թումանյան", 30, 1));
        //  bookStorage.add(new Book("A002", "Գիքորը", "Հովհաննես Թումանյան", 100, 3));
        //  bookStorage.add(new Book("A003", "Girq 1", "Poxos", 200, 5));

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
                case ADD_AUTHOR:
                    addAuthor();
                    break;
                case PRINT_ALL_BOOKS:
                    bookStorage.print();
                    break;
                case PRINT_ALL_AUTHORS:
                    authorStorage.print();
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
                case SEARCH_BOOK_BY_AUTHOR:
                    searchBookByAuthor();
                    break;
                case DELETE_BOOK_BY_ID:
                    deleteBookById();
                    break;
                default:
                    System.out.println("Wrong command!");
            }
        }
    }

    private static void searchBookByAuthor() {
        authorStorage.print();
        System.out.println("Please choose author ID");
        String authorId = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorId);
        if (author != null) {
            bookStorage.searchByAuthor(author);
        }
    }


    private static void addAuthor() {
        System.out.println("Please input id, name, surname, phone, dateOfBirthday(01-01-2000), gender(MALE,FEMALE)");
        String authorDataStr = scanner.nextLine();
        String[] authorDataArr = authorDataStr.split(",");
        if (authorDataArr.length == 6) {
            String id = authorDataArr[0];
            if (authorStorage.getAuthorById(id) == null) {
                try {
                    Author author = new Author();
                    author.setId(id);
                    author.setName(authorDataArr[1]);
                    author.setSurname(authorDataArr[2]);
                    author.setPhone(authorDataArr[3]);
                    author.setDateOfBirthday(DateUtil.fromStringToDate(authorDataArr[4]));
                    author.setGender(Gender.valueOf(authorDataArr[5]));
                    authorStorage.add(author);
                    System.out.println("Author added!!!");
                } catch (ParseException e) {
                    System.err.println("Date of Birthday is incorrect!!!");
                } catch (IllegalArgumentException e) {
                    System.out.println("Gender is invalid. Allowed values are MALE or FEMALE");
                }
            } else {
                System.out.println("Author with  " + id + " id already exists!");
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


    private static void searchBookByPriceRange() {
        System.out.println("Please input min-max prices:");
        String pricesStr = scanner.nextLine();
        String[] pricesArray = pricesStr.split("-");
        if (pricesArray.length == 2) {
            try {
                double min = Double.parseDouble(pricesArray[0]);
                double max = Double.parseDouble(pricesArray[1]);
                bookStorage.searchBookByPriceRange(min, max);
            } catch (NumberFormatException e) {
                System.err.println("Please input only digits!");
            }
        }
    }


    private static void updateBook() {
        bookStorage.print();
        System.out.println("Please input book ID");
        String bookId = scanner.nextLine();
        Book bookById = bookStorage.getBookById(bookId);
        if (bookById != null) {
            authorStorage.print();
            System.out.println("Please choose author ID");
            String authorId = scanner.nextLine();
            Author author = authorStorage.getAuthorById(authorId);
            if (author != null) {
                System.out.println("Please input book's new title");
                String title = scanner.nextLine();
                System.out.println("Please input book's new price ");
                String priceStr = scanner.nextLine();
                System.out.println("Please input book's new quantity ");
                String quantityStr = scanner.nextLine();
                int quantity = Integer.parseInt(quantityStr);
                if (title != null && !title.isEmpty()) {
                    bookById.setTitle(title);
                }
                bookById.setAuthor(author);

                if (priceStr != null && !priceStr.isEmpty()) {
                    bookById.setPrice(Double.parseDouble(priceStr));
                }
                if (!quantityStr.isEmpty()) {
                    bookById.setQuantity(quantity);
                }
                System.out.println("Update was successfully");
            }
        }
    }


    private static void searchBookByName() {
        System.out.println("Please input book keyword");
        String keyword = scanner.nextLine();
        bookStorage.searchByBookName(keyword);
    }

    private static void addBook() {
        authorStorage.print();
        System.out.println("Please choose author ID");
        String authorID = scanner.nextLine();
        Author author = authorStorage.getAuthorById(authorID);
        if (author != null) {
            System.out.println("Please input book id");
            String id = scanner.nextLine();
            System.out.println("Please input book title");
            String title = scanner.nextLine();
            System.out.println("Please input book price ");
            double price = Double.parseDouble(scanner.nextLine());
            System.out.println("Please input book's quantity ");
            int quantity = Integer.parseInt(scanner.nextLine());
            Book book = new Book(id, title, author, price, quantity, new Date());
            Book bookById = bookStorage.getBookById(id);
            if (bookById == null) {
                bookStorage.add(book);
                System.out.println("Book added!");
            } else {
                System.err.println("Book with " + id + " id already exists!");
            }
        } else {
            System.err.println(" Wrong author id! ");
        }
    }
}
