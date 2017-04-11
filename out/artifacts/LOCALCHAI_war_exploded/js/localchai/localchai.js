/**
 * Created by rahul on 2/24/2017.
 */
(function(){
    var app=angular.module('localchai',[
        'ngRoute',
        'localChaiController',
        'localChaiDirective',
        'localChaiService'
    ]);
    app.controller('localchaiCtrl',['$scope','$rootScope', function ($scope, $rootScope){
        console.log('local chai started !!');
    }]);
    app.config(function ($routeProvider) {
        $routeProvider
            .when('/',{
                templateUrl: '/js/localchai/partials/groceryHome.html',
                //controller: 'groceryHomeCtrl',
                resolve:{
                    orderGrocery:['$http',function($http){
                        return  $http.post('/groceryhome.json');
                    }]
                }
            })
    })
})();
