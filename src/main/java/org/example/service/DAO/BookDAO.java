package org.example.service.DAO;

import org.example.service.DAO.BasicDAO;
import org.example.model.Book;
import org.example.model.enums.BookType;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDAO extends BasicDAO<Book> {
    @Override
    public Book select(Long id) throws Exception {

        PreparedStatement preparedStatement = connection.prepareStatement("select * from book where id=?");
        preparedStatement.setLong(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();

        resultSet.wasNull();
        resultSet.next();


        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("arthur"));
        book.setBookType((Enum.valueOf(BookType.class, resultSet.getString("bookType"))));
        book.setMember(resultSet.getLong("fk_member_id"));

        return book;
    }

    @Override
    public void insert(Book book) throws SQLException {
        PreparedStatement preparedStatement=connection.prepareStatement("insert into book (id,name,author,bookType)values (?,?,?,?)");

        preparedStatement.setLong(1,book.getId());
        preparedStatement.setString(2,book.getName());
        preparedStatement.setString(3,book.getAuthor());
        preparedStatement.setObject(4,book.getBookType().name());
        preparedStatement.executeUpdate();
        System.out.println("addbook success");
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(Book book) {

    }


    public void borrowBook(Book book) throws Exception {

        if (findByName(book.getName()).getMember()!=null){

            throw  new Exception("this book already taken");
        }

        PreparedStatement preparedStatement = connection.prepareStatement("update book set fk_member_id = ? where id = ?");

        preparedStatement.setLong(1, book.getMember());
        preparedStatement.setLong(2, book.getId());

        preparedStatement.executeUpdate();

    }

    public void returnBook(Book book) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("update book set memberId = NULL where id = ?");
        preparedStatement.setLong(1, book.getId());

        preparedStatement.executeUpdate();

    }


    public List<Book> findListOfBorrowBookByMemberId(Long memberId) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("select * from book where memberId = ?");

        preparedStatement.setLong(1, memberId);

        ResultSet resultSet = preparedStatement.executeQuery();


        List<Book> books = new ArrayList<>();
        while (resultSet.next()){

            Book book = new Book();
            book.setId(resultSet.getLong("id"));
            book.setName(resultSet.getString("name"));
            book.setAuthor(resultSet.getString("author"));
            book.setBookType((Enum.valueOf(BookType.class, resultSet.getString("bookType"))));
            book.setMember(resultSet.getLong("memberId"));

            books.add(book);

        }

        return books;
    }

    public Book findByName(String name) throws Exception {
        PreparedStatement preparedStatement = connection.prepareStatement("select * from book where name = ?");

        preparedStatement.setString(1, name);

        ResultSet resultSet = preparedStatement.executeQuery();

        try {
            resultSet.next();
            resultSet.wasNull();
        }catch (Exception e) {
            throw new Exception("there is no book with this name in DB");
        }




        Book book = new Book();
        book.setId(resultSet.getLong("id"));
        book.setName(resultSet.getString("name"));
        book.setAuthor(resultSet.getString("author"));
        book.setBookType((Enum.valueOf(BookType.class, resultSet.getString("bookType"))));
        book.setMember(resultSet.getLong("memberId"));



        return book;

    }
}
