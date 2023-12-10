package com.example.tpjavahomebanking.service;
import com.example.tpjavahomebanking.exceptions.UserNotExistsException;
import com.example.tpjavahomebanking.mappers.AccountMapper;
import com.example.tpjavahomebanking.mappers.UserMapper;
import com.example.tpjavahomebanking.models.Account;
import com.example.tpjavahomebanking.models.User;
import com.example.tpjavahomebanking.models.dtos.AccountDTO;
import com.example.tpjavahomebanking.models.dtos.UserDTO;
import com.example.tpjavahomebanking.models.enums.AccountType;
import com.example.tpjavahomebanking.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;
@Service
public class AccountService {
    private final AccountRepository repository;

    public AccountService(AccountRepository repository){
        this.repository = repository;
    }
    public List<AccountDTO> getAccounts() {
        List<Account> accounts = repository.findAll();
        return accounts.stream()
                .map(AccountMapper::accountToDto)
                .collect(Collectors.toList());
    }

    public AccountDTO createAccount(AccountDTO dto) {
        // TODO: REFACTOR
        //dto.setType(AccountType.SAVINGS_BANK);
        dto.setAmount(BigDecimal.ZERO);
        Account newAccount = repository.save(AccountMapper.dtoToAccount(dto));
        return AccountMapper.accountToDto(newAccount);
    }

    public AccountDTO getAccountById(Long id) {
        Account entity = repository.findById(id).get();
        return AccountMapper.accountToDto(entity);
    }

    public String deleteAccount(Long id){
        if (repository.existsById(id)){
            repository.deleteById(id);
            return "La cuenta con id: " + id + " ha sido eliminada";
        } else {
            // TODO: REFACTOR create new exception
            throw new UserNotExistsException("La cuenta a eliminar no existe");
        }

    }

    public AccountDTO updateAccount(Long id, AccountDTO dto) {
        if (repository.existsById(id)) {
            Account accountToModify = repository.findById(id).get();
            // Validar qué datos no vienen en null para setearlos al objeto ya creado

            // Logica del Patch
            if (dto.getAlias() != null) {
                accountToModify.setAlias(dto.getAlias());
            }

            if (dto.getType() != null) {
                accountToModify.setType(dto.getType());
            }

            if (dto.getCbu() != null) {
                accountToModify.setCbu(dto.getCbu());
            }

            if (dto.getAmount() != null) {
                accountToModify.setAmount(dto.getAmount());
            }

            Account accountModified = repository.save(accountToModify);

            return AccountMapper.accountToDto(accountModified);
        }
        return null;
    }
}
