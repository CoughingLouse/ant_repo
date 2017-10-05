var app = angular.module('ajax', []);

app.controller('ajaxController', function($scope, $http)
{
  $http.get("http://localhost:8080/mRipasso/Index?command=peoplejson")
  .then(function(response)
  {
    console.log(response.data);      
  });
});