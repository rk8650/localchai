<%--
  Created by IntelliJ IDEA.
  User: rahul
  Date: 2/24/2017
  Time: 11:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>

    <script src="${pageContext.request.contextPath}/js/common/angular.js" ></script>
    <script src="${pageContext.request.contextPath}/js/common/angular-route.js" ></script>
    <script src="${pageContext.request.contextPath}/js/localchai/localchai.js" ></script>
    <script src="${pageContext.request.contextPath}/js/localchai/controllers/localchai.controller.js"></script>
    <script src="${pageContext.request.contextPath}/js/localchai/controllers/modules/groceryHomeCtrl.js" ></script>
    <script src="${pageContext.request.contextPath}/js/localchai/controllers/modules/localGroceryCtrl.js" ></script>
    <script src="${pageContext.request.contextPath}/js/localchai/controllers/modules/orderGroceryCtrl.js" ></script>
    <script src="${pageContext.request.contextPath}/js/localchai/directive/localchai.directive.js" ></script>
    <script src="${pageContext.request.contextPath}/js/localchai/services/localchai.service.js" ></script>
  </head>
  <body>
    <div ng-app="localchai" ng-controller="localchaiCtrl">
      <div ng-view></div>
    </div>
  </body>
</html>