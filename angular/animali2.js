var app = angular.module('animali', []);

app.controller('animaliController', function($scope)
{
  $scope.nome = '';
  $scope.razza = '';
  $scope.nomep = '';
  $scope.cognomep = '';
  $scope.p = '';
  
  $scope.Animale = function(n,r,np,cp) 
  {
    this.nome = n;
    this.razza = r;
    this.nomep = np;
    this.cognomep = cp;
  }
    
  $scope.animali = 
  [ 
    new $scope.Animale('Wertinton','Bassotto','Alberto','Assetato'),
    new $scope.Animale('Pufoente','Cane','Bertoldo','Bevitore'),
    new $scope.Animale('Sally','Volpino','Carlo','Colpevole'),
    new $scope.Animale('Rodriguez','T-Rex','Dario','Delittuoso')
  ];

  $scope.aggiungi = function()
  {
    $scope.a = new $scope.Animale($scope.nome, $scope.razza, $scope.nomep, $scope.cognomep);
    $scope.animali.push($scope.a);
    $scope.nome = '';
    $scope.razza = '';
  }
  
  $scope.razzaEsistente = function(r)
  {
    var listaRazze = "Pechinese,Bassotto,Cane,Volpino,Pinscher,Boxer,Carlino".split(",");
    return listaRazze.includes(r);
  }
  
  $scope.ricercaPadrone = function(cp)
  {
    return ($scope.p == cp || $scope.p == '');
  }
});