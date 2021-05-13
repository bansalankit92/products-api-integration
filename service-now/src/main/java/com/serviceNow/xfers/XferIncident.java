package com.serviceNow.xfers;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;
import com.integration.extensions.domains.usersupport.Incident;
import com.net.gson.GsonBuilder;
import com.serviceNow.drivers.SnEntityDriver;
import com.serviceNow.drivers.SnEntityDriverMap;
import com.serviceNow.entities.SnIncident;
import com.serviceNow.entities.SnProblem;
import com.serviceNow.entities.SnSysUser;

@SuppressWarnings({
        "rawtypes",
        "MagicNumber"
})
public class XferIncident {

    private static final SnEntityDriver<SnIncident> incidentDriver = SnEntityDriverMap.getDriver(SnIncident.class);
    private static final SnEntityDriver<SnSysUser> sysUserDriver = SnEntityDriverMap.getDriver(SnSysUser.class);

    public static List fetchFieldsSupportingSearch() {
        //return List.of("Urgency", "Impact", "State");
        return new ArrayList();
    }

    public static List genericSearch(Map<String, String> selectorMap) throws Exception {
        List<Pair<String, String>> res = new ArrayList<>();
        Consumer<SnIncident> iterator = instance -> res.add(new Pair<>(instance.sys_id,
                instance.number + ", " + instance.short_description));
        for (Map.Entry<String, String> entry : selectorMap.entrySet()) {
            String matchPattern = entry.getValue();
            String selector = entry.getKey();
            if ("Urgency".equalsIgnoreCase(selector)) {
                String index = XferBase.enumUrgency.getIndex(matchPattern);
                incidentDriver.getList(5000, "urgency", index).forEach(iterator);
            } else if ("Impact".equalsIgnoreCase(selector)) {
                String index = XferBase.enumImpact.getIndex(matchPattern);
                incidentDriver.getList(5000, "impact", index).forEach(iterator);
            } else if ("State".equalsIgnoreCase(selector)) {
                String index = XferBase.enumState.getIndex(matchPattern);
                incidentDriver.getList(5000, "state", index).forEach(iterator);
            } else if ("Number".equalsIgnoreCase(selector)) {
                incidentDriver.getList(5000, "number", matchPattern).forEach(iterator);
            }
        }
        return res;
    }

    public static Incident createIncident(String callerEmail, String shortDescription, String description,
            String impact, String urgency) throws Exception {
        SnSysUser caller = sysUserDriver.getByKey("email", callerEmail);

        Map<String, String> varMap = new LinkedHashMap<>();
        if (caller != null) {
            varMap.put("caller_id", caller.getSysId());
        }

        varMap.put("short_description", shortDescription);
        varMap.put("description", description);
        varMap.put("impact", XferBase.enumImpact.getIndex(impact));
        varMap.put("urgency", XferBase.enumUrgency.getIndex(urgency));
        varMap.put("state", XferBase.enumState.getIndex("New"));

        SnIncident newEntity = incidentDriver.insert(null, varMap);
        return xfer(newEntity);
    }

    public static Incident assignUserToIncident(String sysIdUser, String sysIdIncident) throws IOException {
        return xfer(incidentDriver.update(sysIdIncident, "assigned_to", sysIdUser));
    }

    public static Incident updateIncident(Incident incident) throws Exception {
        Map<String, String> varMap = new LinkedHashMap<>();
        varMap.put("short_description", incident.shortDescription);
        varMap.put("description", incident.description);
        varMap.put("impact", XferBase.enumImpact.getIndex(incident.impact));
        varMap.put("urgency", XferBase.enumUrgency.getIndex(incident.urgency));
        varMap.put("state", XferBase.enumState.getIndex(incident.state));
        return xfer(incidentDriver.update(incident.sysId, varMap));
    }

    public static Incident getIncidentByNumber(String number) throws Exception {
        return xfer(incidentDriver.getByNumber(number));
    }

    public static Incident getIncidentById(String sysId) throws IOException {
        return xfer(incidentDriver.getById(sysId));
    }

    public static List getIncidents(String state, String impact, String urgency) throws Exception {
        Map<String, String> varMap = new LinkedHashMap<>();
        if (impact != null && (impact = impact.trim()).length() > 0) {
            varMap.put("impact", XferBase.enumImpact.getIndex(impact));
        }

        if (urgency != null && (urgency = urgency.trim()).length() > 0) {
            varMap.put("urgency", XferBase.enumUrgency.getIndex(urgency));
        }

        if (state != null && (state = state.trim()).length() > 0) {
            varMap.put("state", XferBase.enumState.getIndex(state));
        }

        return xfer(incidentDriver.getList(5000, varMap));
    }

    public static Incident xfer(SnIncident nativeObj) throws IOException {
        if (nativeObj == null) {
            return null;
        }

        SnSysUser caller = nativeObj.getLinkActual("caller_id");
        SnProblem problem = nativeObj.getLinkActual("problem");
        SnSysUser assignedTo = nativeObj.getLinkActual("assigned_to");

        Incident entity = new Incident();
        entity.assignedToId = assignedTo == null ? null : assignedTo.sys_id;
        entity.assignedTo = assignedTo == null ? null : assignedTo.name;
        entity.description = nativeObj.description;
        entity.number = nativeObj.number;
        entity.caller = caller == null ? null : caller.name;
        entity.state = XferBase.enumState.getKey(nativeObj.state);
        entity.shortDescription = nativeObj.short_description;
        entity.problem = problem == null ? null : problem.number;
        entity.callerId = caller == null ? null : caller.sys_id;
        entity.sysId = nativeObj.sys_id;
        entity.urgency = XferBase.enumUrgency.getKey(nativeObj.urgency);
        entity.impact = XferBase.enumImpact.getKey(nativeObj.impact);
        return entity;
    }

    public static List<Incident> xfer(List<SnIncident> list) throws IOException {
        List<Incident> xferList = new ArrayList<>(list.size());
        for (SnIncident obj : list) {
            xferList.add(xfer(obj));
        }
        return xferList;
    }

    public static void main(String[] args) throws Exception {
        Incident incident = createIncident("employee@example.com", "Hello", "Hello again", "High", "High");
        System.out.println(GsonBuilder.toPrettyJson(incident));

        //Map<String, String> selectorMap = new LinkedHashMap<>();
        //selectorMap.put("Impact", "High");
        //System.out.println(genericSearch(selectorMap).size());

        //System.out.println(GsonBuilder.toPrettyJson(getIncidentByNumber("INC0010013")));

        //System.out.println(getIncidents(null, null, null).size());
    }

}