/**
 * Created by rahul on 3/11/2017.
 */

(function(){
    var app=angular.module('localChaiDirective',[]);
    app.filter('searchBoxList1',function(){
        return function(arr,searchLocalityName){
            if(typeof searchLocalityName!="undefined"){
                if( searchLocalityName.length<3){
                    return ;
                }
                else if( !searchLocalityName) {
                    return arr;
                }
                var result=[];
                searchLocalityName=searchLocalityName.toLowerCase();
                angular.forEach(arr,function(orderGrocery){
                    if (orderGrocery.shopLocality.toLowerCase().indexOf(searchLocalityName)!==-1){
                        result.push(orderGrocery.shopLocality);
                    }
                });
                return result;
            }
        }
    });
    app.filter('searchBoxList2',function(){
        return function(arr,searchItemName){
            if(typeof searchItemName!= "undefined"){
                if(searchItemName.length<3){
                    return ;
                }
                else if(!searchItemName) {
                    return arr;
                }
                var result=[];
                searchItemName=searchItemName.toLowerCase();
                angular.forEach(arr,function(orderGrocery){
                    //if()
                    if (orderGrocery.itemDetailsList[0].itemId.toLowerCase().indexOf(searchItemName)!==-1){
                        result.push(orderGrocery.itemDetailsList[0].itemName);
                    }
                });
                return result;
            }
        }
    });

})();