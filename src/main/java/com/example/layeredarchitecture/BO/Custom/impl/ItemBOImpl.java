package com.example.layeredarchitecture.BO.Custom.impl;

import com.example.layeredarchitecture.BO.Custom.ItemBO;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.DTO.ItemDTO;
import com.example.layeredarchitecture.entity.Item;

import java.sql.SQLException;
import java.util.ArrayList;

public class ItemBOImpl implements ItemBO {

    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    @Override
    public ArrayList<ItemDTO> getall() throws SQLException, ClassNotFoundException{
        ArrayList<Item> items=itemDAO.getall();
        ArrayList<ItemDTO> itemDTOS=new ArrayList<>();
        for (Item item:items) {
            itemDTOS.add(new ItemDTO(item.getCode(),item.getDescription(), item.getUnitPrice(), item.getQtyOnHand()));
        }
        return itemDTOS;
    }
    @Override
    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.save(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));
    }


    @Override
    public  void delete(String code) throws SQLException, ClassNotFoundException{
        itemDAO.delete(code);
    }
    @Override
    public boolean update(ItemDTO dto) throws SQLException, ClassNotFoundException{
        return itemDAO.update(new Item(dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand()));

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
    public ItemDTO searchItem(String id) throws SQLException, ClassNotFoundException {
        Item item = itemDAO.search(id);
        return new ItemDTO(item.getCode(),item.getDescription(), item.getUnitPrice(), item.getQtyOnHand());
    }


    @Override
    public boolean updateItemPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException {
        return false;
    }

}
