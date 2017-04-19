package main.java.controllers;
import main.java.beans.ItemDetails;
import main.java.beans.ShopDetails;
import main.java.dao.DataBaseQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 4/2/2017.
 */
@Controller
public class AvailableShopsController {
    DataBaseQuery dbq=new DataBaseQuery();
    @RequestMapping(value = "/groceryhome.json", method = RequestMethod.POST)
    @ResponseBody
    public List<ShopDetails> getAvailableShops()throws Exception{
        List<ShopDetails> shopList=new ArrayList<ShopDetails>();
        shopList=dbq.getAvailableShops();
        return shopList;
    }
}