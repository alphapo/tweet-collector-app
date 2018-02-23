package fr.esipe.ing2.scraper;

import fr.esipe.ing2.common.model.Tweet;
import twitter4j.*;
import org.apache.log4j.Logger;
import twitter4j.conf.ConfigurationBuilder;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;
import java.util.Properties;
import java.sql.*;
import org.apache.log4j.Logger;
import org.apache.commons.lang.StringEscapeUtils;

public class Application {
    /**
     * Main entry of this application.
     *
     * @param args arguments doesn't take effect with this example
     * @throws TwitterException when Twitter service or network is unavailable
     */

    private static final Logger logger = Logger.getLogger(Application.class);



    public static void main(String[] args) {


        ConfigurationBuilder cb = new ConfigurationBuilder();
            cb.setDebugEnabled(true);
            cb.setOAuthConsumerKey("2LBo8gRYINFoOdPxuor05BO8C");
            cb.setOAuthConsumerSecret("zj8g1tEchpEcycVcub1NZR2xjJ7Pftr6VScTXqElro98Xg9Yt4");
            cb.setOAuthAccessToken("963482168084320256-qPctYL85POgZ8ZQzIlBaM9fnky7utZr");
            cb.setOAuthAccessTokenSecret("dZJa9zou4YjRtHaYS2LP0Fw9OJW2HBrSoIdTp7TPntS62");

            final TwitterStream twitterStream = new TwitterStreamFactory(cb.build()).getInstance();
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

                logger.info("tweet id: "+tweet.getId()+"," +
                            "tweet followers numbers: "+tweet.getFollewersCount()+","+
                            "tweet email: "+tweet.getEmail()+","+
                            "tweet tag: "+StringEscapeUtils.escapeJava(tweet.getTag())+","+
                            "tweet author: "+StringEscapeUtils.escapeJava(tweet.getAuteur())+","+
                            "tweet title: "+StringEscapeUtils.escapeJava(tweet.getLibelle())
                            );

                try {
                    Properties properties = loadConfigurationFile("conf.properties");

                    Connection conn = null;
                    Statement st = null;
                    Class.forName(properties.getProperty("driverClassName")).newInstance();
                    conn = DriverManager.getConnection(
                            properties.getProperty("url"),
                            properties.getProperty("username"),
                            properties.getProperty("password"));

                    st = conn.createStatement();
                    st.executeUpdate("insert into tweet " +
                            "VALUES("+ tweet.getId() + "," +
                            "" + tweet.getFollewersCount() + "," +
                            "\"" + tweet.getEmail() + "\"," +
                            "\"" + StringEscapeUtils.escapeJava(tweet.getTag()) + "\"," +
                            "\"" + StringEscapeUtils.escapeJava(tweet.getAuteur()) + "\"," +
                            "\"" + StringEscapeUtils.escapeJava(tweet.getLibelle()) + "\")" +
                            "");
                }catch(SQLException se) {
                    se.printStackTrace();
                } catch(Exception e) {
                    e.printStackTrace();
                }
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

    static Properties loadConfigurationFile(String propertiesFile){

        Properties properties = new Properties();
        InputStream input = null;

        try {

            input = Application.class.getClassLoader().getResourceAsStream(propertiesFile);
            // load a properties file
            properties.load(input);

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return properties;

    }


}