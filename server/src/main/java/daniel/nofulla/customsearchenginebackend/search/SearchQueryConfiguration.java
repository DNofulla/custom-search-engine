package daniel.nofulla.customsearchenginebackend.search;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("rapidapi")
public class SearchQueryConfiguration {

    private String agent;
    private String host;
    private String location;
    private String key;

    private String textUrl;
    private String imagesUrl;
    private String newsUrl;

    public String getAgent() {
        return agent;
    }

    public String getHost() {
        return host;
    }

    public String getLocation() {
        return location;
    }

    public String getKey() {
        return key;
    }

    public String getTextUrl() {
        return textUrl;
    }

    public String getImagesUrl() {
        return imagesUrl;
    }

    public String getNewsUrl() {
        return newsUrl;
    }


    public void setAgent(String agent) {
        this.agent = agent;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setTextUrl(String textUrl) {
        this.textUrl = textUrl;
    }

    public void setImagesUrl(String imagesUrl) {
        this.imagesUrl = imagesUrl;
    }

    public void setNewsUrl(String newsUrl) {
        this.newsUrl = newsUrl;
    }

}
