package homework.bookStorage.storage;

import homework.bookStorage.model.Author;
import homework.bookStorage.model.Book;

public class BookStorage {

    private Book[] books = new Book[10];
    private int size;

    public void add(Book book) {
        if (books.length == size) {
            extendStorage();
        }
        books[size++] = book;
    }

    private void extendStorage() {
        Book[] tmp = new Book[size + 10];
        System.arraycopy(books, 0, tmp, 0, size);
        books = tmp;
    }

    public void print() {
        for (int i = 0; i < size; i++) {
            System.out.println(books[i]);
        }
    }

    public void searchByBookName(String keyword) {
        for (int i = 0; i < size; i++) {
            if (books[i].getTitle().contains(keyword)) {
                System.out.println(books[i]);
            }

        }
    }

    public Book getBookById(String id) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(id)) {
                return books[i];
            }

        }
        return null;
    }

    public void searchBookByPriceRange(double minPrice, double maxPrice) {
        double newMin = Math.min(minPrice, maxPrice);
        double newMax = Math.max(maxPrice, minPrice);
        for (int i = 0; i < size; i++) {
            Book book = books[i];
            if (book.getPrice() >= newMin && book.getPrice() <= newMax) {
                System.out.println(book);
            }
        }
    }

    public void deleteBookById(String bookId) {
        int index = getBookIndexById(bookId);
        if (index != -1) {
            for (int i = index + 1; i < size; i++) {
                books[i - 1] = books[i];
            }
            size--;
        }
    }

    private int getBookIndexById(String bookId) {
        for (int i = 0; i < size; i++) {
            if (books[i].getId().equals(bookId)) {
                return i;
            }
        }
        return -1;
    }

    public void searchByAuthor(Author author) {
        for (int i = 0; i < size; i++) {
            if (books[i].getAuthor().equals(author)){
                System.out.println(books[i]);
            }
        }
    }
}