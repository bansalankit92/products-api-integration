package utils.vos;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class StorageSummary {

    private final String repository;
    private final long totalItems;
    private final long totalFolders;
    private final String totalSpaceUsed;

    public StorageSummary(String repository, long totalItems, long totalFolders, String totalSpaceUsed) {
        this.repository = repository;
        this.totalItems = totalItems;
        this.totalFolders = totalFolders;
        this.totalSpaceUsed = totalSpaceUsed;
    }

    public String getRepository() {
        return repository;
    }

    public long getTotalItems() {
        return totalItems;
    }

    public long getTotalFolders() {
        return totalFolders;
    }

    public String getTotalSpaceUsed() {
        return totalSpaceUsed;
    }

    public static StorageSummary create(JSONObject jsonObject) {
        try {
            String repository = (String) jsonObject.get("repoKey");
            long totalItems = (int) jsonObject.get("itemsCount");
            long totalFolders = (int) jsonObject.get("foldersCount");
            String totalSpaceUsed = (String) jsonObject.get("usedSpace");
            return new StorageSummary(repository, totalItems, totalFolders, totalSpaceUsed);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static com.integration.extensions.domains.devops.StorageSummary getStorageSummary(StorageSummary storageSummary) {
        com.integration.extensions.domains.devops.StorageSummary
                storageSummaryFinal = new com.integration.extensions.domains.devops.StorageSummary();
        storageSummaryFinal.repository = storageSummary.repository;
        storageSummaryFinal.totalFolders = storageSummary.totalFolders;
        storageSummaryFinal.totalItems = storageSummary.totalItems;
        storageSummaryFinal.totalSpaceUsed = storageSummary.totalSpaceUsed;
        return storageSummaryFinal;
    }
}
