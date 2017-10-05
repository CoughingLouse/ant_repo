/*
  utente inserisce numero N,
  creare tabella 'divisori', tab 'fattoriale' con i fattoriali di tutti i numeri da 1 a N,
  tabella 'esp' esponenziali
  con checkbox all'inizio entrambe checked PARI E DISPARI che mostrano rispettivamente i valori in tabella
*/
var app = angular.module('nellattesa', []);
app.controller('nellattesaController', function($scope)
{
  
  $scope.pari = true;
  $scope.dispari = true;
  
  $scope.numeri = [];
  
  
  $scope.aggiungi = function()
  {
    $scope.num = new $scope.Numero($scope.numero);
    $scope.numeri.push($scope.num);
    //console.log($scope.numeri);
    
  }
  
});
