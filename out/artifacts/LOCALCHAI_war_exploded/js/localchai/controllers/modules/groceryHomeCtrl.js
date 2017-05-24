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
        $scope.postDetails=function(grocery){
            //return  $http({
            //    method:'POST',
            //    url:''
            //});
            $http.get('/localGrocery.json',grocery);
        };
        window.nextStep=function(groceryHome){
            console.log("jhhnh b j h hj");
            if(groceryHome!=null && typeof groceryHome != undefined){
                var grocery={};
                grocery.locality=groceryHome[0];
                grocery.item=groceryHome[1];
                grocery.locality=groceryHome[2];
                $scope.postDetails(grocery);
                $scope.changeView('/localGrocery');
            }
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