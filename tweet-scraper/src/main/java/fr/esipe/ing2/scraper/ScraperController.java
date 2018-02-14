package fr.esipe.ing2.scraper;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.common.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;

public class ScraperController {

    public ScraperController(){
    }

    @Autowired
    TweetService tweetService; //Service which will do all data retrieval/manipulation work

    // -------------------Save tweet---------------------------------------------

    public void saveTWeet(Tweet tweet) {
        tweetService.saveTweet(tweet);
    }
}
