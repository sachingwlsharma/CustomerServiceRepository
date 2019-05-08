package com.cg.PersonService.service;

import java.util.ArrayList;

import java.util.List;

import org.junit.Before;

import org.junit.Test;

import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.skyscreamer.jsonassert.JSONAssert;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import org.springframework.boot.test.mock.mockito.MockBean;

import org.springframework.test.context.junit4.SpringRunner;

import org.springframework.test.web.servlet.MockMvc;

import com.cg.PersonService.model.Account;

import com.cg.PersonService.model.Person;

import com.cg.PersonService.model.Transaction;

@RunWith(SpringRunner.class)
@WebMvcTest(value = AccountService.class, secure = false)
public class AccountServiceTest {

	@Autowired
	private MockMvc mockMvc;

	@MockBean
	private AccountService accountService;

	@MockBean
	private PersonService personService;

	@MockBean
	private TransactionService tnxService;

	Person p = new Person();

	Account a = new Account();

	Transaction t = new Transaction();

	List tnxList = new ArrayList();

	List actList = new ArrayList();

	@Before
	public void before() {

		t.setActId(1);

		t.setCustId(1);

		t.setTnxDesc("C");

		t.setTnxId(101);

		t.setTnxValue(100);

		tnxList.add(t);

		a.setActId(1);

		a.setBalance(100);

		a.setCustId(1);

		a.setInitialCredit(100);

		a.setTnxList(tnxList);

		actList.add(a);

		p.setId(1);

		p.setLastName("sharma");

		p.setName("firstname");

		p.setAccountList(actList);

	}

	@Test
	public void saveTest() throws Exception {

		Mockito.when(

		accountService.save((Account) Mockito.any())).thenReturn(a.getActId());

		int actId = accountService.save(a);

		JSONAssert.assertEquals("1", String.valueOf(actId), false);

	}

}