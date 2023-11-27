package org.example.service.DAO;

import org.example.model.UserInfo;

import java.sql.PreparedStatement;
import java.sql.SQLException;




    public class UserInfoDAO extends BasicDAO<UserInfo>{
        @Override
        public UserInfo select(Long id) throws Exception {
            return null;
        }



        @Override
        public void insert(UserInfo userInfo) throws SQLException {

            PreparedStatement preparedStatement = connection.prepareStatement("insert into userinfo (id , memberId ,mobile , address,city) values (?,?,?,?,?)");
            preparedStatement.setLong(1,userInfo.getId());
            preparedStatement.setLong(2,userInfo.getUserId());
            preparedStatement.setString(4,userInfo.getMobile());
            preparedStatement.setString(3,userInfo.getAddress());
            preparedStatement.setString(5,userInfo.getCity());

            preparedStatement.executeUpdate();
            System.out.println("userinfo add ...");

        }

        @Override
        public void delete(Long id) {

        }

        @Override
        public void update(UserInfo userInfo) {

        }

    }


