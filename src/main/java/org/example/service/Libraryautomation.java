package org.example.service;


import org.example.model.Book;
import org.example.model.User;
import org.example.model.UserInfo;
import org.example.service.DAO.BookDAO;
import org.example.service.DAO.UserDAO;
import org.example.service.DAO.UserInfoDAO;

import java.sql.SQLException;
import java.util.List;

public class Libraryautomation {
    private static Libraryautomation libraryautomation;

    UserDAO userDAO = new UserDAO();
    UserInfoDAO userInfoDAO = new UserInfoDAO();
    BookDAO bookDAO = new BookDAO();


    private Libraryautomation(){

    }

    public static Libraryautomation getInstance(){

        if (libraryautomation == null){
            libraryautomation = new Libraryautomation();

        }
        return libraryautomation;
    }


    public void addUser(User user) throws SQLException {

        userDAO.insert(user);

    }

    public void addBook(Book book) throws SQLException {

        bookDAO.insert(book);

    }
    public void addUserInfo(UserInfo userInfo) throws SQLException {

        userInfoDAO.insert(userInfo);

    }


    public void borrowBook(Book book) throws Exception {
        bookDAO.borrowBook(book);

    }

    public void returnBook(Book book) throws SQLException {
        bookDAO.returnBook(book);

    }

    public List<Book> getListOfBorrowBookByMemberId(Long memberId) throws SQLException {

        return bookDAO.findListOfBorrowBookByMemberId(memberId);

    }



    public User getMemberWhoBorrowBook(String name) throws Exception {

        Book book = bookDAO.findByName(name);

        if (book.getMember() == null){

            throw new Exception("this book is not borrow .....");
        }
        return userDAO.select(book.getMember());

    }


}
