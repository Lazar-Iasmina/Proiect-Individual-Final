package com.example.demo1;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface BeanFactoryJDBC {
    public Object createBean( ResultSet rs ) throws SQLException;
}
