package homework.bookStorage;

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
        boolean found = false;
        for (int i = 0; i < size; i++) {
            if (books[i].getPrice() >= minPrice && books[i].getPrice() <= maxPrice) {
                System.out.println(books[i]);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No books found in the price range " + minPrice + " to " + maxPrice);
        }

    }

    public boolean deleteBookById(String bookId) {
        int count = 0;

        for (Book book : books) {
            if (book.getId().equals(bookId)) {
                break;
            }
            count++;

        }
        if (count == books.length) {
            return false;
        }
        Book[] newBooks = new Book[books.length - 1];
        int index = 0;

        for (int i = 0; i < books.length; i++) {
            if (i != count) {
                newBooks[index++] = books[i];
            }

        }
        books = newBooks;
        return true;
    }
}
