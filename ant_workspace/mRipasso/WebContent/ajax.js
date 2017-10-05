var app = angular.module('ajax', []);

app.controller('ajaxController', function($scope, $http)
{
  $http.get("Index?command=peoplejson")
  .then(function(response)
  {
    $scope.cippirimerlo = response.data;
  });
});