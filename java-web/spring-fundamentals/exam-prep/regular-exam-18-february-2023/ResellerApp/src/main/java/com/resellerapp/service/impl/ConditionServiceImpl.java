package com.resellerapp.service.impl;

import com.resellerapp.model.entity.Condition;
import com.resellerapp.model.enums.ConditionType;
import com.resellerapp.repository.ConditionRepository;
import com.resellerapp.service.ConditionService;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class ConditionServiceImpl implements ConditionService {
    private final ConditionRepository conditionRepository;

    public ConditionServiceImpl(ConditionRepository conditionRepository) {
        this.conditionRepository = conditionRepository;
    }

    @Override
    public void seedConditions() {
        if (conditionRepository.count() == 0) {
            Arrays.stream(ConditionType.values()).forEach(conditionType -> {
                Condition condition = new Condition();
                condition.setName(conditionType);
                condition.setDescription(conditionType.getDescription());
                conditionRepository.save(condition);
            });
        }
    }
}
