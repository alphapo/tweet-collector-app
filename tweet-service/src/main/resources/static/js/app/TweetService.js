'use strict';

angular.module('serviceApp').factory('TweetService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllTweets: loadAllTweets,
                getAllTweets: getAllTweets,
                findUser: findUser,
            };

            return factory;

            function loadAllTweets() {
                console.log('Fetching all tweet');
                var deferred = $q.defer();
                $http.get(urls.TWEET_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all tweet');
                            $localStorage.tweets = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading tweet');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

            function getAllTweets(){
                return $localStorage.tweets;
            }

            function findUser(login, password) {
                console.log('Fetching User');
                var deferred = $q.defer();
                $http.get(urls.AUTH_SERVICE_API + login+'/'+password)
                    .then(
                        function (response) {
                            console.log('Fetched successfully');
                            deferred.resolve(response.data);
                            console.log(Response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }

        }
    ]);