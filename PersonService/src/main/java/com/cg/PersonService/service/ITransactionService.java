package com.cg.PersonService.service;

import org.springframework.stereotype.Service;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Transaction;

@Service
public interface ITransactionService {

	public int beginTransaction(int actId, Account account);

	public Transaction getTnxById(int tnxId);

}
