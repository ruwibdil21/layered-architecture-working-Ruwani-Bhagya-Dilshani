package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public interface ItemBO {
     ArrayList<ItemDTO> getall() throws SQLException, ClassNotFoundException;
     boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException;
     void delete(String code) throws SQLException, ClassNotFoundException;
     boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException;

     boolean existItem(String code) throws SQLException, ClassNotFoundException;
     String generateNewId() throws SQLException, ClassNotFoundException;
     ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException ;
     boolean updateItemPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException;

}
