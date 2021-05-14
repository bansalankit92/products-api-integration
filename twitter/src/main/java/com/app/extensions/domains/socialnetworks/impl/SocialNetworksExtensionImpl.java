package com.app.extensions.domains.socialnetworks.impl;

import java.util.List;
import java.util.Map;
import com.app.extensions.domains.socialnetworks.Post;
import com.app.extensions.domains.socialnetworks.SocialNetworksExtension;
import com.app.extensions.domains.socialnetworks.util.TwitterUtil;
import twitter4j.TwitterException;
import twitter4j.auth.RequestToken;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class SocialNetworksExtensionImpl implements SocialNetworksExtension {
    TwitterUtil twitterUtil;

    @Override
    public List searchPosts(String query) throws Exception {
        return twitterUtil.search(query);
    }

    @Override
    public Post fetchPostByPrimaryKey(String primaryKey) throws Exception {
        return null;
    }

    @Override
    public List fetchFieldsSupportingSearchForPost() {
        return null;
    }

    @Override
    public List genericSearchForEntitySelectorForPost(List searchParams, Double fetchSize, Double fetchPageNumber) throws Exception {
        return null;
    }

    @Override
    public String createPost(Post entityDefinition) throws Exception {
        return null;
    }

    @Override
    public String updatePost(Post entityDefinition, String primaryKey) throws Exception {
        return null;
    }

    @Override
    public List timeline() throws Exception {
        return twitterUtil.timeline(null, null);
    }

    /**
     * post with hashtags
     */
    @Override
    public String post(String postText) throws Exception {
        System.out.println("Tweeting"+postText);
        return twitterUtil.post(postText);
    }



}
