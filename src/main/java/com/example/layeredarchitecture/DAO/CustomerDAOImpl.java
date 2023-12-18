package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {
   /* @Override
    public ArrayList<CustomerDTO> getall() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void update(CustomerDTO dto) throws SQLException, ClassNotFoundException {

    }

    @Override
    public boolean exists(String id) throws SQLException, ClassNotFoundException {
        return false;
    }

    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {

    }

    @Override
    public String generateNewId() throws SQLException, ClassNotFoundException {
        return null;
    }

    @Override
    public CustomerDTO search(String s) throws SQLException, ClassNotFoundException {
        return null;
    }*/
   @Override
    public  ArrayList<CustomerDTO> getall() throws SQLException, ClassNotFoundException {

 Connection connection = DBConnection.getDbConnection().getConnection();
        Statement stm = connection.createStatement();
        ResultSet rst =SQLUtil.execute("SELECT * FROM Customer");
        ArrayList<CustomerDTO> allCustomer = new ArrayList<>();

        while (rst.next()){
            CustomerDTO customerDTO= new CustomerDTO(
                    rst.getString("id"),
                    rst.getString("name"),
                    rst.getString("address"));
            allCustomer.add(customerDTO);
        }
        return allCustomer;
      // return SQLUtil.execute("SELECT * FROM Customer");

        }
    @Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
       // PreparedStatement pstm = connection.prepareStatement("INSERT INTO Customer (id,name, address) VALUES (?,?,?)");
       // pstm.setString(1, dto.getId());
       // pstm.setString(2, dto.getName());
       // pstm.setString(3, dto.getAddress());
       // return pstm.executeUpdate() > 0;

      return   SQLUtil.execute("INSERT INTO Customer (id,name, address) VALUES (?,?,?)",dto.getId(),dto.getName(),dto.getAddress());

    }
    @Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException {
       // Connection connection = DBConnection.getDbConnection().getConnection();
       // PreparedStatement pstm = connection.prepareStatement("UPDATE Customer SET name=?, address=? WHERE id=?");
        //pstm.setString(1, dto.getName());
       // pstm.setString(2, dto.getAddress());
       // pstm.setString(3, dto.getId());
        //pstm.executeUpdate();

        SQLUtil.execute("UPDATE Customer SET name=?, address=? WHERE id=?",dto.getName(),dto.getAddress(),dto.getId());
        return false;
    }
   @Override
    public boolean exists(String id) throws SQLException, ClassNotFoundException {
//        Connection connection = DBConnection.getDbConnection().getConnection();
//        PreparedStatement pstm = connection.prepareStatement("SELECT id FROM Customer WHERE id=?");
//        pstm.setString(1, id);
//        return pstm.executeQuery().next();

      ResultSet rst=  SQLUtil.execute("SELECT id FROM Customer WHERE id=?",id);
       return rst.next();

    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("DELETE FROM Customer WHERE id=?");
        pstm.setString(1, id);
        pstm.executeUpdate();

        SQLUtil.execute("DELETE FROM Customer WHERE id=?",id);

    }


   @Override

    public  String generateNewId() throws SQLException, ClassNotFoundException {
        Connection connection = DBConnection.getDbConnection().getConnection();
        ResultSet rst = SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");
        if (rst.next()) {
            String id = rst.getString("id");
            int newCustomerId = Integer.parseInt(id.replace("C00-", "")) + 1;
            return String.format("C00-%03d", newCustomerId);
        } else {
            return "C00-001";
        }

       //return SQLUtil.execute("SELECT id FROM Customer ORDER BY id DESC LIMIT 1;");

    }

    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException {
       Connection connection = DBConnection.getDbConnection().getConnection();
        PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Customer WHERE id=?");
        pstm.setString(1, newValue + "");
        ResultSet rst = pstm.executeQuery();
        rst.next();
        CustomerDTO customerDTO = new CustomerDTO(newValue +"", rst.getString("name"), rst.getString("address"));
        return customerDTO;

      // return SQLUtil.execute("SELECT * FROM Customer WHERE id=?",newValue);
   }



}



