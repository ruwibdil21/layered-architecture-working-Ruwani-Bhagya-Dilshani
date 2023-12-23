package com.example.layeredarchitecture.BO.Custom.impl;

import com.example.layeredarchitecture.BO.Custom.CustomerBO;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.model.CustomerDTO;

import java.sql.SQLException;
import java.util.ArrayList;

public class CustomerBOImpl implements CustomerBO {
   CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
@Override
    public  ArrayList<CustomerDTO> getall() throws SQLException, ClassNotFoundException{
       return customerDAO.getall();
    }
@Override
    public boolean save(CustomerDTO dto) throws SQLException, ClassNotFoundException{

        return customerDAO.save(dto);
    }
@Override
    public boolean update(CustomerDTO dto) throws SQLException, ClassNotFoundException{
      return   customerDAO.update(dto);
    }
    @Override
    public boolean exists(String id) throws SQLException, ClassNotFoundException{
       return customerDAO.exists(id);
    }
    @Override
    public void delete(String id) throws SQLException, ClassNotFoundException{
        customerDAO.delete(id);
    }
    @Override
    public  String generateNewId() throws SQLException, ClassNotFoundException{
       return customerDAO.generateNewId();
    }
    @Override
    public CustomerDTO search(String newValue) throws SQLException, ClassNotFoundException{
        return customerDAO.search(newValue);
    }

}