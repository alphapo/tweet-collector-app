package fr.esipe.ing2.common.service;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.common.repositories.TweetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service("tweetService")
@Transactional
public class TweetService{

    @Autowired
    private TweetRepository tweetRepository;

    public Tweet findTweetById(Long id) {
        return tweetRepository.findOne(id);
    }

    public void saveTweet(Tweet tweet) {

        try{
            if (null != tweet) {
                tweetRepository.save(tweet);
            }
        }
        catch (Exception e){}
    }

    public void updateTweet(Tweet tweet){
        saveTweet(tweet);
    }

    public void deleteTweetById(Long id){
        tweetRepository.delete(id);
    }

    public List<Tweet> findAllTweet(){
        return tweetRepository.findAll();
    }

}

