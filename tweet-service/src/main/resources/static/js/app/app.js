var app = angular.module('serviceApp',['ui.router','ngStorage']);

app.constant('urls', {
    BASE: 'http://localhost:8083/ApplicationService',
    TWEET_SERVICE_API : 'http://localhost:8083/ApplicationService/api/tweet'
});

app.config(['$stateProvider', '$urlRouterProvider',
    function($stateProvider, $urlRouterProvider) {

        $stateProvider
            .state('home', {
                url: '/',
                templateUrl: 'partials/list',
                controller:'TweetController',
                controllerAs:'ctrl',
                resolve: {
                    tweets: function ($q, TweetService) {
                        console.log('Load all tweet');
                        var deferred = $q.defer();
                        TweetService.loadAllTweets().then(deferred.resolve, deferred.resolve);
                        return deferred.promise;
                    }
                }
            });
        $urlRouterProvider.otherwise('/');
    }]);

