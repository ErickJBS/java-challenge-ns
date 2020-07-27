package mx.erickb.shortener.controller;

import mx.erickb.shortener.model.UrlRequest;
import mx.erickb.shortener.service.UrlService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.anyString;

@SpringBootTest
public class UrlControllerTest {

    @Autowired
    @InjectMocks
    private UrlController controller;

    @Mock
    private UrlService service;

    @Test
    public void saveUrlShouldReturnAlias() {
        Mockito.when(
                service.saveUrl(anyString())
        ).thenReturn("mockAlias");

        UrlRequest request = new UrlRequest("http://google.com/");
        String alias = controller.saveUrl(request);

        assertNotNull(alias);
    }
}
