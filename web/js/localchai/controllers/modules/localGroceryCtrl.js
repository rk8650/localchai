/**
 * Created by rahul on 4/2/2017.
 */
(function () {
    var app=angular.module('localGroceryCtrl',[]);
    app.controller('localGroceryCtrl',['$scope','$rootScope','localChaiService','$location',function($scope,$rootScope,localChaiService,$location){
        $scope.model=localChaiService.getModel();
        $scope.changeView=function(view){
            $location.path(view);
        };
        $scope.submit=function(){
            localChaiService.validateApplicationStep2($rootScope.orderGrocery).then(function(data){
                $scope.changeView('/confirmation');
            });
        };
    }]);
})();