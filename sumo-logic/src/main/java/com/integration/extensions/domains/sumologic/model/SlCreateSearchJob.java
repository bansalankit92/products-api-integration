package com.integration.extensions.domains.sumologic.model;

import com.integration.extensions.domains.sumologic.CreateSearchJob;

public class SlCreateSearchJob {

    public CreateSearchJob to() {
        CreateSearchJob job = new CreateSearchJob();
        job.id = id;
        job.from = from;
        job.query = query;
        job.to = to;
        return job;
    }

    public static class Create {
        public String id;
    }

    private String id;
    public Long from;

    public Long to;

    public String query;

    public SlCreateSearchJob(Long from, Long to, String query) {
        this.from = from;
        this.to = to;
        this.query = query;
        id = null;
    }

    public SlCreateSearchJob() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}