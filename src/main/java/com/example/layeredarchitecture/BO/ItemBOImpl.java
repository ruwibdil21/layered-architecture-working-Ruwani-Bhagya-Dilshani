package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.DAO.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO{

    ItemDAO itemDAO = new ItemDAOImpl();
    @Override
    public ArrayList<ItemDTO> getall() throws SQLException, ClassNotFoundException{
      return   itemDAO.getall();
    }
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException{
       return itemDAO.save(dto);
    }
    @Override
    public  void delete(String code) throws SQLException, ClassNotFoundException{
        itemDAO.delete(code);
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException{
       return itemDAO.update(dto);
    }
    @Override
    public boolean existItem(String code) throws SQLException, ClassNotFoundException{
       return itemDAO.exists(code);
    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
       return itemDAO.generateNewId();
    }
    @Override
    public ItemDTO searchItem(String s) throws SQLException, ClassNotFoundException {
        return itemDAO.search(s);
    }

    @Override
    public boolean updateItemPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException {
        return false;
    }

}
