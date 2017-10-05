var app = angular.module('animali', []);

app.controller('animaliController', function($scope)
{
  $scope.animali = 
  [
    {nome:'Parrot', specie:'pappagallo', padrone:'pif'},
    {nome:'Rubbi', specie:'coniglio', padrone:'pif'},
    {nome:'Calendula', specie:'criceto', padrone:'jon'},
    {nome:'Gianfranco', specie:'pappagallo', padrone:'jon'},
    {nome:'Trump', specie:'pappagallo', padrone:'pif'},
  ];
  
  $scope.dacercare = '';
  
  $scope.mostra = function(p)
  {
    // Queste soluzioni risolvono il problema stile ajax
    // return ($scope.dacercare == p || $scope.dacercare == '' || p.indexOf($scope.dacercare)>=0);
    // return ($scope.dacercare == p || $scope.dacercare == '' || p.includes($scope.dacercare));
    if($scope.dacercare == p || $scope.dacercare=='')
      return true;

    for(var i=0; i<$scope.animali.length; i++)
      if($scope.animali[i].padrone == $scope.dacercare)
        return false;
    
    return true;
  }
  
});