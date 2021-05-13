package com.extensions.domains.development.util;

import com.extensions.domains.development.CodeRepository;
import com.extensions.domains.development.model.GRepo;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

public class RepositoryUtil {

    public static List<GRepo> getUserRepositories(OAuthUtil authUtil, String search)
            throws IOException, ExecutionException, InterruptedException {

        Map<String, String> body = new HashMap<>();
        body.put("owned", "true");
        body.put("order_by", "updated_at");
        body.put("sort", "desc");
        body.put("search", search);

        String path = "projects";
        return Arrays.asList(GitlabUtil.gson.fromJson(OAuthUtil.get(authUtil, path, body), GRepo[].class));
    }

    public static List<CodeRepository> searchRepoByFullName(OAuthUtil authUtil, String fullName) throws InterruptedException, ExecutionException, IOException {
        return getUserRepositories(authUtil, "").stream().filter(r -> r.fullName.toLowerCase().contains(fullName.trim().toLowerCase())).map(GRepo::to).collect(Collectors.toList());
    }

    public static List<CodeRepository> getRepo(OAuthUtil authUtil, String name) throws InterruptedException, ExecutionException, IOException {
        return getUserRepositories(authUtil, name).stream().map(GRepo::to).collect(Collectors.toList());
    }

    public static CodeRepository getRepoByFullName(OAuthUtil authUtil, String fullname) throws InterruptedException, ExecutionException, IOException {
        Map<String, String> request = new HashMap<>();
        String path = "projects/" + URLEncoder.encode(fullname, StandardCharsets.UTF_8);
        return GitlabUtil.gson.fromJson(OAuthUtil.get(authUtil, path, request), GRepo.class).to();
    }

    public static GRepo createRepository(OAuthUtil authUtil, CodeRepository repository)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("name", repository.name);
        body.put("description", repository.description);
        body.put("remove_source_branch_after_merge", true);
        String path = "projects";
        return GitlabUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GRepo.class);
    }

    public static GRepo updateRepository(OAuthUtil authUtil, CodeRepository repository)
            throws IOException, ExecutionException, InterruptedException {
        Map<String, Object> body = new HashMap<>();
        body.put("name", repository.name);
        body.put("description", repository.description);
        String path = "projects/" + URLEncoder.encode(repository.fullName, StandardCharsets.UTF_8);
        return GitlabUtil.gson.fromJson(OAuthUtil.post(authUtil, path, body), GRepo.class);
    }
}