package homework.bookStorage;

public interface LibraryCommands {

    String EXIT = "0";
    String ADD_BOOK = "1";
    String ADD_AUTHOR = "2";
    String PRINT_ALL_BOOKS = "3";
    String PRINT_ALL_AUTHORS = "4";
    String SEARCH_BOOK_BY_NAME = "5";
    String UPDATE_BOOK = "6";
    String SEARCH_BOOK_BY_PRICE_RANGE = "7";
    String DELETE_BOOK_BY_ID = "8";
    String SEARCH_BOOK_BY_AUTHOR = "9";

    static void printCommands() {
        System.out.println("Please input " + EXIT + " for EXIT");
        System.out.println("Please input " + ADD_BOOK + " for ADD_BOOK");
        System.out.println("Please input " + ADD_AUTHOR + " for ADD_AUTHOR");
        System.out.println("Please input " + PRINT_ALL_BOOKS + " for PRINT_ALL_BOOKS");
        System.out.println("Please input " + PRINT_ALL_AUTHORS + " for PRINT_ALL_AUTHORS");
        System.out.println("Please input " + SEARCH_BOOK_BY_NAME + " for SEARCH_BOOK_BY_NAME");
        System.out.println("Please input " + UPDATE_BOOK + " for UPDATE_BOOK ");
        System.out.println("Please input " + SEARCH_BOOK_BY_PRICE_RANGE + " for SEARCH_BOOK_BY_PRICE_RANGE");
        System.out.println("Please input " + DELETE_BOOK_BY_ID + " for DELETE_BOOK_BY_ID");
        System.out.println("Please input " + SEARCH_BOOK_BY_AUTHOR + " for SEARCH_BOOK_BY_AUTHOR");
    }
}
