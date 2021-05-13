package com.integration.extensions.domains.sumologic.model;

import java.util.List;
import java.util.stream.Stream;
import com.integration.extensions.domains.sumologic.HostedSources;

public final class SlHostedSources {

    public static class SourceList {

        public SlHostedSources[] sources;

        public List<HostedSources> to() {
            return Stream.of(sources).map(SlHostedSources::to).collect(java.util.stream.Collectors.toList());
        }

    }

    public static class SingleSource {

        public SlHostedSources source;

        public HostedSources to() {
            return source.to();
        }

    }

    public Boolean multilineProcessingEnabled;

    public Boolean automaticDateParsing;

    public String timeZone;

    public List filters;

    public String category;

    public String sourceType;

    public String collectorId;

    public String id;

    public Boolean alive;

    public String url;

    public String name;

    public HostedSources to() {
        HostedSources sources = new HostedSources();
        sources.multilineProcessingEnabled = multilineProcessingEnabled;
        sources.automaticDateParsing = automaticDateParsing;
        sources.alive = alive;
        sources.id = id;
        sources.name = name;
        sources.timeZone = timeZone;
        sources.filters = filters;
        sources.category = category;
        sources.sourceType = sourceType;
        sources.collectorId = collectorId;
        sources.uRL = url;

        return sources;

    }

}
