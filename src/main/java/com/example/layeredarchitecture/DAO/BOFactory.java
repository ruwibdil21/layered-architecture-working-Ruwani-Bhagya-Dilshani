package com.example.layeredarchitecture.DAO;

import com.example.layeredarchitecture.BO.Custom.impl.CustomerBOImpl;
import com.example.layeredarchitecture.BO.Custom.impl.ItemBOImpl;
import com.example.layeredarchitecture.BO.Custom.impl.PlaceOrderBOImpl;
import com.example.layeredarchitecture.BO.SuperBO;

public class BOFactory {
    private static BOFactory boFactory;
    private BOFactory(){

    }
    public static BOFactory getBOFactory(){
        return (boFactory==null)?boFactory=new BOFactory():boFactory;
    }
    public enum BOTypes{
        CUSTOMER,ITEM,PLACE_ORDER
    }
    public SuperBO getBO(BOTypes boTypes){
        switch (boTypes){
            case CUSTOMER:
               return new CustomerBOImpl();
            case ITEM:
                return new ItemBOImpl();
            case PLACE_ORDER:
                return new PlaceOrderBOImpl();
        }
        return null;
    }
}
