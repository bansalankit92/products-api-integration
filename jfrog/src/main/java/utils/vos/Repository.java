package utils.vos;

import com.integration.extensions.domains.devops.ArtifactRepository;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class Repository {

    private final String repositoryKey;
    private final String repositoryType;
    private final String repositoryUrl;
    private final String packageType;

    public Repository(String repositoryKey, String repositoryType, String repositoryUrl, String packageType) {
        this.repositoryKey = repositoryKey;
        this.repositoryType = repositoryType;
        this.repositoryUrl = repositoryUrl;
        this.packageType = packageType;
    }

    public String getRepositoryKey() {
        return repositoryKey;
    }

    public String getRepositoryType() {
        return repositoryType;
    }

    public String getRepositoryUrl() {
        return repositoryUrl;
    }

    public String getPackageType() {
        return packageType;
    }

    public static Repository create(JSONObject jsonObject) {
        try {
            String key = (String) jsonObject.get("key");
            String repoType = (String) jsonObject.get("type");
            String url = (String) jsonObject.get("url");
            String pkgType = (String) jsonObject.get("packageType");
            return new Repository(key, repoType, url, pkgType);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ArtifactRepository getRepository() {
        ArtifactRepository repositoryRet = new ArtifactRepository();
        repositoryRet.packageType = packageType;
        repositoryRet.key = repositoryKey;
        repositoryRet.repositoryType = repositoryType;
        repositoryRet.url = repositoryUrl;
        return repositoryRet;
    }

}
