package com.company.relationships.web.lab08;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.Optional;

@Repository
public class AccountDaoImpl implements  AccountDao{

    @Autowired
    private AccountRepo accountRepo;

    @Override
    public void deposit(String accountNumber, int amount) {
        Statement statement = new Statement();
        statement.setId((int) (Math.random()*100));
        statement.setType("DEBIT");
        statement.setAmount(amount);
        Optional<Account> accountOptional = accountRepo.findById(Integer.parseInt(accountNumber));
        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();
            account.setBalance(account.getBalance() + amount);
            account.setStatementList(Arrays.asList(statement));
            statement.setAccount(account);
            accountRepo.save(account);
        } else {
            System.out.println("Invalid A/C No.");
        }
    }

    @Override
    public void withdraw(String accountNumber, int amount) {
        Statement statement = new Statement();
        statement.setId((int) (Math.random()*100));
        statement.setType("CREDIT");
        statement.setAmount(amount);
        Optional<Account> accountOptional = accountRepo.findById(Integer.parseInt(accountNumber));
        if(accountOptional.isPresent()) {
            Account account = accountOptional.get();
            if(amount > account.getBalance()) {
                System.out.println("Insufficient Balance!!!");
            } else {
                account.setBalance(account.getBalance() - amount);
                account.setStatementList(Arrays.asList(statement));
                statement.setAccount(account);
                accountRepo.save(account);
            }
        } else {
            System.out.println("Invalid A/C No.");
        }
    }
}
