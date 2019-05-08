package com.cg.PersonService.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Transaction;
import com.cg.PersonService.util.AccountUtil;

@Service
public class TransactionService implements ITransactionService {

	@Autowired
	IAccountService accountservice;
	Map<Integer, Transaction> tnxMap = new HashMap<Integer, Transaction>();

	public int beginTransaction(int actId, Account account) {
		Transaction tnx = new Transaction();
		int initialCredit = account.getInitialCredit();
		int tnxId = AccountUtil.createId(tnxMap);
		int custId = account.getCustId();
		tnx.setTnxId(tnxId);
		tnx.setTnxDesc(initialCredit > 0 ? "C" : "D");
		tnx.setActId(actId);
		tnx.setCustId(custId);
		tnx.setTnxValue(initialCredit);
		tnxMap.put(tnx.getTnxId(), tnx);
		accountservice.updateAccount(actId, initialCredit, tnx);
		return tnxId;
	}

	public Transaction getTnxById(int tnxId) {
		return tnxMap.get(tnxId);
	}
}
