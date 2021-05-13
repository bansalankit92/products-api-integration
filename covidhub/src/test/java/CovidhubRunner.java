import java.util.HashMap;
import java.util.Map;
import com.google.gson.Gson;
import com.integration.extensions.domains.covidhub.util.WorldoMeterUtil;
import com.integration.util.RestClient;

public class CovidhubRunner {

    public static final String DISEASE_HOST_URL = "Disease.sh Host URL";
    public static final String COVID_API_HUB_ICU_BED_HOST_URL = "Covid Hub ICU Beds Host URL";

    public static String diseaseHostUrl = "https://disease.sh/v3/covid-19";
    public static String covidHubICUBedApi = "https://covidapihub.io/apis/icu-beds-by-state";

    public static void main(String[] args) throws Exception {
        Map<String, Object> attr = new HashMap<>();
        RestClient restClientDisHub = new RestClient(diseaseHostUrl, "");
        RestClient restClientICU = new RestClient(covidHubICUBedApi, "");

          System.out.println(new Gson().toJson(WorldoMeterUtil.getAll(restClientDisHub,false,false)));
//        System.out.println(new Date().toString());
        //  System.out.println(new Gson().toJson(CovidHubApiUtil.getAllInPatientBedOccupied(restClientICU,"ar")));
 //
        //  System.out.println(DatePlus.getDateDiffFromToday(new Date(1601536537000l)));
        //System.out.println(new Gson().toJson(JHUUtil
        //        .getHistoricalByCountries(restClientDisHub, List.of("US"), new Date(1601796690000l), new Date())));

    }

}