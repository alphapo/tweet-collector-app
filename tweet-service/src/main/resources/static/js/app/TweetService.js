'use strict';

angular.module('serviceApp').factory('TweetService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {

            var factory = {
                loadAllTweets: loadAllTweets,
                getAllTweets: getAllTweets,
                getTweet: getTweet,
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

            function getTweet(id) {
                console.log('Fetching User with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.TWEET_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Tweet with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading Tweet with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
        }
    ]);