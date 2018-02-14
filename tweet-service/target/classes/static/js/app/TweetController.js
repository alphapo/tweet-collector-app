'use strict';

angular.module('serviceApp').controller('TweetController',
    ['TweetService', '$scope',  function( TweetService, $scope) {

        var self = this;
        self.tweet = {};
        self.tweets=[];

        self.getAllTweets = getAllTweets;

        self.successMessage = '';
        self.errorMessage = '';
        self.done = false;

        self.onlyIntegers = /^\d+$/;
        self.onlyNumbers = /^\d+([,.]\d+)?$/;

        function getAllTweets(){
            return TweetService.getAllTweets();
        }
    }


    ]);