package mx.erickb.shortener.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

