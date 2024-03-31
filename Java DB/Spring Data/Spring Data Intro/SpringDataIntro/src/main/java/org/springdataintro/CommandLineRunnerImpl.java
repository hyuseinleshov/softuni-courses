package org.springdataintro;

import org.springdataintro.data.entities.Account;
import org.springdataintro.data.entities.User;
import org.springdataintro.data.service.AccountService;
import org.springdataintro.data.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Set;

@Component
public class CommandLineRunnerImpl implements CommandLineRunner {

    @Autowired
    private final UserService userService;

    @Autowired
    private final AccountService accountService;

    public CommandLineRunnerImpl(UserService userService, AccountService accountService) {
        this.userService = userService;
        this.accountService = accountService;
    }

    @Override
    public void run(String... args) throws Exception {
        User user = this.userService.findByName("Pesho");

        System.out.println(user.getUsername() + " " + user.getAge());
    }
}
