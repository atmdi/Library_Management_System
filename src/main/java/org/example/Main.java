package org.example;

import org.example.model.*;
import org.example.model.enums.BookType;
import org.example.service.Libraryautomation;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
       Book java1=new Book(1L,"JavaInAction", BookType.JAVA,"john",null);
        Libraryautomation libraryautomation=Libraryautomation.getInstance();
//        libraryautomation.addBook(java1);

        UserInfo userInfo1=
                new UserInfo(7L,102L,"DFDF","DFFDF","DFF");
      //  libraryautomation.addUserInfo(userInfo1);



        User user1=new User(189L,"atiiii","madahi","30",userInfo1, Arrays.asList(java1));
       libraryautomation.addUser(user1);



    }
}