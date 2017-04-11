package main.java.dao;

import main.java.beans.ItemDetails;
import main.java.beans.ShopDetails;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 4/5/2017.
 */
public class DataBaseQuery {

    //------------------------------------------------------------------------------------------------------------------

    public List<ShopDetails> getAvailableShops()throws Exception{
        List<ShopDetails> shopList=new ArrayList<ShopDetails>();
        List<ItemDetails> itemList=new ArrayList<ItemDetails>();

        ResultSet rs1=DataBaseConnect.getStatement().executeQuery("SELECT * from SHOPDETAILS");
        ResultSet rs2=DataBaseConnect.getStatement().executeQuery("SELECT * from ITEMDETAILS");

        while (rs1.next()){
            ShopDetails shopDetails=new ShopDetails();
            shopDetails.setShopId(rs1.getString(1));
            shopDetails.setShopName(rs1.getString(2));
            shopDetails.setShopAddress(rs1.getString(3));

            shopList.add(shopDetails);
        }
        while (rs2.next()){
            ItemDetails itemDetails=new ItemDetails();
            itemDetails.setItemId(rs2.getString(1));
            itemDetails.setItemName(rs2.getString(2));
            itemDetails.setItemPrice(rs2.getString(3));
            itemDetails.setItemQuantity(rs2.getString(4));
            itemDetails.setItemShopId(rs2.getString(5));
            itemList.add(itemDetails);
        }

        for(int i=0;i<shopList.size();i++){
            for(int j=0;j<itemList.size();j++){
                if(shopList.get(i).getShopId()==itemList.get(j).getItemShopId()){
                    shopList.get(i).getItemDetailsList().add(itemList.get(j));
                }
            }
        }
        return shopList;
    }
}
