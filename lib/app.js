var app = angular.module('myApp', ['ngRoute', 'angularUtils.directives.dirPagination', 
                                    'ui.bootstrap', 'ngCookies']);

app.config(function($routeProvider) {
	$routeProvider
		// route for the home page
		.when('/home', {
			templateUrl : 'pages/home.html',
			controller  : 'JobListCtrl'
		})

		.when('/job-detail/:id', {
	        templateUrl: 'pages/job-detail.html',
	        controller: 'JobDetailCtrl'
      	})

		.when('/post-job', {
	        templateUrl: 'pages/post-job.html',
	        controller: 'PostJobCtrl'
      	})

    .when('/login', {
      templateUrl: 'pages/login.html',
	    controller: 'LoginCtrl'
    })

    .when('/dashboard', {
        templateUrl: 'pages/dashboard.html',
        controller: 'DashboardCtrl'
    })

		// route for the about page
		.when('/about', {
			templateUrl : 'pages/about.html',
			controller  : 'aboutController'
		})

		// route for the contact page
		.when('/contact', {
			templateUrl : 'pages/contact.html',
			controller  : 'contactController'
		})
		.otherwise({
        	redirectTo: '/home'
      });
});

app.controller('JobListCtrl', ['$scope', '$http', function($scope, $http){
	$scope.jobs = []; //declare an empty array
	$http.get("http://localhost:8080/chinese_jobs_board/rest/loadList")
			.success(function(response){ 
		$scope.jobs = response;  //ajax request to fetch data into $scope.data
	});
	
}]);

app.controller('JobDetailCtrl', ['$scope', '$routeParams', '$http',
  function($scope, $routeParams, $http) {
  	//console.log($routeParams.id);
    $http.get('http://localhost:8080/chinese_jobs_board/rest/loadJob?id=' + $routeParams.id)
    		.success(function(data) {
    $scope.job = data;
    });   

}]);

app.controller('PostJobCtrl', function ($scope, $http, alertService, $location) {
	$scope.post = function() {
        var jobdata = {
        	jobName : $scope.postTitle,
        	location: $scope.postLocation,
        	contact: $scope.postEmail,
        	details: $scope.postDescription,
        	datePost: "Dec 30 2015"
      	};

      	$http.post('http://localhost:8080/chinese_jobs_board/rest/job/postJob', jobdata)
          .error(function(data, status) {
            if(status === 401) {
              $location.path('/login');
            } else if(status === 500) {
              alertService.add('danger', 'Internal server error!');
            } else {
              alertService.add('danger', 'Check console log for more details...');
            }
          })
          .success(function(data) {
            $scope.postTitle = '';
            $scope.postLocation = '';
            $scope.postEmail = '';
            $scope.postDescription = '';
            alertService.add('success', 'Job posted successfully');
            //alert('Job posted successfully');
            $location.path('/dashboard');
        });
  };
});


app.controller('LoginCtrl', function (Auth, $scope, $http, $log, alertService, $location, userService) {

      $scope.signup = function() {

        var signupData = {
          userId : $scope.username,
          password : $scope.password
        };

        $http.post('http://localhost:8080/chinese_jobs_board/rest/createUser', signupData)
            .error(function(data, status) {
              if(status === 500) {
                alertService.add('danger', 'Internal server error!');
              }
            })
            .success(function(data, status, headers, config) {
                userService.username = $scope.username;
                Auth.setCredentials($scope.username, $scope.password);

                $location.path('/dashboard');

            });
      };


      $scope.signin = function() {

        var signinData = {
          userId : $scope.loginName,
          password : $scope.loginPass
        };

        $http.post('http://localhost:8080/chinese_jobs_board/rest/isUser', signinData)
            .error(function(data, status){
              if(status === 401) {
                alertService.add('danger', 'Invalid login or password!');
              } else if(status === 500) {
                alertService.add('danger', 'Internal server error!');
              } else {
                alertService.add('danger', 'Check console log for more details...');
              }
            })
            .success(function(data){
                userService.username = $scope.loginName;
                Auth.setCredentials(signinData.userId, signinData.password);
                $location.path('/dashboard');          
            });
      };
});


app.controller('LoginbarCtrl', function (Auth, $scope, $http, userService, $location) {
      $scope.user = userService;

      $scope.logout = function() {
          userService.username = '';
          Auth.clearCredentials();
          $location.path('/home');
      };

      $scope.$watch('user.username', function (newVal) {
        if(newVal === '') {
          $scope.isLoggedIn = false;
        } else {
          $scope.username = newVal;
          $scope.isLoggedIn = true;
        }
      });
    });

app.controller('DashboardCtrl', function ($scope, $log, $http, alertService, $location) {

      $scope.loadPosts = function() {
        $http.get('/app/userposts')
            .error(function(data, status) {
              if(status === 401) {
                $location.path('/login');
              } else {
                alertService.add('danger', 'Check console log for more details...');
              }
            })
            .success(function(data) {
              $scope.posts = data;
            });
      };

      //$scope.loadPosts();
    });

app.controller('aboutController', function($scope) {

});

app.controller('contactController', function($scope) {

});