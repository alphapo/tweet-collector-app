package fr.esipe.ing2.common.service;

import fr.esipe.ing2.common.model.Tweet;

import java.util.List;

public interface TweetService {
    Tweet findTweetById(Long id);
    void saveTweet(Tweet tweet);
    void updateTweet(Tweet tweet);
    void deleteTweetById(Long id);
    List<Tweet> findAllTweet();
}
