(function(){
  
  //angular module
  var myApp = angular.module('myApp', ['treeView']);

  //test controller
  myApp.controller('myController', function($scope,$http){

	$http.get("http://localhost:9111/marek-java/api/nodes/")
		.then(function(response) {
			$scope.java = response.data.data;
			console.log($scope.myWelcome);
		});
	$http.get("http://localhost:9222/marek-scala/api/nodes")
		.then(function(response) {
			$scope.scala = response.data.data;
			console.log($scope.myWelcome);
		});
	
  	//test tree model 1
    $scope.mock = [
        { "name" : "AAAAA", "id" : "1", "nodes" : 
			[
				{ "name" : "AA", "id" : "2", "nodes" : 
					[
						{ "name" : "AA1", "id" : "3", "nodes" : [] },
						{ "name" : "AA2", "id" : "4", "nodes" : [] }
					] 
				},
				{ "name" : "AB", "id" : "5", "nodes" : [] }
			] 
		},
		{ "name" : "BBBBBB", "id" : "6", "nodes" : []},
		{ "name" : "C", "id" : "7", "nodes" : 
			[   
				{ "name" : "CA", "id" : "8", "nodes" : 
					[
						{ "name" : "CA1", "id" : "9", "nodes" : []},
						{ "name" : "CA2", "id" : "10", "nodes" : []},
					]
				},
			]},
		{ "name" : "D", "id" : "11", "nodes" : 
			[
				{ "name" : "DA", "id" : "12", "nodes" : []}
			]
		},
      ];

     $scope.dataList = $scope.mock;
  });
})();