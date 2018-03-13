'use strict';

angular.module('serviceApp').controller('TweetController',
    ['TweetService', '$scope',  function( TweetService, $scope) {

        var self = this;
        self.tweet = {};
        self.tweets=[];
        self.logged='';
        self.user = {};
        self.token = '';

        self.submit = submit;
        self.logOut = logOut;
        self.getAllTweets = getAllTweets;

        self.errorMessage = '';
        self.done = false;

        function getAllTweets(){
            return TweetService.getAllTweets();
        }

        function submit() {
            TweetService.findUser(self.user.login, self.user.password)
                .then(
                    function (response) {
                        self.token=response.token;
                        self.logged = 'success';

                    },
                    function (errResponse) {
                        self.logged='error';
                        self.errorMessage = 'Echec Authentification'
                    }
                );
        }
        function logOut() {

                        self.token='';
                        self.logged = 'disconnect';
        }

    }


    ]);