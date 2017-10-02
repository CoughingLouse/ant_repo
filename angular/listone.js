var app = angular.module('listone', []);

app.controller('listoneController', function($scope)
{
  $scope.persone = [];
  
  $scope.nome = '';
  $scope.cognome = '';
  $scope.eta = 0;
  
  $scope.Persona = function(n,c,e)
  {
    this.nome = n;
    this.cognome = c;
    this.eta = parseInt(e);
  };
  
  $scope.aggiungi = function()
  {
    $scope.p = new $scope.Persona($scope.nome, $scope.cognome, $scope.eta);
    $scope.persone.push($scope.p);
    console.log($scope.persone);
  }
});