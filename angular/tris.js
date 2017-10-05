var app = angular.module('tris', []);

app.controller('trisController', function($scope)
{
  $scope.casella = function(x,y)
  {
    this.x = x;
    this.y = y;
    this.valore = 'N';
  }
  
  $scope.tabellone = [[],[],[]];
  
  $scope.turno = true;
  
  $scope.posiziona = function(c)
  {
    if(c.valore == "N")
    {
      if($scope.turno)
      {
        c.valore = "X";
        $scope.turno = false;
      }
      else
      {
        c.valore = "O";
        $scope.turno = true;
      }
    }
  }
  
  $scope.gioca = function()
  {
    for(var x=0; x<3; x++)
      for(var y=0; y<3; y++)
        $scope.tabellone[x][y] = new $scope.casella(x,y);
  }
  $scope.gioca(); //init
  
  $scope.vincitore0 = function()
  {
    var t = $scope.tabellone;

    if(
        (t[0][0].valore == t[0][1] && t[0][1] == t[0][2]) //riga1
        ||
        (t[1][0].valore == t[1][1] && t[1][1] == t[1][2]) //riga2
        ||
        (t[2][0].valore == t[2][1] && t[2][1] == t[2][2]) //riga3
        ||
        (t[0][0].valore == t[1][0] && t[1][0] == t[2][0]) //col1
        ||
        (t[0][1].valore == t[1][1] && t[1][1] == t[2][1]) //col2
        ||
        (t[0][2].valore == t[0][1] && t[0][1] == t[0][2]) //col3
        ||
        (t[0][0].valore == t[1][1] && t[1][1] == t[2][2]) //diag sx
        ||
        (t[0][2].valore == t[1][1] && t[1][1] == t[2][0]) //diag dx
      )
      {
        if($scope.turno)
          return 'X';
        else
          return 'O';
      }
      return;
  }
  
  $scope.vincitore = function() // verifica
  {
    for(var r = 0; r<3; r++)
    {
      if
      (
        $scope.tabellone[0][r].valore
        ==
        $scope.tabellone[1][r].valore
        &&
        $scope.tabellone[0][r].valore
        ==
        $scope.tabellone[2][r].valore
        &&
        $scope.tabellone[0][r].valore != 'N'
      )
        return $scope.tabellone[0][r].valore;
      
      if
      (
        $scope.tabellone[r][0].valore
        ==
        $scope.tabellone[r][1].valore
        &&
        $scope.tabellone[r][0].valore
        ==
        $scope.tabellone[r][2].valore
        &&
        $scope.tabellone[r][0].valore != 'N'
      )
        return $scope.tabellone[r][0].value;
      
      if
      (
        $scope.tabellone[0][0].valore
        ==
        $scope.tabellone[1][1].valore
        &&
        $scope.tabellone[0][0].valore
        ==
        $scope.tabellone[2][2].valore
        &&
        $scope.tabellone[0][0].valore != 'N'
      )
        return $scope.tabellone[0][0].value;
      
      if
      (
        $scope.tabellone[2][0].valore
        ==
        $scope.tabellone[1][1].valore
        &&
        $scope.tabellone[0][2].valore
        ==
        $scope.tabellone[1][1].valore
        &&
        $scope.tabellone[0][0].valore != 'N'
      )
        return $scope.tabellone[2][0].value;
    }
    
    return "";
  }
  
});