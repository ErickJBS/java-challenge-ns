package mx.erickb.shortener.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UrlServiceTest {

    @Autowired
    private IUrlService urlService;

    @Test
    public void saveUrlShouldReturnTheSameAlias() {
        String testUrl = "https://cloud.google.com";

        String alias1 = urlService.saveUrl(testUrl);
        String alias2 = urlService.saveUrl(testUrl);

        assertEquals(alias1, alias2);
    }

    @Test
    public void getUrlShouldReturnUrl() {
        String testUrl = "https://cloud.google.com";

        String alias = urlService.saveUrl(testUrl);
        String url = urlService.getUrl(alias);

        assertEquals(testUrl, url);
    }

}

