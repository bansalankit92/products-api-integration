package com.app.extensions.domains.socialnetworks;

import java.util.List;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */

public interface SocialNetworksExtension {

    /**
     * Search Posts
     */
    List searchPosts(String query) throws Exception;

    /**
     * Fetch Post By Primary Key
     */
    Post fetchPostByPrimaryKey(String primaryKey) throws Exception;

    /**
     * Fetch Fields Supporting Search For Post
     */
    List fetchFieldsSupportingSearchForPost();

    /**
     * For Generic Search for entity selector for Post. The List is a List<Pair<String, Pair<String, String>>>
     */
    List genericSearchForEntitySelectorForPost(List searchParams, Double fetchSize,
            Double fetchPageNumber) throws Exception;

    /**
     * Create Post
     */
    String createPost(Post entityDefinition) throws Exception;

    /**
     * Update Post
     */
    String updatePost(Post entityDefinition, String primaryKey) throws Exception;

    /**
     * My Timeline
     */
    List timeline() throws Exception;

    /**
     * post with hashtags
     */
    String post(String postText) throws Exception;

}
