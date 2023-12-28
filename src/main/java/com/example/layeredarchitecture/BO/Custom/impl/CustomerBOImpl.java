package com.example.layeredarchitecture.BO.Custom.impl;

import com.example.layeredarchitecture.BO.Custom.CustomerBO;
import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.DTO.CustomerDTO;
import com.example.layeredarchitecture.entity.Customer;

import java.sql.SQLException;
import java.util.ArrayList;

public  class CustomerBOImpl implements CustomerBO{
   CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
@Override
    public  ArrayList<CustomerDTO> getallCustomer() throws SQLException, ClassNotFoundException{
      // return customerDAO.getall();
    ArrayList<Customer> customers=customerDAO.getall();
    ArrayList<CustomerDTO> customerDTOS=new ArrayList<>();
    for (Customer customer:customers) {
        customerDTOS.add(new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress()));
    }
    return customerDTOS;
}

@Override
    public boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{

       // return customerDAO.save(dto);
    return customerDAO.save(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
}


@Override
    public boolean updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException{
     // return   customerDAO.update(dto);
    return customerDAO.update(new Customer(dto.getId(),dto.getName(),dto.getAddress()));
    }


    @Override
    public boolean existsCustomer(String id) throws SQLException, ClassNotFoundException{
       return customerDAO.exists(id);
    }


    @Override
    public void deleteCustomer(String id) throws SQLException, ClassNotFoundException{
        customerDAO.delete(id);
    }


    @Override
    public  String generateNewId() throws SQLException, ClassNotFoundException{
       return customerDAO.generateNewId();
    }


    @Override
    public CustomerDTO searchCustomer(String newValue) throws SQLException, ClassNotFoundException{
       // return customerDAO.search(newValue);
        Customer customer=customerDAO.search(newValue);
        CustomerDTO customerDTO=new CustomerDTO(customer.getId(),customer.getName(),customer.getAddress());
        return customerDTO;
    }


}
