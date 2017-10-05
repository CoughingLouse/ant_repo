/*
  scrivere un programma angular che fa inserire il codice, il nome e il prezzo
  di un prodotto di un negozio...i prodotti verranno poi inseriti in un vettore
  e stampati sotto alla form con un ng-repeat
*/

var app = angular.module('yaritarda', []);

app.controller('yaritardaController', function($scope)
{
  $scope.codice = '';
  $scope.nome = '';
  $scope.prezzo = 0;

  $scope.clear = function()
  {
    $scope.codice = '';
    $scope.nome = '';
    $scope.prezzo = 0;
  }
  
  $scope.Prodotto = function(c,n,p)
  {
    this.codice = c;
    this.nome = n;
    this.prezzo = parseInt(p);
  }
  
  $scope.prodotti =
  [
    new $scope.Prodotto('abc','motherboard',100),
    new $scope.Prodotto('def','ssd',90),
    new $scope.Prodotto('ghi','mouse',10)
  ];
    
  $scope.aggiungi = function()
  {
    $scope.prod = new $scope.Prodotto($scope.codice, $scope.nome, $scope.prezzo);
    $scope.prodotti.push($scope.prod);
    console.log($scope.prodotti);
    $scope.clear();
  }
  
});