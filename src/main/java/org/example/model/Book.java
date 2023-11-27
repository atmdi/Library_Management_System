package org.example.model;

import org.example.model.enums.BookType;

public class Book extends BasicModel{

    private  BookType bookType;
    private String author;

    private  Long member;

 public Book(){

 }



    public Book(Long id, String name, BookType bookType, String author, Long member) {
        super(id, name);
        this.bookType = bookType;
        this.author = author;
        this.member = member;
    }

    public BookType getBookType() {
        return bookType;
    }

    public void setBookType(BookType bookType) {
        this.bookType = bookType;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Long getMember() {
        return member;
    }

    public void setMember(Long member) {
        this.member = member;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookType=" + bookType +
                ", author='" + author + '\'' +
                ", member=" + member +
                '}';
    }
}
