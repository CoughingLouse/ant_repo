var app = angular.module('animali', []);

app.controller('animaliController', function($scope)
{
  $scope.animali = [];
  $scope.nome = '';
  
  $scope.Animale = function(n) 
  {
    this.nome = n;
  }
  
  $scope.aggiungi = function()
  {
    $scope.a = new $scope.Animale($scope.nome);
    $scope.animali.push($scope.a);
    $scope.nome = ''; // clear
    /* senza filter orderBy, usare questo
    $scope.animali.sort(function(x, y) { 
      return x.nome > y.nome;});
    */
  }
});