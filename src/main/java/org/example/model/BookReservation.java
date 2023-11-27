package org.example.model;

import java.sql.Date;
import java.time.LocalDate;

public class BookReservation {
    private   LocalDate reserve_date;
    private LocalDate delivery_date;
    private long user_id;
    private  long book_id;

    public BookReservation(long user_id, long book_id, LocalDate reserve_date) {

        this.user_id = user_id;
        this.book_id = book_id;
        this.reserve_date=reserve_date;
    }
    public BookReservation( LocalDate delivery_date, long user_id, long book_id) {

        this.delivery_date = delivery_date;
        this.user_id = user_id;
        this.book_id = book_id;
    }
    public BookReservation()
    {}

    public LocalDate getReserve_date() {
        return reserve_date;
    }

    public void setReserve_date(LocalDate reserve_date) {
        this.reserve_date = reserve_date;
    }

    public LocalDate getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(LocalDate delivery_date) {
        this.delivery_date = delivery_date;
    }

    public long getUser_id() {
        return user_id;
    }

    public void setUser_id(long user_id) {
        this.user_id = user_id;
    }

    public long getBook_id() {
        return book_id;
    }

    public void setBook_id(long book_id) {
        this.book_id = book_id;
    }
}
