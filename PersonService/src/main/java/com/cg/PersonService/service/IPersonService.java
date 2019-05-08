package com.cg.PersonService.service;

import java.util.Collection;
import javax.validation.Valid;
import org.springframework.stereotype.Service;
import com.cg.PersonService.model.Account;
import com.cg.PersonService.model.Person;

/**
 * 
 * @author sharsaca
 * 
 *
 */

@Service
public interface IPersonService {

	void save(@Valid Person user) throws Exception;

	Person findById(int id);

	Collection findAll();

	void delete(Person user);

	Person updatePerson(@Valid Account account);

}
