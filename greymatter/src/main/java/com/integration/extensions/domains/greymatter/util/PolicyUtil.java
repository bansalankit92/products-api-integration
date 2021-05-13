package com.integration.extensions.domains.greymatter.util;

import com.integration.extensions.domains.greymatter.Policy;
import com.integration.extensions.domains.greymatter.model.Self;

import java.util.List;

public class PolicyUtil {

    public static String getUserYeildAllPolicy(Self self) {
        return "(if (contains email \"" + self.getEmails().get(0) + "\")(yield-all)(yield R X))";
    }

    public static List<Policy> getPolicies(Self self){
        return List.of(new Policy("Read access to all","(if (contains email \"" + self.getEmails().get(0) + "\")(yield-all)(yield R X))","(if (contains email ${YourEmailId})(yield-all)(yield R X))"));

    }
}