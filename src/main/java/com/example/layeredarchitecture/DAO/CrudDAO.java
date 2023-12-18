package com.example.layeredarchitecture.DAO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface CrudDAO <T> {
   ArrayList<T> getall() throws SQLException, ClassNotFoundException;

    boolean save(T dto) throws SQLException, ClassNotFoundException;

    boolean update(T dto) throws SQLException, ClassNotFoundException;

   boolean exists(String id) throws SQLException, ClassNotFoundException;

    void delete(String id) throws SQLException, ClassNotFoundException;

    String generateNewId() throws SQLException, ClassNotFoundException;

    T search(String s) throws SQLException, ClassNotFoundException;

}
