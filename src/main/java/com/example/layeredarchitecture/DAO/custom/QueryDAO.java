package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.model.CustomerDTO;

public interface QueryDAO {

    void customerOrderDetails(CustomerDTO customerDTO);
}