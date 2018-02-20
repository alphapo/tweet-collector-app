package fr.esipe.ing2.scraper;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.tweetService.service.TweetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;


@EntityScan(basePackages = {"fr.esipe.ing2.common"} )
@EnableJpaRepositories(basePackages = {"fr.esipe.ing2.common.repositories"})
@SpringBootApplication

public class Application {
    /**
     * Main entry of this application.
     *
     * @param args arguments doesn't take effect with this example
     * @throws TwitterException when Twitter service or network is unavailable
     */


    @Autowired
    private TweetService tweetService; //Service which will do all data retrieval/manipulation work

    public static void main(String[] args) {

        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey("2LBo8gRYINFoOdPxuor05BO8C");
            cb.setOAuthConsumerSecret("zj8g1tEchpEcycVcub1NZR2xjJ7Pftr6VScTXqElro98Xg9Yt4");
            cb.setOAuthAccessToken("963482168084320256-qPctYL85POgZ8ZQzIlBaM9fnky7utZr");
            cb.setOAuthAccessTokenSecret("dZJa9zou4YjRtHaYS2LP0Fw9OJW2HBrSoIdTp7TPntS62");

            TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
            StatusListener listener = new StatusListener() {

            public void onStatus(Status status) {

                ////Enrégistrement du tweet////
                Long id = status.getUser().getId();
                int followersCount = status.getUser().getFollowersCount();
                String email = status.getUser().getEmail();
                String tag = status.getUser().getScreenName();
                String autheur = status.getUser().getName();
                String libelle = status.getText();
                Tweet tweet = new Tweet(id, followersCount, email, tag, autheur, libelle);
                System.out.println(tweet);

                tweetService.saveTweet(tweet);

            }

            public void onDeletionNotice(StatusDeletionNotice statusDeletionNotice) {
                System.out.println("Got a status deletion notice id:" + statusDeletionNotice.getStatusId());
            }

            public void onTrackLimitationNotice(int numberOfLimitedStatuses) {
                System.out.println("Got track limitation notice:" + numberOfLimitedStatuses);
            }

            public void onScrubGeo(long userId, long upToStatusId) {
                System.out.println("Got scrub_geo event userId:" + userId + " upToStatusId:" + upToStatusId);
            }

            public void onStallWarning(StallWarning warning) {
                System.out.println("Got stall warning:" + warning);
            }

            public void onException(Exception ex) {
                ex.printStackTrace();
            }
        };

        FilterQuery fq = new FilterQuery();
        String keywords[] = {"France"};

        fq.track(keywords);
        fq.language("fr");

        twitterStream.addListener(listener);
        twitterStream.filter(fq);

    }
}