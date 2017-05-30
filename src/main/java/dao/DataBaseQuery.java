package main.java.dao;

import main.java.beans.AvailableShops;
import main.java.beans.ItemDetails;
import main.java.beans.ShopDetails;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 4/5/2017.
 */
public class DataBaseQuery {

    //------------------------------------------------------------------------------------------------------------------

    public List<ShopDetails> getAvailableShops()throws SQLException {
        List<ShopDetails> shopList=new ArrayList<ShopDetails>();
        List<ItemDetails> itemList=new ArrayList<ItemDetails>();
        Connection connection = DataBaseConnect.openConnection();
        try {
            ResultSet rs1 = DataBaseConnect.getStatement(connection).executeQuery("SELECT * from SHOP_DETAILS");
            ResultSet rs2 = DataBaseConnect.getStatement(connection).executeQuery("SELECT * from ITEM_DETAILS");

            while (rs1.next()) {
                ShopDetails shopDetails = new ShopDetails();
                shopDetails.setShopId(rs1.getString(1));
                shopDetails.setShopName(rs1.getString(2));
                shopDetails.setShopAddress(rs1.getString(3));
                shopList.add(shopDetails);
            }
            while (rs2.next()) {
                ItemDetails itemDetails = new ItemDetails();
                itemDetails.setItemId(rs2.getString(1));
                itemDetails.setItemName(rs2.getString(2));
                itemDetails.setItemPrice(rs2.getString(3));
                itemDetails.setItemQuantity(rs2.getString(4));
                itemDetails.setItemShopId(rs2.getString(5));
                itemList.add(itemDetails);
            }
        }
        catch (Exception e){
            e.printStackTrace();
            System.out.println("do handle the exceptions");
        }
        finally
        {
            DataBaseConnect.closeConnection(connection);
        }
        for(int i=0;i<shopList.size();i++){
            for(int j=0;j<itemList.size();j++){
                if(shopList.get(i).getShopId().equals(itemList.get(j).getItemShopId())){
                    shopList.get(i).getItemDetailsList().add(itemList.get(j));
                }
            }
        }
        return shopList;
    }
    public List<ShopDetails> getShopDetails(AvailableShops availableShops)throws Exception,NullPointerException{
        List<ShopDetails> shopDetailsList=new ArrayList<ShopDetails>();
        ArrayList shopIdList=new ArrayList();
        ArrayList itemList=new ArrayList();
        String locality=availableShops.getLocality();
        itemList=availableShops.getItemDetailsList();
        Connection connection=DataBaseConnect.openConnection();
        try {
            ResultSet resultSet = DataBaseConnect.getStatement(connection).executeQuery("SELECT * FROM SHOP_DETAILS WHERE SHOP_LOCALITY='" + locality + "'");
            ShopDetails shopDetails = new ShopDetails();
            while (resultSet.next()) {
                shopIdList.add(resultSet.getString(1));
                shopDetails.setShopName(resultSet.getString(2));
            }
            ResultSet resultSet1 = null;
            for (int i = 0; i < shopIdList.size(); i++) {
                for (int j = i; j < itemList.size(); j++) {
                    resultSet1 = DataBaseConnect.getStatement(connection).executeQuery("SELECT * FROM ITEM_DETAILS WHERE ITEM_SHOP_ID='" + shopIdList.get(i) + "' AND ITEM_NAME='" + itemList.get(i) + "'");
                }
            }
            ArrayList itemDetails1 = new ArrayList();
            while (resultSet1.next()) {
                shopDetails.setShopId(resultSet1.getString(5));
                //            shopDetails;
                itemDetails1.add(resultSet1.getString(1));
                itemDetails1.add(resultSet1.getString(2));
                itemDetails1.add(resultSet1.getString(3));
                itemDetails1.add(resultSet1.getString(4));
                shopDetails.setItemDetailsList(itemDetails1);

                shopDetailsList.add(shopDetails);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DataBaseConnect.closeConnection(connection);
        }
        return shopDetailsList;
    }
}
