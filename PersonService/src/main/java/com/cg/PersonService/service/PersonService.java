package com.cg.PersonService.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Person;
import com.cg.PersonService.util.AccountUtil;

@Service
public class PersonService implements IPersonService {
	
	Map<Integer,Person> personMap = new HashMap<Integer,Person>();

	public void save(@Valid Person person) throws Exception {
		person.setId(AccountUtil.createId(personMap));
		if (personMap.get(person.getId()) == null) {
			personMap.put(person.getId(), person);
		} else {
			throw new Exception("Person Already Exists");
		}
	}

	public Person findById(int id) {
		return personMap.get(id);
	}

	public Collection findAll() {
		return personMap.values();
	}

	public void delete(Person person) {
		personMap.remove(person.getId());
	}

	public Person updatePerson(@Valid Account account) {
		Person p = findById(account.getCustId());
		List list = p.getAccountList();
		if (null == list || list.isEmpty()) {
			list = new ArrayList();
		}
		list.add(account);
		p.setAccountList(list);
		personMap.put(account.getCustId(), p);
		return p;
	}
}