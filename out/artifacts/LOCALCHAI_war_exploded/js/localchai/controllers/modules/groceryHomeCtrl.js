/**
 * Created by rahul on 4/9/2017.
 */
(function(){
    var app=angular.module('groceryHomeCtrl',[]);
    app.controller('groceryHomeCtrl',['$scope','$rootScope','$http','$location','orderGrocery','localChaiService',function($scope,$rootScope,$http,$location,orderGrocery,localChaiService){
        $scope.changeView=function(view){
            $location.path(view);
        };
        //var groceryData={};
        //$scope.submitData=function(grocery){
        //    grocery.itemDetailsList=grocery.itemDetailsList.split(",");
        //    groceryData=angular.copy(grocery);
        //};
        //window.nextStep=function(groceryHome){
        //    if(groceryHome!=null && typeof groceryHome != "undefined" && typeof $scope.groceryHome.itemName.$modelValue != "undefined"){
        //        $scope.postDetails(groceryData);
        //    }
        //};
        //$scope.postDetails=function(grocery){
        //    return  $http({
        //        url:   '/localGrocery.json',
        //        method: 'POST',
        //        headers:{
        //            'Content-Type':'application/json'
        //        },
        //        data:groceryData
        //    }).success(function(data,status){
        //        $rootScope.shopDetails=data;
        //        $scope.changeView('/localGrocery');
        //    });
        //};
        $scope.orderGrocery=orderGrocery.data;
        $scope.setLocalityName=function(localityName){
            var locality=document.getElementById("locality").value;
            document.getElementById("locality").value=locality+localityName;
        };
        $scope.setItemName=function(itemName){
            document.getElementById("item").value=itemName;
        };

        $scope.model=localChaiService.getModel();
        $scope.model.selectedItemlist=[];
        $scope.home=function(){
            $rootScope.orderGrocery=undefined;
            $scope.changeView('/');
        };
        $scope.submit=function(){
            $scope.submitted=true;
            //if($scope.form.$invalid){
            //    return false;
            //}
            localChaiService.validateApplicationStep1().then(function(data){
                //if(data.error || data.errorCode){
                //
                //}
                //else if(data.success==true){
                    $rootScope.orderGrocery=data;
                    $scope.changeView('/localGrocery');
                //}
            });
        };
    }])
    app.controller('orderGroceryCtrl',['$scope','$rootScope','$http','$location','localChaiService',function($scope,$rootScope,$http,$location,localChaiService){

    }])
})();