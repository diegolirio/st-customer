package com.diegolirio.st.services.address;

import java.util.List;

import com.diegolirio.st.domain.orm.Address;

public interface AddressService {

	List<Address> findByPeopleCpfCnpj(String peopleCpfCnpj);

	Address save(Address address);

}
