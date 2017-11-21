package com.diegolirio.st.services.address;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.Address;

@Repository
public interface AddressRepository extends CrudRepository<Address, String> {

	List<Address> findByPeopleCpfCnpj(String peopleCpfCnpj);

}
