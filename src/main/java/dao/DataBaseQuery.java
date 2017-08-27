package main.java.dao;

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
                shopDetails.setShopLocality(rs1.getString(4));
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
    public List<ShopDetails> getShopDetails(ShopDetails shopDetails)throws Exception,NullPointerException{
        List<ShopDetails> shopDetailsList=new ArrayList<ShopDetails>();
        List<ShopDetails> shopDetailsList1=new ArrayList<ShopDetails>();
        List<ItemDetails> itemList=new ArrayList<ItemDetails>();
        String locality=shopDetails.getShopLocality();
        itemList=shopDetails.getItemDetailsList();
        Connection connection=DataBaseConnect.openConnection();
        try {
            ResultSet resultSet = DataBaseConnect.getStatement(connection).executeQuery("SELECT * FROM SHOP_DETAILS WHERE SHOP_LOCALITY='" + locality + "'");
            while (resultSet.next()) {
                ShopDetails shopDetails1 = new ShopDetails();
                shopDetails1.setShopId(resultSet.getString(1));
                shopDetails1.setShopName(resultSet.getString(2));
                shopDetails1.setShopAddress(resultSet.getString(3));
                shopDetails1.setShopLocality(resultSet.getString(4));
                shopDetailsList.add(shopDetails1);
            }
            ResultSet resultSet1 = null;
            for (int i = 0; i < shopDetailsList.size(); i++) {//shop list of particular locality
                ShopDetails shopDetails2=new ShopDetails();
                for (int j = i; j < itemList.size(); j++) {// item list
                    ItemDetails itemDetails=new ItemDetails();
                    resultSet1 = DataBaseConnect.getStatement(connection).executeQuery("SELECT * FROM ITEM_DETAILS WHERE ITEM_SHOP_ID='" + shopDetailsList.get(i).getShopId() + "' AND ITEM_NAME='" + itemList.get(j) + "'");
                    while (resultSet1.next()) {
                        itemDetails.setItemId(resultSet1.getString(1));
                        itemDetails.setItemName(resultSet1.getString(2));
                        itemDetails.setItemPrice(resultSet1.getString(3));
                        itemDetails.setItemQuantity(resultSet1.getString(4));
                        itemDetails.setItemShopId(resultSet1.getString(5));

                        if(resultSet1.getString(5).equals(shopDetailsList.get(i).getShopId())){
                            shopDetails2.setShopId(shopDetailsList.get(i).getShopId());
                            shopDetails2.setShopName(shopDetailsList.get(i).getShopName());
                            shopDetails2.setShopAddress(shopDetailsList.get(i).getShopAddress());
                            shopDetails2.setShopLocality(shopDetailsList.get(i).getShopLocality());
                            shopDetails2.getItemDetailsList().add(itemDetails);
                        }
                        shopDetailsList1.add(shopDetails2);
                    }

                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        finally {
            DataBaseConnect.closeConnection(connection);
        }
        return shopDetailsList1;
    }
}
