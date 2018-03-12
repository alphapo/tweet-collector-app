package fr.esipe.ing2.tweetService.service;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.common.repositories.TweetRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class TweetServiceImplTest {

    @Mock
    TweetRepository tweetRepository;
    @InjectMocks
    private TweetServiceImpl tweetServiceImpl;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void getTweetsShouldReturnAllTweet() throws Exception{
        //
        //GIVEN
        //
        List<Tweet> expectedTweetList = new ArrayList<Tweet>();
        expectedTweetList.add(new Tweet(12345678910L, 23, "tweet@gmail.com", "@macron", "autheur", "Vive macron"));

            when(tweetRepository.findAll()).thenReturn(expectedTweetList);

        //
        //WHEN
        //
        List<Tweet> actualTweetList = tweetServiceImpl.findAllTweet();

        //
        //THEN
        //
        Assert.assertEquals(expectedTweetList, actualTweetList);
        Assert.assertEquals(expectedTweetList.hashCode(), actualTweetList.hashCode());
        Assert.assertEquals(expectedTweetList.toString(), actualTweetList.toString());


    }
}
