package fr.esipe.ing2.tweetService.service;

import fr.esipe.ing2.common.model.Tweet;

import java.util.List;

public interface TweetService{

        void saveTweet(Tweet tweet);
        List<Tweet> findAllTweet();


}

