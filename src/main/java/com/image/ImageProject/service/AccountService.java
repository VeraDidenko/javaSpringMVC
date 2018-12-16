package com.image.ImageProject.service;

import com.image.ImageProject.model.Account;

public interface AccountService {

    Account findByLoginAndPassword(String login, String password);

    void save(Account account);

    Account findByLogin(String login);

}
