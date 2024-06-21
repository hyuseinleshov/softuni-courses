package com.resellerapp;

import com.resellerapp.service.ConditionService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {
    private final ConditionService conditionService;

    public CommandLineRunnerImpl(ConditionService conditionService) {
        this.conditionService = conditionService;
    }

    @Override
    public void run(String... args) throws Exception {
        conditionService.seedConditions();
    }
}
