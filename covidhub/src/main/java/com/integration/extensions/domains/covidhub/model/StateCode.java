package com.integration.extensions.domains.covidhub.model;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class StateCode {

    public static String stateCodeMap = "{\"Alabama\":\"AL\",\"Alaska\":\"AK\",\"American Samoa\":\"AS\",\"Arizona\":\"AZ\",\"Arkansas\":\"AR\",\"California\":\"CA\",\"Colorado\":\"CO\",\"Connecticut\":\"CT\",\"Delaware\":\"DE\",\"District Of Columbia\":\"DC\",\"Federated States Of Micronesia\":\"FM\",\"Florida\":\"FL\",\"Georgia\":\"GA\",\"Guam\":\"GU\",\"Hawaii\":\"HI\",\"Idaho\":\"ID\",\"Illinois\":\"IL\",\"Indiana\":\"IN\",\"Iowa\":\"IA\",\"Kansas\":\"KS\",\"Kentucky\":\"KY\",\"Louisiana\":\"LA\",\"Maine\":\"ME\",\"Marshall Islands\":\"MH\",\"Maryland\":\"MD\",\"Massachusetts\":\"MA\",\"Michigan\":\"MI\",\"Minnesota\":\"MN\",\"Mississippi\":\"MS\",\"Missouri\":\"MO\",\"Montana\":\"MT\",\"Nebraska\":\"NE\",\"Nevada\":\"NV\",\"New Hampshire\":\"NH\",\"New Jersey\":\"NJ\",\"New Mexico\":\"NM\",\"New York\":\"NY\",\"North Carolina\":\"NC\",\"North Dakota\":\"ND\",\"Northern Mariana Islands\":\"MP\",\"Ohio\":\"OH\",\"Oklahoma\":\"OK\",\"Oregon\":\"OR\",\"Palau\":\"PW\",\"Pennsylvania\":\"PA\",\"Puerto Rico\":\"PR\",\"Rhode Island\":\"RI\",\"South Carolina\":\"SC\",\"South Dakota\":\"SD\",\"Tennessee\":\"TN\",\"Texas\":\"TX\",\"Utah\":\"UT\",\"Vermont\":\"VT\",\"United States Virgin Islands\":\"VI\",\"Virginia\":\"VA\",\"Washington\":\"WA\",\"West Virginia\":\"WV\",\"Wisconsin\":\"WI\",\"Wyoming\":\"WY\"}";

    public static Map<String, String> stateCode = new HashMap<>();

    static {
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        stateCode = new Gson().fromJson(stateCodeMap, type);
    }

    public static String getCode(String state) {
        return stateCode.getOrDefault(state, "");
    }
}