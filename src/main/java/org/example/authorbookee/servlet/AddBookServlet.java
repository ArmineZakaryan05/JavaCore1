package org.example.authorbookee.servlet;

import org.example.authorbookee.model.Author;
import org.example.authorbookee.model.Book;
import org.example.authorbookee.service.AuthorService;
import org.example.authorbookee.service.BookService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@WebServlet("/addBook")
public class AddBookServlet extends HttpServlet {

    private AuthorService authorService = new AuthorService();
    private BookService bookService =new BookService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Author> authors = authorService.getAllAuthors();
        req.setAttribute("authors", authors);
        req.getRequestDispatcher("/addBook.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String title = req.getParameter("title");
        double price = Double.parseDouble(req.getParameter("price"));
        int quantity = Integer.parseInt(req.getParameter("quantity"));
        int authorId = Integer.parseInt(req.getParameter("author_id"));

        Book book = Book.builder()
                .title(title)
                .price(price)
                .quantity(quantity)
                .author(authorService.getAuthorById(authorId))
                .createdAt(new Date())
                .build();

        bookService.add(book);
        resp.sendRedirect("/books");
    }
}