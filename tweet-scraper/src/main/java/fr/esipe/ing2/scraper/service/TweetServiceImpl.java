package fr.esipe.ing2.scraper.service;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.common.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service("tweetService")
@Transactional
public class TweetServiceImpl implements TweetService {

    @Autowired
    private TweetRepository tweetRepository;

    public void saveTweet(Tweet tweet) {

        try{
            if (null != tweet) {
                tweetRepository.save(tweet);
            }
        }
        catch (Exception e){}
    }

}
