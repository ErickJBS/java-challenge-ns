package mx.erickb.shortener.service;

import mx.erickb.shortener.util.UrlUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UrlService implements IUrlService {

    private final UrlUtils aliasUtils;
    private final Map<String, String> store = new HashMap<>();

    @Autowired
    public UrlService(UrlUtils aliasUtils) {
        this.aliasUtils = aliasUtils;
    }

    @Override
    public String getUrl(String alias) {
        return this.store.get(alias);
    }

    @Override
    public String saveUrl(String url) {
        String alias = aliasUtils.generateUrlAlias(url);
        this.store.put(alias, url);
        return alias;
    }
}
