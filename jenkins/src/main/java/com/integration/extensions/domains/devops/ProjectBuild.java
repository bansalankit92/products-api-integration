package com.integration.extensions.domains.devops;

import java.util.List;
import com.google.gson.annotations.SerializedName;

/**
 * THIS IS GENERATED CODE; MODIFY ONLY IF YOU UNDERSTAND WHAT YOU'RE DOING
 */
public final class ProjectBuild {
  @SerializedName("Project Id")
  public String projectId;

  @SerializedName("Build types")
  public List buildTypes;

  @SerializedName("Name")
  public String name;

  /**
   * Please add only relevant fields here for summary.
   */
  @Override
  public String toString() {
    return name;
  }

  public ProjectBuild(String name) {
    this.name = name;
  }
}
