package fr.esipe.ing2.tweetService.service;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.common.repositories.TweetRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import javax.transaction.Transactional;
import java.util.List;

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

    public List<Tweet> findAllTweet(){
        return tweetRepository.findAll();
    }
}
