package fr.esipe.ing2.scraper;

import fr.esipe.ing2.common.model.Tweet;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

@SpringBootApplication(scanBasePackages={"fr.esipe.ing2.scraper"})// same as @Configuration @EnableAutoConfiguration @ComponentScan
public class Application {
    /**
     * Main entry of this application.
     *
     * @param args arguments doesn't take effect with this example
     * @throws TwitterException when Twitter service or network is unavailable
     */
    public static void main(String[] args) throws TwitterException {
        SpringApplication.run(Application.class, args);

        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey("xvz1evFS4wEEPTGEFPHBog");
            cb.setOAuthConsumerSecret("xvz1evFS4wEEPTGEFPHBog");
            cb.setOAuthAccessToken("370773112-GmHxMAgYyLbNEtIKZeRNFsMKPR9EyMZeS9weJAEb");
            cb.setOAuthAccessTokenSecret("xvz1evFS4wEEPTGEFPHBog");

            TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
            StatusListener listener = new StatusListener() {

            public void onStatus(Status status) {
                System.out.println("@" + status.getUser().getScreenName() + " - " + status.getText());

                ////Enrégistrement du tweet////
                ScraperController scraperController = new ScraperController();
                Tweet tweet = new Tweet(status.getUser().getScreenName(), status.getText());
                scraperController.saveTWeet(tweet);
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