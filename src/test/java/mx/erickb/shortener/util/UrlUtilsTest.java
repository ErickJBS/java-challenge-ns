package mx.erickb.shortener.util;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertTrue;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlUtilsTest {

    @Autowired
    private UrlUtils utils;

    @Test
    public void generateUrlAliasShouldReturnGoogleFormat() {
        String url = "https://www.google.com/search?q=colors";
        String alias = utils.generateUrlAlias(url);

        String pattern = "^[a-zA-Z]{5}$";
        assertTrue(alias.matches(pattern));
    }

    @Test
    public void generateUrlAliasShouldReturnYahooFormat() {
        String url = "https://news.yahoo.com";
        String alias = utils.generateUrlAlias(url);

        String pattern = "^[a-zA-Z0-9]{7}$";
        assertTrue(alias.matches(pattern));
    }

    @Test
    public void generateUrlAliasShouldReturnGenericFormat() {
        String url = "www.coursera.org/professional-certificates";
        String alias = utils.generateUrlAlias(url);

        String pattern = "^[b-df-hj-np-tv-z]+$";
        assertTrue(alias.toLowerCase().matches(pattern));
    }
}
