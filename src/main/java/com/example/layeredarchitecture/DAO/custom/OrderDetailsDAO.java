package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.SuperDAO;
import com.example.layeredarchitecture.DTO.OrderDetailDTO;

import java.sql.SQLException;
import java.util.List;

public interface OrderDetailsDAO extends SuperDAO {
     boolean saveOrderDetail(List<OrderDetailDTO> orderDetails, String orderId) throws SQLException, ClassNotFoundException ;
    }