/**
 * Created by rahul on 4/2/2017.
 */
(function () {
    var app=angular.module('localGroceryCtrl',[]);
    app.controller('localGroceryCtrl',function($scope,$rootScope){
        $scope.shopDetails=$rootScope.shopDetails;
    });
})();