package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.dtos.AccountDTO;
import com.example.tpjavahomebanking.models.entity.Account;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {
    public AccountDTO accountToDto(Account account){
        AccountDTO dto = new AccountDTO();

        dto.setAlias(account.getAlias());
        dto.setCbu(account.getCbu());
        dto.setType(account.getType());
        dto.setAmount(account.getAmount());
        dto.setId(account.getId());

        return dto;
    }

    public Account dtoToAccount(AccountDTO dto){
        Account account = new Account();

        account.setAlias(dto.getAlias());
        account.setType(dto.getType());
        account.setCbu(dto.getCbu());
        account.setAmount(dto.getAmount());

        return account;
    }
}