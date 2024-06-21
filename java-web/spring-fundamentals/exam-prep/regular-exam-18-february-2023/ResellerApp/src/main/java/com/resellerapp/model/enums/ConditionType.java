package com.resellerapp.model.enums;

public enum ConditionType {
    EXCELLENT("In perfect condition"),
    GOOD("Some signs of wear and tear or minor defects"),
    ACCEPTABLE("The item is fairly worn but continues to function properly");

    private final String description;

    ConditionType(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
