package com.company;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Main {

    public static void main(String[] args) throws SQLException {
        Connection con = DBUtil.getConnection();
        if (con != null) {
            Statement statement = con.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM person");
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                Date birthday = resultSet.getDate("birthday");
                System.out.println("[ " + name + " - " + age + " - " + birthday + " ]");
            }
        }

        DBUtil.closeConnection(con);
    }
}
