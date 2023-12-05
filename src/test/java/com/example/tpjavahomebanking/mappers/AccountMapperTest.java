package com.example.tpjavahomebanking.mappers;

import com.example.tpjavahomebanking.models.dtos.AccountDTO;
import com.example.tpjavahomebanking.models.entity.Account;
import com.example.tpjavahomebanking.models.enums.AccountType;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountMapperTest {

    @Test
    public void testAccountToDto() {
        // Given
        Account account = new Account();
        account.setId(1L);
        account.setType(AccountType.SAVINGS_BANK);
        account.setCbu("1234567890123456789012");
        account.setAlias("MyAccount");
        account.setAmount(BigDecimal.valueOf(1000.0));

        // When
        AccountDTO dto = AccountMapper.accountToDto(account);

        // Then
        assertThat(dto.getId()).isEqualTo(1L);
        assertThat(dto.getType()).isEqualTo(AccountType.SAVINGS_BANK);
        assertThat(dto.getCbu()).isEqualTo("1234567890123456789012");
        assertThat(dto.getAlias()).isEqualTo("MyAccount");
        assertThat(dto.getAmount()).isEqualByComparingTo(BigDecimal.valueOf(1000.0));
    }

    @Test
    public void testDtoToAccount() {
        // Given
        AccountDTO dto = new AccountDTO();
        dto.setId(1L);
        dto.setType(AccountType.SAVINGS_BANK);
        dto.setCbu("1234567890123456789012");
        dto.setAlias("MyAccount");
        dto.setAmount(BigDecimal.valueOf(1000.0));

        // When
        Account account = AccountMapper.dtoToAccount(dto);

        // Then
        assertThat(account.getType()).isEqualTo(AccountType.SAVINGS_BANK);
        assertThat(account.getCbu()).isEqualTo("1234567890123456789012");
        assertThat(account.getAlias()).isEqualTo("MyAccount");
        assertThat(account.getAmount()).isEqualByComparingTo(BigDecimal.valueOf(1000.0));
    }
}
