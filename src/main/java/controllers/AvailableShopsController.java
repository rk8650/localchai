package main.java.controllers;
import main.java.beans.ItemDetails;
import main.java.beans.ShopDetails;
import main.java.dao.DataBaseQuery;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 4/2/2017.
 */
@Controller
public class AvailableShopsController {
    DataBaseQuery dbq;
    @RequestMapping(value = "/groceryhome.json", method = RequestMethod.POST)
    public ShopDetails getAvailableShops(ShopDetails shopDetails, ItemDetails itemDetails)throws Exception{
        List<Object> list=new ArrayList<Object>();
        //list=dbq.getAvailableShops();
        //System.out.printl n(list);
        return shopDetails;
    }
}
