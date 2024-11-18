package org.example.authorbookee.service;




import org.example.authorbookee.db.DBConnectionProvider;
import org.example.authorbookee.model.Author;
import org.example.authorbookee.model.Book;
import org.example.authorbookee.util.DateUtil;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class BookService {

    private Connection connection = DBConnectionProvider.getInstance().getConnection();
    private AuthorService authorService = new AuthorService();

    public void add(Book book) {
        String sql = """
                INSERT INTO book(title,price,quantity,author_id,created_at)
                VALUES ('%s',%f,%d,%d,'%s')
                """.formatted(
                book.getTitle(),
                book.getPrice(),
                book.getQuantity(),
                book.getAuthor().getId(),
                DateUtil.fromDateToSqlDateTimeString(book.getCreatedAt()));
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql, Statement.RETURN_GENERATED_KEYS);
            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                int anInt = generatedKeys.getInt(1);
                book.setId(anInt);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public List<Book> getAllBooks() {
        String sql = "SELECT * FROM book";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setCreatedAt(DateUtil.fromSqlStringToDate(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<Book> searchByBookName(String keyword) {
        String sql = "SELECT * FROM book WHERE title LIKE '%" + keyword + "%'";
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Book getBookById(int id) {
        String sql = "SELECT * FROM book WHERE id = " + id;
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void deleteBookById(int bookId) {
        String sql = "DELETE FROM book Where id = " + bookId;
        try {
            Statement statement = connection.createStatement();
            statement.executeUpdate(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public List<Book> searchBookByPriceRange(double minPrice, double maxPrice) {
        String sql = "SELECT * FROM book WHERE price BETWEEN " + minPrice + " AND " + maxPrice;
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return result;
    }


    public List<Book> searchByAuthor(Author author) {
        String sql = "SELECT * FROM book WHERE author_id = " + author.getId();
        List<Book> result = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()) {
                Book book = new Book();
                book.setId(resultSet.getInt("id"));
                book.setTitle(resultSet.getString("title"));
                book.setPrice(resultSet.getDouble("price"));
                book.setQuantity(resultSet.getInt("quantity"));
                book.setCreatedAt(DateUtil.fromSqlStringToDateTime(resultSet.getString("created_at")));
                book.setAuthor(authorService.getAuthorById(resultSet.getInt("author_id")));
                result.add(book);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
         return result;
    }
}
