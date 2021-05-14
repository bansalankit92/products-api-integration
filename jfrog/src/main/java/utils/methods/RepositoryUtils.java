package utils.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.integration.extensions.domains.devops.ArtifactRepository;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import utils.vos.Package;
import utils.vos.Repository;

public class RepositoryUtils {

    public static List<utils.vos.Repository> getRepositories(RestClient client) {
        List<utils.vos.Repository> repositories = new ArrayList<>();
        String response = client.fetch("repositories", new HashMap<>(), String.class);
        try {
            JSONArray jsonArray = new JSONArray(response);
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                utils.vos.Repository repository = utils.vos.Repository.create(jsonObject);
                repositories.add(repository);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return repositories;
    }

    public static List<ArtifactRepository> getArtifactoryRepositories(RestClient client) {
        List<ArtifactRepository> artifactoryList = new ArrayList<>();
        for(Repository repository : getRepositories(client)) {
            artifactoryList.add(repository.getRepository());
        }
        return artifactoryList;
    }

    public static List<Repository> getRepositoriesForPackageType(Package packageType, RestClient restClient) {
        List<Repository> repositories = new ArrayList<>();
        for(Repository repository : getRepositories(restClient)) {
            if(repository.getPackageType().toLowerCase().equals(packageType.getPackageType().toLowerCase())) {
                repositories.add(repository);
            }
        }
        return repositories;
    }
}
