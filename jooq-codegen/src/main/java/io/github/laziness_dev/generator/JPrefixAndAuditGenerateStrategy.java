package io.github.laziness_dev.generator;

import org.jooq.codegen.DefaultGeneratorStrategy;
import org.jooq.meta.Definition;

import java.util.ArrayList;
import java.util.List;

import static org.jooq.codegen.GeneratorStrategy.Mode.RECORD;

public class JPrefixAndAuditGenerateStrategy extends DefaultGeneratorStrategy {
    @Override
    public String getJavaClassName(Definition definition, Mode mode) {
        if (mode == Mode.DEFAULT || mode == Mode.POJO || mode == Mode.RECORD) {
            return "J" + super.getJavaClassName(definition, mode);
        }
        return super.getJavaClassName(definition, mode);
    }

    @Override
    public List<String> getJavaClassImplements(Definition definition, Mode mode) {
        if(RECORD.equals(mode)) {
            return List.of(Auditable.class.getName());
        }
        return new ArrayList<>();
    }

    @Override
    public String getJavaSetterName(Definition definition, Mode mode) {
        return "update" + convertCamelCase(toCamelCase(definition.getOutputName()));
    }

    @Override
    public String getJavaGetterName(Definition definition, Mode mode) {
        return toCamelCase(definition.getOutputName());
    }

    private String convertCamelCase(String outputName) {
        return Character.toUpperCase(outputName.charAt(0)) + outputName.substring(1);
    }

    private String toCamelCase(String outputName) {
        String[] parts = outputName.split("_");
        StringBuilder camelCaseString = new StringBuilder();

        for (int i = 0; i < parts.length; i++) {
            String part = parts[i].toLowerCase();
            if (i != 0) {
                part = part.substring(0, 1).toUpperCase() + part.substring(1);
            }
            camelCaseString.append(part);
        }

        return camelCaseString.toString();
    }
}
