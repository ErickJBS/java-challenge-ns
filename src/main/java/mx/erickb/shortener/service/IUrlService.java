package mx.erickb.shortener.service;

public interface IUrlService {
    String getUrl(String alias);
    String saveUrl(String url);
}
