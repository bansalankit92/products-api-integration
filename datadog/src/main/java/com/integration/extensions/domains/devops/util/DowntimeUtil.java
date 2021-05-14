package com.integration.extensions.domains.devops.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.integration.extensions.domains.devops.DowntimeDetails;
import com.integration.extensions.domains.devops.DowntimeType;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class DowntimeUtil {

    public static List<DowntimeDetails> getAll(RestClient client) throws JSONException {
        JSONArray downtimesJson = client.getJsonArray("api/v1/downtime", Collections.emptyMap());
        List<DowntimeDetails> downtimes = new ArrayList<>(downtimesJson.length());
        for (int i = 0; i < downtimesJson.length(); i++) {
            downtimes.add(parseDowntime(downtimesJson.getJSONObject(i)));
        }
        return downtimes;
    }

    public static boolean cancelDowntime(RestClient client, String downtimeId) throws JSONException {
        String response = client.delete("api/v1/downtime/" + downtimeId, Collections.emptyMap());
        return response != null;
    }

    private static DowntimeDetails parseDowntime(JSONObject json) throws JSONException {
        DowntimeDetails downtime = new DowntimeDetails();
        downtime.downtimeId = json.getString("id");
        downtime.message = json.optString("message");
        downtime.active = json.optBoolean("active");
        downtime.disabled = json.optBoolean("disabled");
        downtime.start = json.optLong("start");
        downtime.end = json.optString("end", null) == null ? null : Long.parseLong(json.getString("end"));
        downtime.canceled = json.optString("canceled", null) == null ? null : Long.parseLong(json.getString("canceled"));
        downtime.timezone = json.optString("timezone");
        downtime.downtimeType = new DowntimeType(json.getInt("downtime_type")).name;

        Gson gson = new Gson();
        JSONArray scopeJson = json.optJSONArray("scope");
        if (scopeJson != null) {
            downtime.scope = gson.<List<String>>fromJson(scopeJson.toString(),
                    new TypeToken<List<String>>() {
                    }.getType());
        }

        JSONObject recurrenceJson = json.optJSONObject("recurrence");
        if (recurrenceJson != null) {
            downtime.recurrence = gson.<Map<String, Object>>fromJson(recurrenceJson.toString(),
                    new TypeToken<Map<String, Object>>() {
                    }.getType());
        }
        return downtime;
    }
}
