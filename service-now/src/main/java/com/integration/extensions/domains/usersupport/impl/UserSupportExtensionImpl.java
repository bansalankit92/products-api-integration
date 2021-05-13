package com.integration.extensions.domains.usersupport.impl;

import java.util.List;
import com.integration.extensions.domains.usersupport.Incident;
import com.integration.extensions.domains.usersupport.User;
import com.serviceNow.xfers.XferIncident;
import com.serviceNow.xfers.XferUser;

/**
 * THIS IS GENERATED TEMPLATE CODE; YOU NEED TO IMPLEMENT REQUESTS & LIFECYCLE METHODS
 */
public class UserSupportExtensionImpl {

    /**
     * Fetch User By Primary Key
     */

    public User fetchUserByPrimaryKey(String primaryKey) throws Exception {
        return XferUser.getUserById(primaryKey);
    }

    /**
     * Fetch Fields Supporting Search For User
     */

    public List fetchFieldsSupportingSearchForUser() {
        return XferUser.fetchFieldsSupportingSearch();
    }

    /**
     * Create User
     */

    public String createUser(User entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update User
     */

    public String updateUser(User entityDefinition, String primaryKey) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Fetch Incident By Primary Key
     */

    public Incident fetchIncidentByPrimaryKey(String primaryKey) throws Exception {
        return XferIncident.getIncidentById(primaryKey);
    }

    /**
     * Fetch Fields Supporting Search For Incident
     */

    public List fetchFieldsSupportingSearchForIncident() {
        return XferIncident.fetchFieldsSupportingSearch();
    }

    /**
     * Create Incident
     */

    public String createIncident(Incident entityDefinition) throws Exception {
        throw new UnsupportedOperationException();
    }

    /**
     * Update Incident
     */

    public String updateIncident(Incident entityDefinition, String primaryKey) throws Exception {
        XferIncident.updateIncident(entityDefinition);
        return primaryKey;
    }

    /**
     * Get incident by number
     */

    public Incident getIncidentByNumber(String number) throws Exception {
        return XferIncident.getIncidentByNumber(number);
    }

    /**
     * Get incidents for the given search criteria
     */

    public List getIncidents(String state, String impact, String urgency) throws Exception {
        return XferIncident.getIncidents(state, impact, urgency);
    }

    /**
     * Assign user to incident
     */

    public Incident assignUserToIncident(String sysIdUser, String sysIdIncident) throws Exception {
        return XferIncident.assignUserToIncident(sysIdUser, sysIdIncident);
    }

    /**
     * Create a new incident
     */

    public Incident createIncident(String callerEmail, String shortDescription, String description,
            String impact, String urgency) throws Exception {
        return XferIncident.createIncident(callerEmail, shortDescription, description, impact, urgency);
    }

    public Incident getUpdatedIncidentNotification(String data) throws Exception {
        return XferIncident.getIncidentByNumber(data);
    }

}
