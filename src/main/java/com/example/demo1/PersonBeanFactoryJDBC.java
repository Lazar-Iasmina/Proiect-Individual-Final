package com.example.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonBeanFactoryJDBC implements BeanFactoryJDBC {
    public Object createBean( ResultSet rs ) throws SQLException {
        return new Zbor1( rs.getInt("idZbor"),rs.getString("aeroportPlecare"),rs.getString("aeroportSosire"),rs.getString("dataPlecare"),rs.getString("dataSosire"),rs.getString("ora"),rs.getString("oraSosire"),rs.getInt("pret"),rs.getString("companie"));
    }
}