package main.java.controllers;

import main.java.beans.OrderDetails;
import main.java.beans.ShopDetails;
import main.java.dao.DataBaseQuery;
import main.java.wrapper.ShopListResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rahul on 8/17/2017.
 */
@Controller
public class LocalChaiStepsController {
    DataBaseQuery dbq=new DataBaseQuery();
    @RequestMapping(value = "/SubmitStep1.json", method = RequestMethod.POST,  headers = "Accept=application/json,application/xml")
    @ResponseBody
    public List<ShopDetails> showShopList(@RequestBody ShopDetails shopDetails)throws Exception{
        List<ShopDetails> shopDetailsList=new ArrayList<ShopDetails>();
        shopDetailsList=dbq.getShopDetails(shopDetails);
        return shopDetailsList;
       // return new ResponseEntity<>(new ShopListResponse(shopDetailsList, "Success or error message"), HttpStatus.OK);
    }

    @RequestMapping(value = "/SubmitStep2.json",method = RequestMethod.POST, headers = "Accept=application/json,application/xml")
    @ResponseBody
    public OrderDetails checkSelectedItem(@RequestBody ShopDetails shopDetails)throws Exception{
        OrderDetails orderDetails=new OrderDetails();
        return orderDetails;
    }
}
