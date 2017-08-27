/**
 * Created by rahul on 3/11/2017.
 */

(function(){
    var app=angular.module('localChaiService',[]);
    app.factory('localChaiService',['$http','$q','$filter',function($http,$q,$filter){
        var model;
        var createModel=function(){
            model={
                shopLocality:"",
                itemDetailsList:[],
                selectedItemlist:[],
                quantity:0,
                totalAmount:0
            };
            return model;
        };
        var orderGrocery;
        //var setGroceryData=function(orderGrocery){
        //    orderGrocery=this.orderGrocery;
        //};
        var makeRequest=function(model,path){
            return $http({
                method :'POST',
                url: path,
                data:{
                    shopLocality:model.shopLocality,
                    itemDetailsList:model.itemDetailsList.split(","),
                    selectedItemlist:model.selectedItemlist,
                    totalAmount:model.totalAmount
                }
            }).then(function(response){
                if(typeof response == 'object'){
                    return response.data;
                }
            });
        };
        var getSelectedItem=function(orderGrocery){
            var temp=[];
            var selectedItems=[];
            angular.forEach(orderGrocery,function(shop,value) {
                angular.forEach(shop.itemDetailsList, function (item, value) {
                    temp.push(item.itemId);
                });
            });
            angular.forEach(model.selectedItemlist,function(checked,position){
                if(checked==true){
                    selectedItems.push(temp[position]);
                }
            });
            model.selectedItemlist=selectedItems;
        };
        return{
            getModel:function(){
                return (model || createModel());
            },
            validateApplicationStep1: function(){
                return makeRequest(model,'/SubmitStep1.json');
            },
            validateApplicationStep2: function(orderGrocery){
                getSelectedItem(orderGrocery);
                return makeRequest(model,'/SubmitStep2.json');
            }
        }
    }]);
})();