package org.example.service.DAO;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class BasicDAO<T> {
    public Connection connection;
    
    public BasicDAO()
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/library", "root", "1234");
        }
        catch (Exception e){
            throw new RuntimeException(e);
        }
    }
    public  abstract T select(Long id) throws  Exception;

    public abstract void insert(T t) throws Exception;

    public abstract void delete(Long id) ;

    public  abstract void update(T t);
}
