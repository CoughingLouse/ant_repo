/*
  utente inserisce numero N,
  creare tabella 'divisori', tab 'fattoriale' con i fattoriali di tutti i numeri da 1 a N,
  tabella 'esp' esponenziali
  con checkbox all'inizio entrambe checked PARI E DISPARI che mostrano rispettivamente i valori in tabella
*/
var app = angular.module('nellattesa', []);
app.controller('nellattesaController', function($scope)
{
  $scope.divisori = [];
  $scope.fattoriali = [];
  $scope.esponenziali = [];
  $scope.numero = 0;
  $scope.count = 0;
  $scope.pari = true;
  $scope.dispari = true;
  
  $scope.numeri = [];
  
  $scope.div = function()
  {
    var div = [];
    for(var i=0; i<=$scope.numero; i++)
      if($scope.numero%i == 0)
        {
          if( ($scope.pari && i%2 == 0) || ($scope.dispari && i%2 != 0) )
             div.push(i);
        }
    return div;
  }
  
  $scope.fat = function()
  {
    var fat = [];
    var per = 1;
    
    for(var i=$scope.numero; i>0; i--) // scorro da N a 1
    {
      per = 1;
      for(var k=i; k>1; k--) // calcolo fattoriali di ognuno dei tal valori
      {
        per *= k;
      }
      fat.push(per);
    }
    return fat; 
  }
  
  $scope.esp = function()
  {
    var rtn = [];
    for(var i=$scope.numero; i>0; i--)
    {
      var val = i*$scope.numero;
      console.log(i*$scope.numero);
      rtn.push[val];
    }
    console.log("esp(): " + rtn);
    return rtn;
  }
  
  $scope.conta = function()
  {
    var ris;
    ris = $scope.divisori.length + $scope.fattoriali.length + $scope.esponenziali.length;
    //console.log("conta(): "+$scope.divisori.length+" "+$scope.fattoriali.length+" "+$scope.esponenziali.length);
    return ris;
  }
  
  $scope.Numero = function(n)
  {
    this.numero = n;
    this.divisori = $scope.div();
    this.fattoriali = $scope.fat();
    this.esponenziali = $scope.esp();
    this.count = $scope.conta();
  }
  
  $scope.aggiungi = function()
  {
    $scope.num = new $scope.Numero($scope.numero);
    $scope.numeri.push($scope.num);
    //console.log($scope.numeri);
  }
  
});
