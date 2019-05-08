/**
 * 
 */
package com.cg.PersonService.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Person;
import com.cg.PersonService.model.Transaction;
import com.cg.PersonService.service.IAccountService;
import com.cg.PersonService.service.IPersonService;
import com.cg.PersonService.service.ITransactionService;

/**
 * @author sharsaca
 *
 */

@Controller
public class AccountController {

	@Autowired
	IPersonService personservice;

	@Autowired
	IAccountService accountservice;

	@Autowired
	ITransactionService tnxservice;

	@GetMapping("/newAccount")
	public String getAccountPage(Account account) {

		return "add-account";
	}

	@PostMapping("/createAccount")
	public String createAccount(@Valid Account account, BindingResult result,
			Model model) {

		if (result.hasErrors()) {
			return "add-account";
		}

		if (personservice.findById(account.getCustId()) == null) {
			model.addAttribute("person", new Person());
			model.addAttribute("USERMANDATORY",
					"Customer Id Not Found, Please Create User Prior To Create Account");

			return "add-user";
		}

		try {
			int actId = accountservice.save(account);
			account.setActId(actId);
			if (account.getInitialCredit() != 0) {
				int tnxId = tnxservice.beginTransaction(actId, account);
			}

			personservice.updatePerson(account);

		} catch (Exception e) {
			e.printStackTrace();
		}

		return generateReportById(account.getCustId(), model);
	}

	@GetMapping("/findReportById/{id}")
	public String generateReportById(@PathVariable("id") int id, Model model) {

		Person p = personservice.findById(id);

		if (p == null) {
			return "add-account";
		}

		List<Account> list = p.getAccountList();
		int balance = 0;
		List tnxList = new ArrayList();
		if (list != null) {
			for (Account account : list) {
				balance = balance + account.getBalance();

				List<Transaction> aTnxList = account.getTnxList();
				if (null != aTnxList)
					tnxList.addAll(aTnxList);
			}
		}

		model.addAttribute("transactions", tnxList);
		model.addAttribute("persons", p);
		model.addAttribute("totalBalance", balance);

		return "showReport";
	}

	@GetMapping("/completeReport")
	public String generateReport(Model model) {

		Collection p = personservice.findAll();
		model.addAttribute("persons", p);
		return "completeReport";
	}
}
