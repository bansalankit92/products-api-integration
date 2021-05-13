package com.integration.extensions.domains.covidhub.model;

import com.google.gson.Gson;
import com.integration.extensions.domains.covidhub.County;

public class RawCounty {

    public String country, county, province;
    public static RawCounty[] counties;

    public County to() {
        County c = new County();
        c.province = province;
        c.name = county;
        c.country = country;
        return c;
    }
    public static StringBuilder countyJsonSb = new StringBuilder();

    public static String countyJson;
    static {
    countyJsonSb.append("[" +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Autauga\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baldwin\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barbour\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bibb\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blount\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bullock\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chambers\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chilton\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Choctaw\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarke\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cleburne\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coffee\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colbert\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Conecuh\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coosa\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Covington\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crenshaw\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cullman\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dale\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dallas\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeKalb\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elmore\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Escambia\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Etowah\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Geneva\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hale\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Houston\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lamar\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lauderdale\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Limestone\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lowndes\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macon\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marengo\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mobile\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of AL\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pickens\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Russell\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Clair\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sumter\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Talladega\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tallapoosa\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tuscaloosa\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walker\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilcox\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winston\"," +
            "    \"province\": \"Alabama\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aleutians East\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aleutians West\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anchorage\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bethel\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bristol Bay\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Denali\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dillingham\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fairbanks North Star\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haines\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Juneau\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kenai Peninsula\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ketchikan Gateway\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kodiak Island\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kusilvak\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Matanuska-Susitna\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nome\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"North Slope\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Northwest Arctic\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Petersburg\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prince of Wales-Hyder\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sitka\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Southeast Fairbanks\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Valdez-Cordova\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wrangell\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yakutat\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yukon-Koyukuk\"," +
            "    \"province\": \"Alaska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Apache\"," +
            "    \"province\": \"Arizona\"" +
            "  }," );
            countyJsonSb.append(       "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cochise\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coconino\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gila\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Graham\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greenlee\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"La Paz\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maricopa\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mohave\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Navajo\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pima\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pinal\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Cruz\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yavapai\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yuma\"," +
            "    \"province\": \"Arizona\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arkansas\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ashley\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baxter\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bradley\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chicot\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cleburne\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cleveland\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Conway\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Craighead\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crittenden\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cross\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dallas\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Desha\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Drew\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Faulkner\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garland\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hempstead\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hot Spring\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Independence\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Izard\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafayette\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Little River\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lonoke\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miller\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mississippi\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nevada\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newton\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ouachita\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Phillips\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Poinsett\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pope\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prairie\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saline\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Searcy\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sebastian\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sevier\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sharp\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Francis\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stone\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Van Buren\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"White\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woodruff\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yell\"," +
            "    \"province\": \"Arkansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alameda\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alpine\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Amador\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butte\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calaveras\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colusa\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Contra Costa\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Del Norte\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"El Dorado\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fresno\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Glenn\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Humboldt\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Imperial\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Inyo\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kern\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kings\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lassen\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Los Angeles\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madera\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marin\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mariposa\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mendocino\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Merced\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Modoc\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mono\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monterey\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Napa\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nevada\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Placer\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Plumas\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Riverside\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sacramento\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Benito\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Bernardino\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Diego\"," +
            "    \"province\": \"California\"" +
            "  },");
        countyJsonSb.append(      "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Francisco\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Joaquin\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Luis Obispo\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Mateo\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Barbara\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Clara\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Cruz\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shasta\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sierra\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Siskiyou\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Solano\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sonoma\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stanislaus\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sutter\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tehama\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trinity\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tulare\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tuolumne\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ventura\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yolo\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yuba\"," +
            "    \"province\": \"California\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alamosa\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arapahoe\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Archuleta\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baca\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bent\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boulder\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Broomfield\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chaffee\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cheyenne\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clear Creek\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Conejos\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Costilla\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crowley\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Custer\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delta\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Denver\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dolores\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eagle\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"El Paso\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elbert\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fremont\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garfield\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gilpin\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grand\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gunnison\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hinsdale\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Huerfano\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kiowa\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kit Carson\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"La Plata\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Larimer\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Las Animas\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mesa\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mineral\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moffat\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montezuma\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montrose\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Otero\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ouray\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of CO\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Park\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Phillips\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pitkin\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prowers\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pueblo\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rio Blanco\"," +
            "    \"province\": \"Colorado\"" +
            "  },"
        );
                countyJsonSb.append(   "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rio Grande\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Routt\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saguache\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Juan\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Miguel\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sedgwick\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Summit\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Teller\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Weld\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yuma\"," +
            "    \"province\": \"Colorado\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fairfield\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hartford\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Litchfield\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Middlesex\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New Haven\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New London\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tolland\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Windham\"," +
            "    \"province\": \"Connecticut\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kent\"," +
            "    \"province\": \"Delaware\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New Castle\"," +
            "    \"province\": \"Delaware\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sussex\"," +
            "    \"province\": \"Delaware\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Delaware\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"District of Columbia\"," +
            "    \"province\": \"District of Columbia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alachua\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baker\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bay\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bradford\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brevard\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Broward\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charlotte\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Citrus\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Collier\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeSoto\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dixie\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Duval\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Escambia\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Flagler\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gadsden\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gilchrist\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Glades\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gulf\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardee\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hendry\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hernando\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Highlands\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hillsborough\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Holmes\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Indian River\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafayette\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leon\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Levy\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Liberty\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Manatee\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martin\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miami-Dade\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nassau\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Okaloosa\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Okeechobee\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osceola\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Palm Beach\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pasco\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pinellas\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Rosa\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sarasota\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seminole\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Johns\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Lucie\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sumter\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Suwannee\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Volusia\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wakulla\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walton\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Florida\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Appling\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Atkinson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bacon\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baker\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baldwin\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Banks\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barrow\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bartow\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ben Hill\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Berrien\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bibb\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bleckley\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brantley\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brooks\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bryan\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bulloch\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burke\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butts\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camden\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Candler\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Catoosa\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charlton\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chatham\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chattahoochee\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chattooga\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarke\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clayton\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinch\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cobb\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coffee\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colquitt\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cook\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coweta\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crisp\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dade\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dawson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeKalb\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Decatur\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dodge\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dooly\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dougherty\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Early\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Echols\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Effingham\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elbert\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Emanuel\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Evans\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fannin\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Floyd\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Forsyth\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gilmer\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Glascock\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Glynn\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gordon\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grady\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gwinnett\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Habersham\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hall\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haralson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harris\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hart\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Heard\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Houston\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Irwin\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jeff Davis\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jenkins\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jones\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lamar\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lanier\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Laurens\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Liberty\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Long\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lowndes\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lumpkin\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macon\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McDuffie\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McIntosh\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meriwether\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miller\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mitchell\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Murray\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Muscogee\"," +
            "    \"province\": \"Georgia\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newton\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oconee\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oglethorpe\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of GA\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Paulding\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Peach\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pickens\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pierce\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Quitman\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rabun\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richmond\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockdale\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schley\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Screven\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seminole\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spalding\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stephens\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stewart\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sumter\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Talbot\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taliaferro\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tattnall\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Telfair\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Terrell\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Thomas\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tift\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Toombs\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Towns\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Treutlen\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Troup\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Turner\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Twiggs\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Upson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walker\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walton\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ware\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wheeler\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"White\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Whitfield\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilcox\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilkes\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilkinson\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Worth\"," +
            "    \"province\": \"Georgia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hawaii\"," +
            "    \"province\": \"Hawaii\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Honolulu\"," +
            "    \"province\": \"Hawaii\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kauai\"," +
            "    \"province\": \"Hawaii\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maui\"," +
            "    \"province\": \"Hawaii\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of HI\"," +
            "    \"province\": \"Hawaii\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Hawaii\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ada\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bannock\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bear Lake\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benewah\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bingham\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blaine\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boise\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bonner\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bonneville\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boundary\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butte\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camas\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Canyon\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caribou\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cassia\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clearwater\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Custer\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elmore\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fremont\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gem\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gooding\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Idaho\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jerome\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kootenai\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Latah\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lemhi\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Minidoka\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nez Perce\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oneida\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Owyhee\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Payette\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Power\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shoshone\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Teton\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Twin Falls\"," +
            "    \"province\": \"Idaho\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Valley\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Idaho\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alexander\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bond\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bureau\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Champaign\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Christian\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coles\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cook\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"De Witt\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeKalb\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DuPage\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edgar\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edwards\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Effingham\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ford\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gallatin\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grundy\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardin\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henderson\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iroquois\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jersey\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jo Daviess\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kane\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kankakee\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kendall\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"LaSalle\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Livingston\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macon\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macoupin\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mason\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Massac\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McDonough\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McHenry\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McLean\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Menard\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moultrie\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ogle\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of IL\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Peoria\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Piatt\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pope\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rock Island\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saline\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sangamon\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schuyler\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Clair\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stark\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stephenson\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tazewell\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vermilion\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wabash\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"White\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Whiteside\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Will\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williamson\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winnebago\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woodford\"," +
            "    \"province\": \"Illinois\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allen\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bartholomew\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blackford\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Daviess\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeKalb\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dearborn\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Decatur\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delaware\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dubois\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elkhart\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Floyd\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fountain\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gibson\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hendricks\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Huntington\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jay\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jennings\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kosciusko\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"LaGrange\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"LaPorte\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martin\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miami\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newton\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Noble\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ohio\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Owen\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Parke\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Porter\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Posey\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ripley\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rush\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spencer\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Joseph\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Starke\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Steuben\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sullivan\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Switzerland\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tippecanoe\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tipton\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vanderburgh\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vermillion\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vigo\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wabash\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warrick\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wells\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"White\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Whitley\"," +
            "    \"province\": \"Indiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adair\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allamakee\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Appanoose\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Audubon\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Black Hawk\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bremer\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buchanan\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buena Vista\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Iowa\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cedar\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cerro Gordo\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chickasaw\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarke\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clayton\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dallas\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Davis\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Decatur\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delaware\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Des Moines\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickinson\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dubuque\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Emmet\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Floyd\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fremont\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grundy\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guthrie\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardin\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Humboldt\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ida\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iowa\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jones\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Keokuk\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kossuth\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Linn\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Louisa\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lucas\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lyon\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mahaska\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mills\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mitchell\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monona\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Muscatine\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"O'Brien\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osceola\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Page\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Palo Alto\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Plymouth\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pocahontas\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pottawattamie\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Poweshiek\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ringgold\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sac\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sioux\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Story\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tama\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Van Buren\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wapello\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winnebago\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winneshiek\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woodbury\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Worth\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wright\"," +
            "    \"province\": \"Iowa\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allen\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anderson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Atchison\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barber\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barton\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bourbon\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chase\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chautauqua\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cheyenne\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cloud\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coffey\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Comanche\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cowley\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Decatur\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickinson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Doniphan\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edwards\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elk\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ellis\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ellsworth\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Finney\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ford\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Geary\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gove\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Graham\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gray\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greeley\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greenwood\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harper\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harvey\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haskell\"," +
            "    \"province\": \"Kansas\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hodgeman\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jewell\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kearny\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kingman\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kiowa\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Labette\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lane\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leavenworth\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Linn\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lyon\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McPherson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meade\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miami\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mitchell\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morris\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morton\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nemaha\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Neosho\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ness\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Norton\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osage\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osborne\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ottawa\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pawnee\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Phillips\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pottawatomie\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pratt\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rawlins\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Reno\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Republic\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rice\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Riley\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rooks\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rush\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Russell\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saline\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sedgwick\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seward\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shawnee\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sheridan\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sherman\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Smith\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stafford\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stanton\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stevens\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sumner\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Thomas\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trego\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wabaunsee\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wallace\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wichita\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woodson\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wyandotte\"," +
            "    \"province\": \"Kansas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adair\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allen\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anderson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ballard\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barren\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bath\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bell\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bourbon\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boyd\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boyle\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bracken\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Breathitt\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Breckinridge\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bullitt\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caldwell\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calloway\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Campbell\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carlisle\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carter\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Casey\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Christian\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crittenden\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Daviess\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edmonson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elliott\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Estill\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fleming\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Floyd\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gallatin\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garrard\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Graves\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grayson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Green\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greenup\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardin\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harlan\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hart\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henderson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hickman\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hopkins\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jessamine\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kenton\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knott\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Larue\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Laurel\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leslie\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Letcher\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Livingston\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lyon\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Magoffin\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martin\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mason\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCracken\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCreary\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McLean\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meade\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Menifee\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Metcalfe\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Muhlenberg\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nelson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nicholas\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ohio\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oldham\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Owen\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Owsley\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pendleton\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Powell\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Robertson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockcastle\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rowan\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Russell\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Simpson\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spencer\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Todd\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trigg\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trimble\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Whitley\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wolfe\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woodford\"," +
            "    \"province\": \"Kentucky\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Acadia\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allen\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ascension\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Assumption\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Avoyelles\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beauregard\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bienville\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bossier\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caddo\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calcasieu\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caldwell\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cameron\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Catahoula\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Claiborne\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Concordia\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"De Soto\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"East Baton Rouge\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"East Carroll\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"East Feliciana\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Evangeline\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iberia\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iberville\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson Davis\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"LaSalle\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafayette\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafourche\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Livingston\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morehouse\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Natchitoches\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orleans\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ouachita\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of LA\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Plaquemines\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pointe Coupee\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rapides\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Red River\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sabine\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Bernard\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Charles\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Helena\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. James\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. John the Baptist\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Landry\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Martin\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Mary\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Tammany\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tangipahoa\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tensas\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Terrebonne\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vermilion\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vernon\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"West Baton Rouge\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"West Carroll\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"West Feliciana\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winn\"," +
            "    \"province\": \"Louisiana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Androscoggin\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aroostook\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kennebec\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of ME\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oxford\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Penobscot\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Piscataquis\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sagadahoc\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Somerset\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Maine\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waldo\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"York\"," +
            "    \"province\": \"Maine\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allegany\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anne Arundel\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baltimore\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baltimore City\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calvert\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caroline\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cecil\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charles\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dorchester\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Frederick\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garrett\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harford\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kent\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prince George's\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Queen Anne's\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Somerset\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Mary's\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Talbot\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wicomico\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Worcester\"," +
            "    \"province\": \"Maryland\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barnstable\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Berkshire\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bristol\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dukes and Nantucket\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Essex\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hampden\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hampshire\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Middlesex\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Norfolk\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Plymouth\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Suffolk\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Worcester\"," +
            "    \"province\": \"Massachusetts\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alcona\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alger\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allegan\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alpena\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Antrim\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arenac\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baraga\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barry\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bay\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benzie\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Berrien\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Branch\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charlevoix\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cheboygan\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chippewa\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clare\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delta\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickinson\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eaton\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Emmet\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Federal Correctional Institution (FCI)\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Genesee\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gladwin\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gogebic\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grand Traverse\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gratiot\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hillsdale\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Houghton\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Huron\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ingham\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ionia\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iosco\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iron\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Isabella\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kalamazoo\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kalkaska\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kent\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Keweenaw\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lapeer\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leelanau\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lenawee\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Livingston\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Luce\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mackinac\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macomb\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Manistee\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marquette\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mason\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mecosta\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Menominee\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Michigan Department of Corrections (MDOC)\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Midland\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Missaukee\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montcalm\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montmorency\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Muskegon\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newaygo\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oakland\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oceana\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ogemaw\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ontonagon\"," +
            "    \"province\": \"Michigan\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osceola\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oscoda\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Otsego\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ottawa\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of MI\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Presque Isle\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roscommon\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saginaw\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sanilac\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schoolcraft\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shiawassee\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Clair\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Joseph\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tuscola\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Van Buren\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washtenaw\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wexford\"," +
            "    \"province\": \"Michigan\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aitkin\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anoka\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Becker\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beltrami\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Big Stone\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blue Earth\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carlton\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carver\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chippewa\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chisago\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clearwater\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cook\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cottonwood\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crow Wing\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dakota\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dodge\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Faribault\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fillmore\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Freeborn\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Goodhue\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hennepin\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Houston\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hubbard\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Isanti\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Itasca\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kanabec\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kandiyohi\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kittson\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Koochiching\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lac qui Parle\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake of the Woods\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Le Sueur\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lyon\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mahnomen\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martin\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McLeod\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meeker\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mille Lacs\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morrison\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mower\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Murray\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nicollet\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nobles\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Norman\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Olmsted\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Otter Tail\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pennington\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pine\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pipestone\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pope\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ramsey\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Red Lake\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Redwood\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Renville\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rice\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rock\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roseau\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sherburne\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sibley\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Louis\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stearns\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Steele\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stevens\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Swift\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Todd\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Traverse\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wabasha\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wadena\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waseca\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Watonwan\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilkin\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winona\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wright\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yellow Medicine\"," +
            "    \"province\": \"Minnesota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alcorn\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Amite\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Attala\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bolivar\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chickasaw\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Choctaw\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Claiborne\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarke\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coahoma\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Copiah\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Covington\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeSoto\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Forrest\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"George\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grenada\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hinds\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Holmes\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Humphreys\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Issaquena\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Itawamba\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson Davis\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jones\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kemper\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafayette\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lamar\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lauderdale\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leake\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leflore\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lowndes\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Neshoba\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newton\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Noxubee\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oktibbeha\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Panola\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pearl River\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pontotoc\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prentiss\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Quitman\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rankin\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sharkey\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Simpson\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Smith\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stone\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sunflower\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tallahatchie\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tate\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tippah\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tishomingo\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tunica\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walthall\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilkinson\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winston\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yalobusha\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yazoo\"," +
            "    \"province\": \"Mississippi\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adair\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Andrew\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Atchison\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Audrain\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barry\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barton\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bates\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bollinger\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buchanan\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caldwell\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Callaway\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camden\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cape Girardeau\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carter\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cedar\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chariton\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Christian\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cole\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cooper\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dade\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dallas\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Daviess\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeKalb\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dent\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dunklin\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gasconade\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gentry\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grundy\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hickory\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Holt\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howell\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iron\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kansas City\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Laclede\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafayette\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Linn\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Livingston\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macon\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maries\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McDonald\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miller\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mississippi\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moniteau\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New Madrid\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newton\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nodaway\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oregon\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osage\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ozark\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pemiscot\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pettis\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Phelps\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Platte\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ralls\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ray\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Reynolds\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ripley\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saline\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schuyler\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scotland\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shannon\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Charles\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Clair\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Francois\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Louis\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Louis City\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ste. Genevieve\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stoddard\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stone\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sullivan\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taney\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Texas\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vernon\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Worth\"," +
            "    \"province\": \"Missouri\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wright\"," +
            "    \"province\": \"Missouri\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beaverhead\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Big Horn\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blaine\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Broadwater\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carbon\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carter\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cascade\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chouteau\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Custer\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Daniels\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dawson\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Deer Lodge\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fallon\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fergus\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Flathead\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gallatin\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garfield\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Glacier\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Golden Valley\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Granite\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hill\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Judith Basin\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis and Clark\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Liberty\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCone\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meagher\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mineral\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Missoula\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Musselshell\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Park\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Petroleum\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Phillips\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pondera\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Powder River\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Powell\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prairie\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ravalli\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roosevelt\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rosebud\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sanders\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sheridan\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Silver Bow\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stillwater\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sweet Grass\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Teton\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Toole\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Treasure\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Valley\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wheatland\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wibaux\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yellowstone\"," +
            "    \"province\": \"Montana\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Antelope\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arthur\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Banner\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blaine\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Box Butte\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boyd\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buffalo\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burt\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cedar\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chase\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherry\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cheyenne\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colfax\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cuming\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Custer\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dakota\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dawes\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dawson\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Deuel\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dixon\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dodge\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dundy\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fillmore\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Frontier\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Furnas\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gage\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garden\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garfield\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gosper\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greeley\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hall\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harlan\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hayes\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hitchcock\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Holt\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hooker\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kearney\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Keith\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Keya Paha\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kimball\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lancaster\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Loup\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McPherson\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Merrick\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morrill\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nance\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nemaha\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nuckolls\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Otoe\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pawnee\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perkins\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Phelps\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pierce\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Platte\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Red Willow\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richardson\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rock\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saline\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sarpy\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saunders\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scotts Bluff\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seward\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sheridan\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sherman\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sioux\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stanton\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Thayer\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Thomas\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Thurston\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Valley\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wheeler\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"York\"," +
            "    \"province\": \"Nebraska\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carson City\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Churchill\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elko\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Esmeralda\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eureka\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Humboldt\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lander\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lyon\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mineral\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nye\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pershing\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Storey\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washoe\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"White Pine\"," +
            "    \"province\": \"Nevada\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Belknap\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cheshire\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coos\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grafton\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hillsborough\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Merrimack\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockingham\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Strafford\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sullivan\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"New Hampshire\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Atlantic\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bergen\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burlington\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camden\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cape May\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Essex\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gloucester\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hudson\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hunterdon\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Middlesex\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monmouth\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morris\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ocean\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Passaic\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Salem\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Somerset\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sussex\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"New Jersey\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bernalillo\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Catron\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chaves\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cibola\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colfax\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Curry\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"De Baca\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dona Ana\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eddy\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guadalupe\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harding\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hidalgo\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lea\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Los Alamos\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Luna\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McKinley\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mora\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Otero\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Quay\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rio Arriba\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roosevelt\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Juan\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Miguel\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sandoval\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Fe\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sierra\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Socorro\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taos\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Torrance\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Valencia\"," +
            "    \"province\": \"New Mexico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Albany\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allegany\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bronx\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Broome\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cattaraugus\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cayuga\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chautauqua\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chemung\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chenango\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cortland\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delaware\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dutchess\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Erie\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Essex\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Genesee\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Herkimer\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kings\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Livingston\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nassau\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New York\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Niagara\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oneida\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Onondaga\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ontario\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orleans\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oswego\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Otsego\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Queens\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rensselaer\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richmond\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockland\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saratoga\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schenectady\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schoharie\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schuyler\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seneca\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Lawrence\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Steuben\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Suffolk\"," +
            "    \"province\": \"New York\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sullivan\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tioga\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tompkins\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ulster\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Westchester\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wyoming\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yates\"," +
            "    \"province\": \"New York\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alamance\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alexander\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alleghany\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ashe\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Avery\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beaufort\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bertie\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bladen\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brunswick\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buncombe\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burke\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cabarrus\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caldwell\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camden\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carteret\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caswell\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Catawba\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chatham\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chowan\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cleveland\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbus\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Craven\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Currituck\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dare\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Davidson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Davie\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Duplin\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Durham\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edgecombe\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Forsyth\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gaston\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gates\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Graham\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Granville\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guilford\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Halifax\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harnett\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haywood\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henderson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hertford\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hoke\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hyde\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iredell\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnston\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jones\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lenoir\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macon\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," );
        countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martin\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McDowell\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mecklenburg\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mitchell\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moore\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nash\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New Hanover\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Northampton\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Onslow\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pamlico\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pasquotank\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pender\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perquimans\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Person\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pitt\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richmond\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Robeson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockingham\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rowan\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rutherford\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sampson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scotland\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stanly\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stokes\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Surry\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Swain\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Transylvania\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tyrrell\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vance\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wake\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Watauga\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilkes\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilson\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yadkin\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yancey\"," +
            "    \"province\": \"North Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barnes\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benson\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Billings\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bottineau\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bowman\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burke\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burleigh\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cavalier\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickey\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Divide\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dunn\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eddy\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Emmons\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Foster\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Golden Valley\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grand Forks\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Griggs\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hettinger\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kidder\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"LaMoure\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McHenry\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McIntosh\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McKenzie\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McLean\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morton\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mountrail\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nelson\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oliver\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pembina\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pierce\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ramsey\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ransom\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Renville\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rolette\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sargent\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sheridan\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sioux\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Slope\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stark\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Steele\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stutsman\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Towner\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Traill\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walsh\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ward\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wells\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williams\"," +
            "    \"province\": \"North Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allen\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ashland\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ashtabula\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Athens\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Auglaize\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Belmont\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Champaign\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clermont\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbiana\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coshocton\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cuyahoga\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Darke\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Defiance\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delaware\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Erie\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fairfield\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gallia\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Geauga\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guernsey\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardin\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Highland\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hocking\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Holmes\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Huron\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Licking\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lorain\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lucas\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mahoning\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Medina\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meigs\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miami\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morrow\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Muskingum\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Noble\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ottawa\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Paulding\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Ohio\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pickaway\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Portage\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Preble\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ross\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sandusky\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scioto\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seneca\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stark\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Summit\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trumbull\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tuscarawas\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Van Wert\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vinton\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williams\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wood\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wyandot\"," +
            "    \"province\": \"Ohio\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adair\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alfalfa\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Atoka\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beaver\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beckham\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blaine\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bryan\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caddo\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Canadian\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carter\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Choctaw\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cimarron\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cleveland\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coal\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Comanche\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cotton\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Craig\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Creek\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Custer\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delaware\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dewey\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ellis\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garfield\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garvin\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grady\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greer\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harmon\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harper\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haskell\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hughes\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnston\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kay\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kingfisher\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kiowa\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Latimer\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Le Flore\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Love\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Major\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mayes\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McClain\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCurtain\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McIntosh\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Murray\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Muskogee\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Noble\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nowata\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Okfuskee\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oklahoma\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Okmulgee\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Osage\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ottawa\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of OK\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pawnee\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Payne\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pittsburg\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pontotoc\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pottawatomie\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pushmataha\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roger Mills\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rogers\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Seminole\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sequoyah\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stephens\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Texas\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tillman\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tulsa\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wagoner\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washita\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woods\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Woodward\"," +
            "    \"province\": \"Oklahoma\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baker\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clackamas\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clatsop\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coos\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crook\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Curry\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Deschutes\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gilliam\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harney\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hood River\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Josephine\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Klamath\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lane\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Linn\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Malheur\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morrow\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Multnomah\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sherman\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tillamook\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Umatilla\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wallowa\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wasco\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wheeler\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yamhill\"," +
            "    \"province\": \"Oregon\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allegheny\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Armstrong\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beaver\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bedford\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Berks\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blair\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bradford\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bucks\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butler\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cambria\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cameron\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carbon\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Centre\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chester\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarion\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clearfield\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clinton\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dauphin\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delaware\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Elk\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Erie\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Forest\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fulton\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Huntingdon\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Indiana\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Juniata\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lackawanna\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lancaster\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lebanon\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lehigh\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Luzerne\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lycoming\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McKean\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mifflin\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montour\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Northampton\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Northumberland\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Philadelphia\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pike\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Potter\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schuylkill\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Snyder\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Somerset\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sullivan\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Susquehanna\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tioga\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Venango\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Westmoreland\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wyoming\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"York\"," +
            "    \"province\": \"Pennsylvania\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adjuntas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aguada\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aguadilla\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aguas Buenas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aibonito\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anasco\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arecibo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arroyo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barceloneta\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barranquitas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bayamon\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cabo Rojo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caguas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camuy\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Canovanas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carolina\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Catano\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cayey\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ceiba\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ciales\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cidra\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coamo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Comerio\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Corozal\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Culebra\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dorado\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fajardo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Florida\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guanica\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guayama\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guayanilla\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guaynabo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gurabo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hatillo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hormigueros\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Humacao\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Isabela\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jayuya\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Juana Diaz\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Juncos\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lajas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lares\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Las Marias\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Las Piedras\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Loiza\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Luquillo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Manati\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maricao\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maunabo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mayaguez\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moca\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morovis\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Naguabo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Naranjito\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orocovis\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of PR\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Patillas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Penuelas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ponce\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Quebradillas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rincon\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rio Grande\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sabana Grande\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Salinas\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San German\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Juan\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Lorenzo\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Sebastian\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Santa Isabel\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Toa Alta\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Toa Baja\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trujillo Alto\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Utuado\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vega Alta\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vega Baja\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vieques\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Villalba\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yabucoa\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yauco\"," +
            "    \"province\": \"Puerto Rico\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bristol\"," +
            "    \"province\": \"Rhode Island\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kent\"," +
            "    \"province\": \"Rhode Island\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newport\"," +
            "    \"province\": \"Rhode Island\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Providence\"," +
            "    \"province\": \"Rhode Island\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Rhode Island\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Rhode Island\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Abbeville\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aiken\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Allendale\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anderson\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bamberg\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barnwell\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beaufort\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Berkeley\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charleston\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chester\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chesterfield\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarendon\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colleton\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Darlington\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dillon\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dorchester\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edgefield\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fairfield\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Florence\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Georgetown\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greenville\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greenwood\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hampton\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Horry\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kershaw\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lancaster\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Laurens\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lexington\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marlboro\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCormick\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newberry\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oconee\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orangeburg\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pickens\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Saluda\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spartanburg\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sumter\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williamsburg\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"York\"," +
            "    \"province\": \"South Carolina\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aurora\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Beadle\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bennett\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bon Homme\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brookings\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brule\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buffalo\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Butte\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Campbell\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charles Mix\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Codington\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Corson\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Custer\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Davison\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Day\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Deuel\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dewey\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edmunds\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fall River\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Faulk\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gregory\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haakon\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamlin\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hand\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hanson\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harding\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hughes\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hutchinson\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hyde\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jerauld\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jones\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kingsbury\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lyman\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCook\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McPherson\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meade\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mellette\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Miner\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Minnehaha\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moody\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oglala Lakota\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pennington\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perkins\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Potter\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roberts\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sanborn\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spink\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stanley\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sully\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Todd\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tripp\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Turner\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walworth\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yankton\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ziebach\"," +
            "    \"province\": \"South Dakota\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anderson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bedford\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bledsoe\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blount\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bradley\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Campbell\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cannon\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carter\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cheatham\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chester\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Claiborne\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cocke\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coffee\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crockett\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Davidson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeKalb\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Decatur\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dyer\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fentress\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gibson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Giles\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grainger\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grundy\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamblen\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardeman\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardin\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hawkins\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haywood\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henderson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hickman\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Houston\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Humphreys\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lake\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lauderdale\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lawrence\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Loudon\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Macon\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maury\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McMinn\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McNairy\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Meigs\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moore\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Obion\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Out of TN\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Overton\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Perry\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pickett\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rhea\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roane\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Robertson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rutherford\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sequatchie\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sevier\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Smith\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stewart\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sullivan\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sumner\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tipton\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trousdale\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unicoi\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Union\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Van Buren\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Weakley\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"White\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williamson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilson\"," +
            "    \"province\": \"Tennessee\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Anderson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Andrews\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Angelina\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Aransas\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Archer\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Armstrong\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Atascosa\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Austin\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bailey\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bandera\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bastrop\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Baylor\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bee\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bexar\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Blanco\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Borden\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bosque\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bowie\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brazoria\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brazos\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brewster\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Briscoe\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brooks\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burleson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burnet\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caldwell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Callahan\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cameron\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Camp\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cass\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Castro\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chambers\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cherokee\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Childress\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cochran\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coke\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coleman\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Collin\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Collingsworth\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colorado\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Comal\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Comanche\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Concho\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cooke\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Coryell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cottle\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crane\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crockett\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crosby\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Culberson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dallam\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dallas\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dawson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"DeWitt\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Deaf Smith\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Delta\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Denton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickens\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dimmit\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Donley\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Duval\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eastland\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ector\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Edwards\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"El Paso\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ellis\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Erath\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Falls\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fannin\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fisher\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Floyd\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Foard\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fort Bend\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Freestone\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Frio\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gaines\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Galveston\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garza\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gillespie\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Glasscock\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Goliad\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gonzales\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gray\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grayson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gregg\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grimes\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Guadalupe\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hale\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hall\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hamilton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hansford\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardeman\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardin\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harris\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hartley\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Haskell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hays\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hemphill\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henderson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hidalgo\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hill\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hockley\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hood\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hopkins\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Houston\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Howard\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hudspeth\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hunt\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hutchinson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Irion\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jack\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jasper\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jeff Davis\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jim Hogg\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jim Wells\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jones\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Karnes\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kaufman\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kendall\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kenedy\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kent\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kerr\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kimble\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"King\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kinney\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kleberg\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Knox\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"La Salle\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lamar\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lamb\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lampasas\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lavaca\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Leon\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Liberty\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Limestone\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lipscomb\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Live Oak\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Llano\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Loving\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lubbock\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lynn\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martin\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mason\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Matagorda\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Maverick\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McCulloch\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McLennan\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McMullen\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Medina\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Menard\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Midland\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Milam\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mills\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mitchell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montague\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Moore\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morris\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Motley\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nacogdoches\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Navarro\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nolan\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nueces\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ochiltree\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oldham\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Palo Pinto\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Panola\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Parker\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Parmer\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pecos\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Potter\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Presidio\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rains\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randall\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Reagan\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Real\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Red River\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Reeves\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Refugio\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roberts\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Robertson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockwall\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Runnels\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rusk\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sabine\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Augustine\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Jacinto\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Patricio\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Saba\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Schleicher\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scurry\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shackelford\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shelby\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sherman\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Smith\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Somervell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Starr\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stephens\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sterling\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stonewall\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sutton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Swisher\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tarrant\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Terrell\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Terry\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Throckmorton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Titus\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tom Green\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Travis\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trinity\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tyler\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Upshur\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Upton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Uvalde\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Val Verde\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Van Zandt\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Victoria\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walker\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waller\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ward\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webb\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wharton\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wheeler\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wichita\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilbarger\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Willacy\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williamson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wilson\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winkler\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wise\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wood\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yoakum\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Young\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Zapata\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Zavala\"," +
            "    \"province\": \"Texas\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bear River\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Central Utah\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Davis\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Salt Lake\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Juan\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Southeast Utah\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Southwest Utah\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Summit\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tooele\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"TriCounty\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Utah\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wasatch\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Weber-Morgan\"," +
            "    \"province\": \"Utah\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Addison\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bennington\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caledonia\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chittenden\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Essex\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grand Isle\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lamoille\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orleans\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rutland\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Windham\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Windsor\"," +
            "    \"province\": \"Vermont\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Accomack\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Albemarle\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alexandria\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Alleghany\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Amelia\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Amherst\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Appomattox\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Arlington\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Augusta\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bath\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bedford\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bland\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Botetourt\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bristol\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brunswick\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buchanan\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buckingham\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buena Vista\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Campbell\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Caroline\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carroll\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charles City\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charlotte\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Charlottesville\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chesapeake\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chesterfield\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clarke\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Colonial Heights\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Covington\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Craig\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Culpeper\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cumberland\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Danville\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dickenson\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dinwiddie\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Emporia\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Essex\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fairfax\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fairfax City\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Falls Church\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fauquier\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Floyd\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fluvanna\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin City\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Frederick\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fredericksburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Galax\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Giles\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gloucester\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Goochland\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grayson\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greene\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greensville\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Halifax\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hampton\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hanover\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrisonburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henrico\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Henry\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Highland\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hopewell\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Isle of Wight\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"James City\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"King George\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"King William\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"King and Queen\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lancaster\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lee\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lexington\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Loudoun\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Louisa\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lunenburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lynchburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Madison\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Manassas\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Manassas Park\"," +
            "    \"province\": \"Virginia\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Martinsville\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mathews\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mecklenburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Middlesex\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Montgomery\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nelson\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"New Kent\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Newport News\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Norfolk\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Northampton\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Northumberland\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Norton\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nottoway\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Orange\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Page\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Patrick\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Petersburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pittsylvania\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Poquoson\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Portsmouth\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Powhatan\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prince Edward\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prince George\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Prince William\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pulaski\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Radford\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rappahannock\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richmond\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richmond City\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roanoke\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roanoke City\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockbridge\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rockingham\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Russell\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Salem\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Scott\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shenandoah\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Smyth\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Southampton\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spotsylvania\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stafford\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Staunton\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Suffolk\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Surry\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sussex\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tazewell\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Virginia Beach\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Warren\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waynesboro\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Westmoreland\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Williamsburg\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winchester\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wise\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wythe\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"York\"," +
            "    \"province\": \"Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Asotin\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Benton\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chelan\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clallam\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cowlitz\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ferry\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Franklin\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Garfield\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grays Harbor\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Island\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"King\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kitsap\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kittitas\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Klickitat\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mason\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Okanogan\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pacific\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pend Oreille\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pierce\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"San Juan\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Skagit\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Skamania\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Snohomish\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Spokane\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Stevens\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Thurston\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wahkiakum\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walla Walla\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Whatcom\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Whitman\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Yakima\"," +
            "    \"province\": \"Washington\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barbour\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Berkeley\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Boone\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Braxton\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brooke\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Cabell\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calhoun\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clay\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Doddridge\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fayette\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Gilmer\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Greenbrier\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hampshire\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hancock\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hardy\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Harrison\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kanawha\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lewis\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Logan\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marion\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marshall\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mason\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"McDowell\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mercer\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mineral\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Mingo\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monongalia\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Morgan\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Nicholas\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ohio\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pendleton\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pleasants\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pocahontas\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Preston\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Putnam\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Raleigh\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Randolph\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ritchie\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Roane\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Summers\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tucker\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Tyler\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Upshur\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wayne\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Webster\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wetzel\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wirt\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wood\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wyoming\"," +
            "    \"province\": \"West Virginia\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Adams\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ashland\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Barron\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Bayfield\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Brown\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Buffalo\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Burnett\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Calumet\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Chippewa\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Clark\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Columbia\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crawford\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dane\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dodge\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Door\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Douglas\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Dunn\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Eau Claire\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Florence\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fond du Lac\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Forest\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Grant\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Green\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Green Lake\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iowa\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Iron\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jackson\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Jefferson\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Juneau\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kenosha\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Kewaunee\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"La Crosse\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lafayette\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Langlade\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Manitowoc\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marathon\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marinette\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Marquette\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Menominee\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Milwaukee\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Monroe\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oconto\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Oneida\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Outagamie\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Ozaukee\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pepin\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Pierce\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Polk\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Portage\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Price\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Racine\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Richland\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rock\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Rusk\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sauk\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sawyer\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Shawano\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sheboygan\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"St. Croix\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Taylor\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Trempealeau\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vernon\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Vilas\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Walworth\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washburn\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washington\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waukesha\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waupaca\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Waushara\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Winnebago\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Wood\"," +
            "    \"province\": \"Wisconsin\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Albany\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Big Horn\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Campbell\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Carbon\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Converse\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Crook\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Fremont\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Goshen\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Hot Springs\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Johnson\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Laramie\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Lincoln\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Natrona\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Niobrara\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Park\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Platte\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sheridan\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sublette\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Sweetwater\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Teton\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Uinta\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Unassigned\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," );
                    countyJsonSb.append(
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Washakie\"," +
            "    \"province\": \"Wyoming\"" +
            "  }," +
            "  {" +
            "    \"country\": \"US\"," +
            "    \"county\": \"Weston\"," +
            "    \"province\": \"Wyoming\"" +
            "  }" +
            "]");

        countyJson =countyJsonSb.toString();
        counties = new Gson().fromJson(countyJson, RawCounty[].class);
    }
}