package com.app.extensions.domains.socialnetworks.util;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import com.app.extensions.domains.socialnetworks.Post;
import twitter4j.*;
import twitter4j.conf.ConfigurationBuilder;

public class TwitterUtil {

    public static final String CONSUMER_KEY = "Consumer Key";
    public static final String CONSUMER_SECRET = "Consumer Secret";
    public static final String OAUTH_ACCESS_TOKEN = "Oauth Access Token";
    public static final String OAUTH_ACCESS_TOKEN_SECRET = "Oauth Access Token Secret";
    Twitter twitter;
    Map<String, Object> extensionAttributes;

    public TwitterUtil(Map<String, Object> attr) {
        extensionAttributes = attr;
        ConfigurationBuilder twitterConfigBuilder = new ConfigurationBuilder();
        // twitterConfigBuilder.setDebugEnabled(true);

        twitterConfigBuilder.setOAuthConsumerKey(getValue(CONSUMER_KEY));
        twitterConfigBuilder.setOAuthConsumerSecret(getValue(CONSUMER_SECRET));
        twitterConfigBuilder.setOAuthAccessToken(getValue(OAUTH_ACCESS_TOKEN));
        twitterConfigBuilder.setOAuthAccessTokenSecret(getValue(OAUTH_ACCESS_TOKEN_SECRET));
        twitter = new TwitterFactory(twitterConfigBuilder.build()).getInstance();
        //return twitter;
    }

    public String getValue(String key) {
        Object value = (extensionAttributes.get(key));
        if (value == null) throw new RuntimeException("Please provide correct " + key);
        return String.valueOf(value);
    }

    public String post(String post) throws TwitterException {
        StatusUpdate status = new StatusUpdate(post);
        //   status.setMedia(img.getName(), in);
        Status status1 = twitter.updateStatus(status);
        return String.valueOf(status1.getId());
    }


    public List<Post> search(String query) throws TwitterException {
        Query q = new Query(query);

        QueryResult result = twitter.search(q);
        return result.getTweets().stream().map(TwitterUtil::from).collect(Collectors.toList());

    }

    public List<Post> timeline( Long pageSize, Long pageNumber) throws TwitterException {
        int size = Math.toIntExact(pageSize != null ? pageSize : 30);
        int page = Math.toIntExact(pageNumber != null ? pageNumber : 1);
        Paging paging = new Paging(page, size);

        List<Status> statuses = twitter.getHomeTimeline(paging);
        return statuses.stream().map(TwitterUtil::from).collect(Collectors.toList());
    }


    public Twitter getTwitter() {
        return twitter;
    }

    public static Post from(Status status) {
        Post post = new Post();
        post.likeCount = Double.valueOf(status.getFavoriteCount());
        post.post = status.getText();
        post.postId = String.valueOf(status.getId());
        post.userName = status.getUser().getScreenName();

        return post;
    }
}