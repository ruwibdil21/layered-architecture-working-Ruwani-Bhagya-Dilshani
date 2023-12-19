package com.example.layeredarchitecture.DAO.custom;

import com.example.layeredarchitecture.DAO.CrudDAO;
import com.example.layeredarchitecture.db.DBConnection;
import com.example.layeredarchitecture.model.CustomerDTO;
import com.example.layeredarchitecture.view.tdm.CustomerTM;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;

public interface CustomerDAO extends CrudDAO<CustomerDTO> {
//    ArrayList<CustomerDTO> getallCustomer() throws SQLException, ClassNotFoundException;
//
//
//    boolean saveCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
//
//
//     void updateCustomer(CustomerDTO dto) throws SQLException, ClassNotFoundException;
//
//     boolean existsCustomer(String id) throws SQLException, ClassNotFoundException;
//
//     void deleteCustomer(String id) throws SQLException, ClassNotFoundException;
//
//    String generateNewId() throws SQLException, ClassNotFoundException;
//
//    CustomerDTO searchCustomer(String s) throws SQLException, ClassNotFoundException;



}
