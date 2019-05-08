package com.cg.PersonService.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Transaction;
import com.cg.PersonService.util.AccountUtil;

@Service
public class AccountService implements IAccountService {

	Map<Integer, Account> accountMap = new HashMap<Integer, Account>();

	public int save(@Valid Account account) throws Exception {

		account.setActId(AccountUtil.createId(accountMap));
		if (accountMap.get(account.getActId()) == null) {
			accountMap.put(account.getActId(), account);
		} else {
			throw new Exception("Account Already Exists");
		}
		return account.getActId();
	}

	public Collection findAll() {
		return accountMap.values();
	}

	public boolean updateAccount(int actId, int initialCredit, Transaction tnx) {
		Account account = accountMap.get(actId);
		account.setBalance(account.getBalance() + initialCredit);
		List list = account.getTnxList();
		if (null == list || list.isEmpty()) {
			list = new ArrayList();
		}
		list.add(tnx);
		account.setTnxList(list);
		accountMap.put(actId, account);
		return true;
	}

	public Account findById(int actId) {
		return accountMap.get(actId);
	}
}
