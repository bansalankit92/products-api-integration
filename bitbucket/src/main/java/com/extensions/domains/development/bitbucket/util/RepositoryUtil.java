package com.extensions.domains.development.bitbucket.util;

import com.extensions.domains.development.CodeRepository;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RepositoryUtil {

    public static final String REPOSITORIES = "repositories";

    public static List<CodeRepository> getAll(RestClient client) throws JSONException {
        JSONObject responseJson = client.get(REPOSITORIES, Collections.singletonMap("role", "contributor"));
        List<CodeRepository> repositories = new ArrayList<>();
        JSONArray values = responseJson.optJSONArray("values");

        if (values != null) {
            for (int index = 0; index < values.length(); index++) {
                repositories.add(parseRepository(values.getJSONObject(index)));
            }
        }
        return repositories;
    }


    public static String getAllRepo(RestClient client) throws JSONException {
           JSONObject responseJson = client.get(REPOSITORIES, Collections.singletonMap("role", "contributor"));
           return responseJson.toString();
       }

    public static String prepareUrl(String repositoryFullName) {
        return REPOSITORIES + "/" + repositoryFullName;
    }

    private static CodeRepository parseRepository(JSONObject json) throws JSONException {
        CodeRepository repository = new CodeRepository();
        repository.fullName = json.getString("full_name");
        repository.name = json.getString("name");
        repository.description = json.getString("description");
        repository.language = json.getString("language");
        repository.owner = json.getJSONObject("owner").getString("display_name");
        repository.projectName = json.getJSONObject("project").getString("name");

        return repository;
    }
}
