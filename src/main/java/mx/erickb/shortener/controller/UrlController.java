package mx.erickb.shortener.controller;

import mx.erickb.shortener.model.UrlRequest;
import mx.erickb.shortener.service.IUrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
public class UrlController {

    final private IUrlService urlAliasService;

    @Autowired
    public UrlController(IUrlService urlAliasService) {
        this.urlAliasService = urlAliasService;
    }

    @PostMapping(produces = "application/json")
    String saveUrl(@RequestBody UrlRequest requestBody) {
        String alias = this.urlAliasService.saveUrl(requestBody.getUrl());
        return String.format("{ \"alias\": \"%s\"}", alias);
    }

    @GetMapping(path = "/{alias}", produces = "application/json")
    String getUrl(@PathVariable String alias, HttpServletResponse httpResponse) throws IOException {
        String url = this.urlAliasService.getUrl(alias);
        if(url != null) {
            // TODO: Fix redirect
            httpResponse.sendRedirect(url);
            return null;
        } else {
            String error = "Alias " + alias + " not found";
            httpResponse.setStatus(404);
            return String.format("{ \"error\": \"%s\"}", error);
        }
    }
}
