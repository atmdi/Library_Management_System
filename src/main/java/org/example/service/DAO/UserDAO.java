package org.example.service.DAO;

import org.example.model.User;
import org.example.service.DAO.BasicDAO;
import org.example.model.Book;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserDAO extends BasicDAO<User> {

    UserInfoDAO userInfoDAO=new UserInfoDAO();
    @Override
    public User select(Long id) throws Exception {
        return null;
    }

    @Override
    public void insert(User user) throws SQLException {

        PreparedStatement preparedStatement = connection.prepareStatement("insert into user (id,name,lastname,age)values (?,?,?,?)");

        preparedStatement.setLong(1, user.getId());
        preparedStatement.setString(2, user.getName());
        preparedStatement.setString(3, user.getLastname());
        preparedStatement.setString(4, user.getAge());

        preparedStatement.executeUpdate();
        userInfoDAO.insert(user.getUserInfo());
        System.out.println("addMember success");

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void update(User user) {

    }


}