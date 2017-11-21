package com.diegolirio.st.services.customer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.Customer;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	@Override
	public List<Customer> findAll() {
		return this.customerRepository.findAll();
	}

	@Override
	public Customer findByCpfCnpj(String cpfCnpj) {
		return this.customerRepository.findByCpfCnpj(cpfCnpj);
	}

	@Override
	public Customer save(Customer customer) {
		return this.customerRepository.save(customer);
	}

	@Override
	public void delete(String id) {
		this.customerRepository.delete(id);
	}

}
