package com.image.ImageProject.repository;

import com.image.ImageProject.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, String> {

    Account findByLoginAndPassword(String login, String password);
    Account findByLogin(String login);

}
