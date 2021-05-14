package com.integration.extensions.domains.devops.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.integration.extensions.domains.devops.ResultSummary;
import com.integration.extensions.domains.devops.SyntheticTest;
import com.integration.extensions.domains.devops.TestResult;
import org.codehaus.jettison.json.JSONArray;
import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

public class SyntheticTestUtil {

    public static List<SyntheticTest> getAll(RestClient client) throws JSONException {
        JSONObject response = client.getJson("api/v1/synthetics/tests", Collections.emptyMap());
        JSONArray testsJson = response.getJSONArray("tests");
        List<SyntheticTest> testList = new ArrayList<>(testsJson.length());
        for (int i = 0; i < testsJson.length(); i++) {
            testList.add(parseSyntheticTest(testsJson.getJSONObject(i)));
        }
        return testList;
    }

    public static List<TestResult> getTestResults(RestClient client, String testId) throws JSONException {
        JSONObject response = client.getJson("api/v1/synthetics/tests/" + testId + "/results", Collections.emptyMap());
        JSONArray resultsJson = response.getJSONArray("results");
        List<TestResult> testResults = new ArrayList<>(resultsJson.length());
        for (int i = 0; i < resultsJson.length(); i++) {
            testResults.add(parseTestResult(resultsJson.getJSONObject(i)));
        }
        return testResults;
    }

    private static SyntheticTest parseSyntheticTest(JSONObject json) throws JSONException {
        SyntheticTest syntheticTest = new SyntheticTest();
        syntheticTest.testId = json.getString("public_id");
        syntheticTest.name = json.getString("name");
        syntheticTest.status = json.getString("status");
        syntheticTest.type = json.getString("type");
        syntheticTest.subtype = json.optString("subtype", null);

        Gson gson = new Gson();
        JSONArray locationsJson = json.optJSONArray("locations");
        if (locationsJson != null) {
            syntheticTest.locations = gson.<List<String>>fromJson(locationsJson.toString(),
                    new TypeToken<List<String>>() {
                    }.getType());
        }

        JSONObject configJson = json.optJSONObject("config");
        if (configJson != null) {
            syntheticTest.config = gson.<Map<String, Object>>fromJson(configJson.toString(),
                    new TypeToken<Map<String, Object>>() {
                    }.getType()
            );
        }
        return syntheticTest;
    }

    private static TestResult parseTestResult(JSONObject json) throws JSONException {
        TestResult testResult = new TestResult();
        testResult.resultId = json.getString("result_id");
        testResult.location = json.getString("probe_dc");
        testResult.checkVersion = json.getString("check_version");
        testResult.checkTime = json.getLong("check_time");
        testResult.result = ResultSummary.create(json.optJSONObject("result"));
        return testResult;
    }
}
