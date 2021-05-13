package com.extensions.domains.development.jira.util.vos;

public class JQLBuilder {

    public static final String AND = " and ";
    private StringBuilder query;

    public JQLBuilder() {
        query = new StringBuilder();
    }

    public JQLBuilder issueType(String value) {
        if (isValid(value))
            query.append(" issuetype = \"").append(value).append("\" ").append(AND);
        return this;
    }

//    public JQLBuilder and() {
//        query.append(AND);
//        return this;
//    }

    public JQLBuilder status(String value) {
        if (isValid(value)) {
            query.append(" status = \"").append(value).append("\" ").append(AND);
        }
        return this;
    }

    public JQLBuilder priority(String value) {
        if (isValid(value))
            query.append(" priority = \"").append(value).append("\" ").append(AND);
        return this;
    }

    public JQLBuilder projectKey(String value) {
          if (isValid(value))
              query.append(" projectKey = \"").append(value).append("\" ").append(AND);
          return this;
      }

    public JQLBuilder summary(String value) {
        if (isValid(value))
            query.append(" summary ~ \"").append(value).append("\" ").append(AND);
        return this;
    }

    public JQLBuilder text(String value) {
        if (isValid(value))
            query.append(" text ~ \"").append(value).append("\" ").append(AND);
        return this;
    }

    private boolean isValid(String value) {
        return value != null && !value.isBlank();
    }

    public JQLBuilder assignee(String value) {
        if (isValid(value))
            query.append(" assignee = \"").append(value).append("\" ").append(AND);
        return this;
    }

    // ideally the input should be enum
    public JQLBuilder orderBy(String value, String direction) {
       String q = removeEndsWith(query.toString(), AND);
       query = new StringBuilder(q);
        if (isValid(value) && (direction.equalsIgnoreCase("asc") || direction.equalsIgnoreCase("desc")))
            query.append(" ORDER BY ").append(value).append(" ").append(direction);
        return this;
    }

    public String build() {
        return removeEndsWith(query.toString(), AND);
    }

    public static String removeEndsWith(String s, String val) {
            if (s.endsWith(val)) {
                int index = s.lastIndexOf(val);
                if (index > 0) {
                    return s.substring(0, index);
                }
            }
            return s;
        }


}