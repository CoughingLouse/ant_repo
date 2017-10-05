var app = angular.module('script', []);

app.controller('scriptController', function($scope, $http)
{
	$scope.mostra = 'home';
	$scope.np = {} // new person
	$scope.nh = {} // new hobby
	$scope.personidtodelete = 0;

	$scope.ricarica = function()
	{
		$http.get("Index?command=peoplejson")
		.then(function(response)
		{
			$scope.peoplejson = response.data;
		});
		
		$http.get("Index?command=hobbyjson")
		.then(function(response)
		{
			$scope.hobbyjson = response.data;
		});
	}
	$scope.ricarica();

	$scope.insertPerson = function()
	{
		//var query = "Index?command=insertperson&name="+n+"&age="+a+"&profession="+p+"&hobbies="+h;
		var query = "Index?command=insertperson&name="+ $scope.np.name
					+ "&age=" + $scope.np.age
					+ "&profession=" + $scope.np.profession
					+ "&hobbies=" + $scope.np.hobbies;
		
		$http.get(query)
		.then(function(response)
		{
			$scope.np = {};
			alert("Persona salvata con successo");
			$scope.ricarica();
			$scope.mostra = "list";
		});
	}
	
	$scope.insertHobby = function()
	{
		var query = "Index?command=inserthobby&name="+ $scope.nh.name;
		
		$http.get(query)
		.then(function(response)
		{
			$scope.nh = {};
			alert("Hobby salvato con successo");
			$scope.ricarica();
			$scope.mostra = "hobbyjson";
		});
	}
	
	$scope.deletePerson = function()
	{
		var query = "Index?command=deleteperson&id="+ $scope.personidtodelete;
		
		$http.get(query)
		.then(function(response)
		{
			$scope.personidtodelete = {};
			alert("Persona cancellata con successo");
			$scope.ricarica();
			$scope.mostra = "list";
		});
	}

});