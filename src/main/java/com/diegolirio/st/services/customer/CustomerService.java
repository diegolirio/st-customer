package com.diegolirio.st.services.customer;

import java.util.List;

import com.diegolirio.st.domain.orm.Customer;

public interface CustomerService {

	List<Customer> findAll();

	Customer findByCpfCnpj(String cpfCnpj);

	Customer save(Customer customer);

	void delete(String id);

}
