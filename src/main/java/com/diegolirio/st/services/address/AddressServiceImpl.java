package com.diegolirio.st.services.address;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.Address;

@Service
public class AddressServiceImpl implements AddressService {

	@Autowired
	private AddressRepository addressReposiotry;

	@Override
	public List<Address> findByPeopleCpfCnpj(String peopleCpfCnpj) {
		return this.addressReposiotry.findByPeopleCpfCnpj(peopleCpfCnpj);
	}

	@Override
	public Address save(Address address) {
		return this.addressReposiotry.save(address);
	}

}
