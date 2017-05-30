/**
 * Created by rahul on 4/9/2017.
 */
(function(){
    var app=angular.module('groceryHomeCtrl',[]);
    app.controller('groceryHomeCtrl',['$scope','$http','$location','orderGrocery',function($scope,$http,$location,orderGrocery){
        console.log("my nam ie");
        $scope.pageName='grocery home page';
        $scope.changeView=function(view){
            $location.path(view);
        };
        window.nextStep=function(groceryHome){
            console.log("jhhnh b j h hj");
            if(groceryHome!=null && typeof groceryHome != "undefined" && typeof $scope.groceryHome.itemName.$modelValue != "undefined"){
                var grocery={};
                grocery.locality=$scope.groceryHome.localityName.$modelValue;
                grocery.itemDetailsList=$scope.groceryHome.itemName.$modelValue.split(",");
                grocery.quantity=$scope.groceryHome.quantity.$modelValue;
                $scope.postDetails(grocery);

            }
        };
        $scope.postDetails=function(grocery){

            return  $http({
                url:   '/localGrocery.json',
                method: 'POST',
                headers:{
                    'Content-Type':'application/json'
                },
                data:grocery
            }).success(function(data,status){
                $scope.changeView('/localGrocery');
            });
            //$http.get('/localGrocery.json',grocery);
            //$http.setRequestHeader('Content-Type','application/json');
            //$httpProvider.defaults.headers.get = { 'Content-Type':'application/json' }
        };
        $scope.orderGrocery=orderGrocery.data;
        $scope.setLocalityName=function(localityName){
            var locality=document.getElementById("locality").value;
            document.getElementById("locality").value=locality+localityName;
        };
        $scope.setItemName=function(itemName){
            document.getElementById("item").value=itemName;
        };
    }])
})();