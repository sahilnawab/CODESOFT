package com.codesoft.Account;

import java.util.Optional;

import org.springframework.boot.context.config.ConfigData.Option;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountReposatory extends JpaRepository<AccountDetails, Long> {

	Optional<AccountDetails>  findByAccountNumber(long number);
	
}
