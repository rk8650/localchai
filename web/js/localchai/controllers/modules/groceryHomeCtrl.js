/**
 * Created by rahul on 4/9/2017.
 */
(function(){
    var app=angular.module('groceryHomeCtrl',[]);
    app.controller('groceryHomeCtrl',['$scope','$rootScope','$http','$location','orderGrocery','localChaiService',function($scope,$rootScope,$http,$location,orderGrocery,localChaiService){
        $scope.changeView=function(view){
            $location.path(view);
        };
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
        $scope.submit=function(){
            localChaiService.validateApplicationStep3().then(function(data){

            })
        }
    }])
})();