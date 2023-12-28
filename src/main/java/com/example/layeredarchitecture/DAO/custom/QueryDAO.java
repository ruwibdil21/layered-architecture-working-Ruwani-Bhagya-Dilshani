package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.SuperDAO;
import com.example.layeredarchitecture.DTO.CustomerDTO;

public interface QueryDAO extends SuperDAO {

    void customerOrderDetails(CustomerDTO customerDTO);
}