package com.integration.extensions.domains.sumologic.model;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import com.integration.extensions.domains.sumologic.SearchJobRecord;

public final class SlSearchJobRecord {

    public static class Record {

        public String sourceCategory;
        public Double count;

        public SearchJobRecord to() {
            SearchJobRecord record = new SearchJobRecord();

            record.sourceCategory = sourceCategory;
            record.count = count;
            return record;
        }

    }

    public SlSearchJobRecord.RecordMap[] records;

    public static class RecordMap {

        public SlSearchJobRecord.Record map;

    }

    public List<SearchJobRecord> to() {
        return Arrays.stream(records).map(m -> m.map).map(SlSearchJobRecord.Record::to).collect(Collectors.toList());
    }

}
