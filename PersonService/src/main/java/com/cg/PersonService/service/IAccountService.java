package com.cg.PersonService.service;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Transaction;


@Service

public interface IAccountService {

  public int save(@Valid Account account) throws Exception;

  public Collection findAll();

  public boolean updateAccount(int actId, int initialCredit, Transaction tnx);

  public Account findById(int actId);


}
