'use strict';

angular.module('angular', ['ngAnimate', 'ngCookies', 'ngTouch', 'ngSanitize', 'ngRoute', 'ngMaterial'])
    .config(function ($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'app/main/main.html',
                controller: 'MainCtrl'
            })
            .when('/tweets', {
                templateUrl: 'app/tweets/tweets.html',
                controller: 'TweetsCtrl'
            })
            .otherwise({
                redirectTo: '/'
            });
    })
;
