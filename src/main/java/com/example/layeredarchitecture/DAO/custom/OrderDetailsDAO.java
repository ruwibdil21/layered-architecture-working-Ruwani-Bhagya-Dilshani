package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.SuperDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO extends SuperDAO {
     boolean saveOrderDetail(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException ;
    }