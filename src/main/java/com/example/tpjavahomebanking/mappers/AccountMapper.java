package com.example.tpjavahomebanking.mappers;
import com.example.tpjavahomebanking.models.dtos.AccountDTO;
import com.example.tpjavahomebanking.models.entity.Account;
import lombok.experimental.UtilityClass;

@UtilityClass
public class AccountMapper {
    public AccountDTO accountToDto(Account account){
        return AccountDTO.builder()
                .alias(account.getAlias())
                .type(account.getType())
                .cbu(account.getCbu())
                .amount(account.getAmount())
                .id(account.getId()).build();
    }

    public Account dtoToAccount(AccountDTO dto){
        return Account.builder()
                .alias(dto.getAlias())
                .type(dto.getType())
                .cbu(dto.getCbu())
                .amount(dto.getAmount()).build();
    }
}
