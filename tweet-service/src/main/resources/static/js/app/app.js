var app = angular.module('serviceApp',['ui.router','ngStorage']);

app.constant('urls', {

    TWEET_SERVICE_API : 'http://tweet-service.southcentralus.cloudapp.azure.com:8083/ApplicationService/api/tweet',

    AUTH_SERVICE_API : 'http://tweet-auth.westus2.cloudapp.azure.com:8080/authApi/'
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

