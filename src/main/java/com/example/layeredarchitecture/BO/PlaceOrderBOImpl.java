package com.example.layeredarchitecture.BO;

import com.example.layeredarchitecture.DAO.DAOFactory;
import com.example.layeredarchitecture.DAO.custom.CustomerDAO;
import com.example.layeredarchitecture.DAO.custom.ItemDAO;
import com.example.layeredarchitecture.DAO.custom.OrderDAO;
import com.example.layeredarchitecture.DAO.custom.OrderDetailsDAO;
import com.example.layeredarchitecture.DAO.custom.impl.CustomerDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.ItemDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.OrderDAOImpl;
import com.example.layeredarchitecture.DAO.custom.impl.OrderDetailsDAOImpl;
import com.example.layeredarchitecture.model.ItemDTO;
import com.example.layeredarchitecture.model.OrderDetailDTO;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class PlaceOrderBOImpl implements PlaceOrderBO {
    OrderDAO orderDAO= (OrderDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDER);
    CustomerDAO customerDAO = (CustomerDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.CUSTOMER);
    ItemDAO itemDAO = (ItemDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ITEM);
    OrderDetailsDAO orderDetailDAO = (OrderDetailsDAO) DAOFactory.getDaoFactory().getDAO(DAOFactory.DAOTypes.ORDR_DETAILS);

    @Override
    public boolean placeOrder(String orderId, LocalDate orderDate, String customerId, List<OrderDetailDTO> orderDetails) throws SQLException, ClassNotFoundException {

            OrderDAO orderDAO = new OrderDAOImpl();
            boolean isExits = orderDAO.checkOrderId(orderId);
            /*connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement stm = connection.prepareStatement("SELECT oid FROM `Orders` WHERE oid=?");
            stm.setString(1, orderId);*/
            /*if order id already exist*/
            /*if (stm.executeQuery().next()) {

            }*/

            if (!isExits){
                boolean isSavedOrder = orderDAO.saveOrder(orderId,orderDate,customerId);
                if (isSavedOrder){
                    OrderDetailsDAO orderDetailsDAO = new OrderDetailsDAOImpl();
                    boolean isSavedOrderDetail = orderDetailsDAO.saveOrderDetail(orderDetails,orderId);
                    if (isSavedOrderDetail){
                        for (OrderDetailDTO detail : orderDetails) {
                            ItemDTO item = findItem(detail.getItemCode());
                            item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());
                            ItemDAO itemDAO = new ItemDAOImpl();
                            boolean b= itemDAO.update(item);

                            System.out.print(isSavedOrderDetail);
                            System.out.println(isSavedOrder);
                            System.out.println(b);

                            return b;

                        }
                    }
                }
            }
            /*connection.setAutoCommit(false);
            stm = connection.prepareStatement("INSERT INTO `Orders` (oid, date, customerID) VALUES (?,?,?)");
            stm.setString(1, orderId);
            stm.setDate(2, Date.valueOf(orderDate));
            stm.setString(3, customerId);

            if (stm.executeUpdate() != 1) {
                connection.rollback();
                connection.setAutoCommit(true);
                return false;
            }*/

            /*stm = connection.prepareStatement("INSERT INTO OrderDetails (oid, itemCode, unitPrice, qty) VALUES (?,?,?,?)");

            for (OrderDetailDTO detail : orderDetails) {
                stm.setString(1, orderId);
                stm.setString(2, detail.getItemCode());
                stm.setBigDecimal(3, detail.getUnitPrice());
                stm.setInt(4, detail.getQty());

                if (stm.executeUpdate() != 1) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }*/

//                //Search & Update Item
            //ItemDTO item = findItem(detail.getItemCode());
            //item.setQtyOnHand(item.getQtyOnHand() - detail.getQty());

                /*PreparedStatement pstm = connection.prepareStatement("UPDATE Item SET description=?, unitPrice=?, qtyOnHand=? WHERE code=?");
                pstm.setString(1, item.getDescription());
                pstm.setBigDecimal(2, item.getUnitPrice());
                pstm.setInt(3, item.getQtyOnHand());
                pstm.setString(4, item.getCode());

                if (!(pstm.executeUpdate() > 0)) {
                    connection.rollback();
                    connection.setAutoCommit(true);
                    return false;
                }
            }*/

            /*connection.commit();
            connection.setAutoCommit(true);
            return true;*/
        return false;
    }
    public ItemDTO findItem(String code) {
        try {
            ItemDAO itemDAO = new ItemDAOImpl();
            return itemDAO.search(code);

            /*Connection connection = DBConnection.getDbConnection().getConnection();
            PreparedStatement pstm = connection.prepareStatement("SELECT * FROM Item WHERE code=?");
            pstm.setString(1, code);
            ResultSet rst = pstm.executeQuery();
            rst.next();
            return new ItemDTO(code, rst.getString("description"), rst.getBigDecimal("unitPrice"), rst.getInt("qtyOnHand"));*/
        } catch (SQLException e) {
            throw new RuntimeException("Failed to find the Item " + code, e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}