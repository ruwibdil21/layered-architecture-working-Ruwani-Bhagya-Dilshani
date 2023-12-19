package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDTO;

import java.sql.*;
import java.time.LocalDate;

public interface OrderDAO {
     String generateNewOrderId() throws SQLException, ClassNotFoundException ;
     boolean checkOrderId(String orderId) throws SQLException, ClassNotFoundException ;
     boolean saveOrder(String orderId, LocalDate orderDate, String customerId) throws SQLException, ClassNotFoundException ;


}
