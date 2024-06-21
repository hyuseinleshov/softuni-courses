package com.resellerapp.model.entity;

import com.resellerapp.model.enums.ConditionType;

import javax.persistence.*;

@Entity
@Table(name = "conditions")
public class Condition extends BaseEntity {

    @Enumerated(EnumType.STRING)
    @Column(unique = true, nullable = false)
    private ConditionType name;

    @Column(nullable = false)
    private String description;

    public ConditionType getName() {
        return name;
    }

    public void setName(ConditionType name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
