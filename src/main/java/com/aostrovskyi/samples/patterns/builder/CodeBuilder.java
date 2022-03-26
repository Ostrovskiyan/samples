package com.aostrovskyi.samples.patterns.builder;

import java.util.HashMap;
import java.util.Map;

public class CodeBuilder {
    private final String className;
    private final Map<String, String> fields;

    public CodeBuilder(String className) {
        this.className = className;
        fields = new HashMap<>();
    }

    public CodeBuilder addField(String name, String type)
    {
        fields.put(name, type);
        return this;
    }

    @Override
    public String toString()
    {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("public class %s", className)).append(System.lineSeparator());
        sb.append("{").append(System.lineSeparator());
        fields.forEach((fieldName, type) -> sb
                .append(String.format("   public %s %s;", type, fieldName))
                .append(System.lineSeparator())
        );
        sb.append("}");
        return sb.toString();
    }

}
