package com.example.layeredarchitecture.BO.Custom;

import com.example.layeredarchitecture.BO.SuperBO;
import com.example.layeredarchitecture.DTO.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO extends SuperBO {
     ArrayList<ItemDTO> getall() throws SQLException, ClassNotFoundException;
     boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException;
     void delete(String code) throws SQLException, ClassNotFoundException;
     boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean existItem(String code) throws SQLException, ClassNotFoundException;
     String generateNewId() throws SQLException, ClassNotFoundException;
     ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException ;
     boolean updateItemPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException;

}
