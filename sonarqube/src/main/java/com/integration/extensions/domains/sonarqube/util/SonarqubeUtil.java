package com.integration.extensions.domains.sonarqube.util;

import com.google.gson.Gson;
import com.integration.extensions.domains.sonarqube.Project;
import com.integration.extensions.domains.sonarqube.dto.ComponentDto;
import com.integration.extensions.domains.sonarqube.dto.MeasuresDto;
import com.integration.extensions.domains.sonarqube.dto.MetricsDto;
import com.integration.extensions.domains.sonarqube.model.SMeasures;
import com.integration.extensions.domains.sonarqube.model.SMetrics;
import com.integration.extensions.domains.sonarqube.model.SProject;
import com.integration.util.RestClient;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SonarqubeUtil {

    public static List<Project> getProjects(RestClient restClient, String search, long page, long size) {
        Map<String, Object> qp = new HashMap<>();
        qp.put("q", search != null && !search.isBlank() ? search : null);
        qp.put("p", page);
        qp.put("ps", size);
        String res = restClient.get("/api/projects/search", qp);
        return new Gson().fromJson(res, SProject.ProjectList.class).list();
    }

    public static MetricsDto getMetrics(RestClient restClient, String projectKey) {
        Map<String, Object> qp = new HashMap<>();
        qp.put("additionalFields", "period,metrics");
        qp.put("component", projectKey);
        qp.put("metricKeys", "alert_status,quality_gate_details,bugs,new_bugs,reliability_rating,new_reliability_rating,vulnerabilities,new_vulnerabilities,security_rating,new_security_rating,security_hotspots,new_security_hotspots,security_hotspots_reviewed,new_security_hotspots_reviewed,security_review_rating,new_security_review_rating,code_smells,new_code_smells,sqale_rating,new_maintainability_rating,sqale_index,new_technical_debt,coverage,new_coverage,lines_to_cover,new_lines_to_cover,tests,duplicated_lines_density,new_duplicated_lines_density,duplicated_blocks,ncloc,ncloc_language_distribution,projects,lines,new_lines");
        String res = restClient.get("/api/measures/component", qp);
        return new Gson().fromJson(res, SMetrics.class).to();
    }

    public static MeasuresDto getMeasures(RestClient restClient, String projectKey, String search, int page, int size) {
        Map<String, Object> qp = new HashMap<>();
        qp.put("q", search != null && !search.isBlank() ? search : null);
        qp.put("p", page);
        qp.put("ps", size);
        qp.put("component", projectKey);
        qp.put("metricKeys", "ncloc,complexity,violations,bugs,duplicated_lines_density,vulnerabilities");
        String res = restClient.get("/api/measures/component_tree", qp);
        return new Gson().fromJson(res, SMeasures.class).to();
    }


    public static List<ComponentDto> getAllMeasures(RestClient restClient, String projectKey, String metricType) {
        int page = 1;
        int pageSize = 100;
        List<ComponentDto> dtos = new ArrayList<>();
        MeasuresDto measuresDto;
        do {
            measuresDto = getMeasures(restClient, projectKey, null, page++, pageSize++);
            measuresDto.components.forEach(x -> {
                for (ComponentDto.Measure m : x.measures) {
                    if (m.metric.equalsIgnoreCase(StringPlus.caps(metricType))) {
                        if (!(m.value.equalsIgnoreCase("0")|| m.value.equalsIgnoreCase("0.0"))) {
                            dtos.add(x);
                            return;
                        }
                    }
                }
            });
        } while ( !measuresDto.components.isEmpty());
        return dtos;
    }

    public static Project getProject(RestClient restClient, String search) {
        Map<String, Object> qp = new HashMap<>();
        qp.put("projects", search != null && !search.isBlank() ? search : null);
        String res = restClient.get("/api/projects/search", qp);
        return new Gson().fromJson(res, SProject.ProjectList.class).list().stream().findFirst().orElseThrow(() -> new RuntimeException("Project not found " + search));
    }

}