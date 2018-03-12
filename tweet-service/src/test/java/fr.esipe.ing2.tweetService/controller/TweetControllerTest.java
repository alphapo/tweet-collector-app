/*
package fr.esipe.ing2.tweetService.controller;

import fr.esipe.ing2.common.model.Tweet;
import fr.esipe.ing2.tweetService.TweetController;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.ResponseEntity.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static sun.nio.cs.Surrogate.is;

@RunWith(SpringRunner.class)
@WebMvcTest(value = TweetController.class, secure = false)
public class TweetControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TweetController tweetController;

    @Test
    public void retrieveDetailsForCourse() throws Exception {

        Tweet tweet = new Tweet();
        List<Tweet> tweetList = singletonList(tweet);

        given(tweetController.listAllTweets()).willReturn();

        mockMvc.perform(get("")
                .contentType(APPLICATION_JSON)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].city", is(arrival.getCity()))));
    }
    @After
    public  void downUp(){
        this.mockMvc = null;
    }
}
*/
