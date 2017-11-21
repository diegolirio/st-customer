package com.diegolirio.st.services.telephone;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diegolirio.st.domain.orm.Telephone;

@Service
public class TelephoneServiceImpl implements TelephoneService {

	@Autowired
	private TelephoneRepository telephoneRepository;

	@Override
	public List<Telephone> findByPeopleCpfCnpj(String cpfCnpj) {
		return this.telephoneRepository.findByPeopleCpfCnpj(cpfCnpj);
	}

	@Override
	public Telephone save(Telephone telephone) {
		return this.telephoneRepository.save(telephone);
	}

}
