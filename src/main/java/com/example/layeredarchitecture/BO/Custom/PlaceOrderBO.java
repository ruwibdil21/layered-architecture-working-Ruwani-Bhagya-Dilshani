package com.example.layeredarchitecture.BO.Custom;

import com.example.layeredarchitecture.BO.SuperBO;
import com.example.layeredarchitecture.DTO.OrderDetailDTO;
import com.example.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface PlaceOrderBO extends SuperBO {
    boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException ;
    Item findItem(String code);
    ArrayList<Item> getAllItems()throws SQLException, ClassNotFoundException;
}
