var app = angular.module('curriculae', []);

app.controller("curriculaeController", function($scope)
{
  $scope.cv = {};
  $scope.cvs = [];
  /*
  $scope.nome = "";
  $scope.cognome = "";
  $scope.eta = 0;
  $scope.nascita = undefined;
  $scope.residenza = "";
  $scope.telefono = "";
  $scope.esperienze = [];
  $scope.skills = [];
  */
  
  $scope.CV = function(n,c,e,na,re,te)
  {
    this.nome = n;
    this.cognome = c;
    this.eta = e;
    this.nascita = na;
    this.residenza = re;
    this.telefono = te;
  }

  $scope.aggiungi = function()
  {
    console.log($scope.cv);
    $scope.cvs.push($scope.cv);
    $scope.cv = {}
  }
                 
               
});