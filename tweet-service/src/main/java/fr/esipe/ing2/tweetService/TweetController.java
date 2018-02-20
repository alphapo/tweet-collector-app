package fr.esipe.ing2.tweetService;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.common.service.TweetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TweetController {

    TweetService tweetService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All tweet---------------------------------------------

    @GetMapping(value = "/tweet")
    public ResponseEntity<List<Tweet>> listAllTweets() {
        List<Tweet> tweet = tweetService.findAllTweet();
        if (tweet.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Tweet>>(tweet, HttpStatus.OK);
    }

}