package utils.methods;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;
import utils.vos.StorageSummary;

public class StorageUtility {

    public static List<StorageSummary> getStorages(RestClient client) {
        List<StorageSummary> storages = new ArrayList<>();
        String response = client.fetch("storageinfo", new HashMap<>(), String.class);
        try {
            JSONObject jsonObjectResponse = new JSONObject(response);
            JSONArray jsonArray = jsonObjectResponse.getJSONArray("repositoriesSummaryList");
            for(int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                StorageSummary storageSummary = utils.vos.StorageSummary.create(jsonObject);
                storages.add(storageSummary);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return storages;
    }

    public static StorageSummary getStorageForRepo(String repoKey, RestClient restClient) {
        for(StorageSummary storageSummary : StorageUtility.getStorages(restClient)) {
            if(storageSummary.getRepository().equals(repoKey)) {
                return storageSummary;
            }
        }
        return null;
    }
}
