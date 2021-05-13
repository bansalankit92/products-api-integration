package com.integration.extensions.domains.sumologic.model;

import java.util.List;
import java.util.stream.Stream;
import com.integration.extensions.domains.sumologic.Collectors;

public final class SlCollectors {

    public static class CList {

        public SlCollectors[] collectors;

        public List<Collectors> to() {
            return Stream.of(collectors).map(SlCollectors::to).collect(java.util.stream.Collectors.toList());
        }

    }

    public static class SingleCollector {

        public SlCollectors collector;

        public Collectors to() {
            return collector.to();
        }

    }

    public Long lastSeenAlive;

    public String timeZone;

    public String description;

    public String category;

    public String collectorType;

    public String id;

    public Boolean alive;

    public String name;

    public Collectors to() {
        Collectors collectors = new Collectors();
        collectors.lastSeenAlive = lastSeenAlive;
        collectors.timeZone = timeZone;
        collectors.alive = alive;
        collectors.category = category;
        collectors.collectorType = collectorType;
        collectors.description = description;
        collectors.id = id;
        collectors.name = name;

        return collectors;
    }

}
