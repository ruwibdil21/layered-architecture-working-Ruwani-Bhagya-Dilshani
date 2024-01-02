package com.example.layeredarchitecture.DAO.custom.impl;

import com.example.layeredarchitecture.DAO.SQLUtil;
import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.DTO.ItemDTO;
import com.example.layeredarchitecture.entity.Item;

import java.sql.*;
import java.util.ArrayList;

public class ItemDAOImpl implements ItemDAO {
//    @Override
//    public ArrayList<ItemDTO> getall() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public boolean save(ItemDTO dto) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public void update(ItemDTO dto) throws SQLException, ClassNotFoundException {
//
//    }
//
//    @Override
//    public boolean exists(String id) throws SQLException, ClassNotFoundException {
//        return false;
//    }
//
//    @Override
//    public void delete(String id) throws SQLException, ClassNotFoundException {
//
//    }
//
//    @Override
//    public String generateNewId() throws SQLException, ClassNotFoundException {
//        return null;
//    }
//
//    @Override
//    public ItemDTO search(String s) throws SQLException, ClassNotFoundException {
//        return null;
//    }


   @Override
    public ArrayList<Item> getall() throws SQLException, ClassNotFoundException {
      // Connection connection = DBConnection.getDbConnection().getConnection();
      //  Statement stm = connection.createStatement();
        ResultSet rst = SQLUtil.execute("SELECT * FROM Item");
        ArrayList<Item> allItems = new ArrayList<>();

       while (rst.next()) {
            Item itemDTO = new Item(
                    rst.getString("code"),
                    rst.getString("description"),
                    rst.getBigDecimal("unitPrice"),
                    rst.getInt("qtyOnHand"));
            allItems.add(itemDTO);
        }
        return allItems;

     // return   SQLUtil.execute("SELECT * FROM Item");

    }

//    @Override
//    public ArrayList<ItemDTO> getall() throws SQLException, ClassNotFoundException {
//        return null;
//    }

    @Override
    public boolean save(Item dto) throws SQLException, ClassNotFoundException {

//  Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)");
//        pstm.setString(1, dto.getCode());
//        pstm.setString(2, dto.getDescription());
//        pstm.setBigDecimal(3, dto.getUnitPrice());
//        pstm.setInt(4, dto.getQtyOnHand());
//        return pstm.executeUpdate()> 0;


       return SQLUtil.execute("INSERT INTO Item (code, description, unitPrice, qtyOnHand) VALUES (?,?,?,?)",dto.getCode(),dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand());

    }
    @Override
    public boolean update(Item dto) throws SQLException, ClassNotFoundException {

 Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
        pstm.setString(1, dto.getDescription());
        pstm.setBigDecimal(2, dto.getUnitPrice());
        pstm.setInt(3, dto.getQtyOnHand());
        pstm.setString(4, dto.getCode());
        pstm.executeUpdate();


     return    SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",dto.getDescription(),dto.getUnitPrice(),dto.getQtyOnHand(),dto.getCode());

    }
    @Override
    public boolean exists(String code) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT code FROM Item WHERE code=?");
//        pstm.setString(1, code);
//        return pstm.executeQuery().next();

     ResultSet rst= SQLUtil.execute("SELECT code FROM Item WHERE code=?",code);
     return rst.next();

    }
    @Override
    public  void delete(String code) throws SQLException, ClassNotFoundException {

        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Item WHERE code=?");
        pstm.setString(1, code);
        pstm.executeUpdate();


        SQLUtil.execute("DELETE FROM Item WHERE code=?",code);

    }
    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst =SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("code");
            int newItemId = Integer.parseInt(id.replace("I00-", "")) + 1;
            return String.format("I00-%03d", newItemId);
        } else {
            return "I00-001";
        }

       //return SQLUtil.execute("SELECT code FROM Item ORDER BY code DESC LIMIT 1;");
    }

    @Override
        public Item search(String code) throws SQLException, ClassNotFoundException {
            ResultSet rst = SQLUtil.execute("SELECT * FROM Item WHERE code=?",code);
            rst.next();
        return new Item(code + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
    }
 //Connection connection = DBConnection.getDbConnection().getConnection();
        //PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
       // pstm.setString(1, newValue + "");
       // ResultSet rst = pstm.executeQuery();
       // rst.next();
       // ItemDTO item = new ItemDTO(newValue + "", rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));
       // return item;


     //  return SQLUtil.execute("SELECT * FROM Item WHERE code=?",newValue);
    }
//@Override
//    public boolean updateItemPlaceOrder(ItemDTO item) throws SQLException, ClassNotFoundException {
//       Connection connection = null;
//        connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
//        pstm.setString(1, item.getDescription());
//        pstm.setBigDecimal(2, item.getUnitPrice());
//        pstm.setInt(3, item.getQtyOnHand());
//        pstm.setString(4, item.getCode());
//
//        if (!(pstm.executeUpdate() > 0)) {
//            connection.rollback();
//            connection.setAutoCommit(true);
//            return false;
//        }
//        connection.commit();
//        connection.setAutoCommit(true);
//        return true;
//    }

  // return SQLUtil.execute("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?",item);




