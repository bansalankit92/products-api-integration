package com.integration.extensions.domains.devops;

import java.lang.Object;
import java.lang.String;
import java.util.HashMap;

public final class CheckApplicationHealthStatusResponse extends HashMap<String, Object> {
  public static final String healthStatus = "Health status";

  public static final String errorRate = "Error rate";

  public static final String aPDEXTarget = "APDEX target";

  public static final String aPDEXScore = "APDEX score";
}
