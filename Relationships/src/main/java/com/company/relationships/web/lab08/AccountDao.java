package com.company.relationships.web.lab08;

public interface AccountDao {
    void deposit(String accountNumber, int amount);
    void withdraw(String accountNumber, int amount);
}
