package com.diegolirio.st.services.customer;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.Customer;

@Repository
public interface CustomerRepository extends MongoRepository<Customer, String> {

	Customer findByCpfCnpj(String cpfCnpj);

}
