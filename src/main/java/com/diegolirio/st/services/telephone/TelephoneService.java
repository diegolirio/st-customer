package com.diegolirio.st.services.telephone;

import java.util.List;

import com.diegolirio.st.domain.orm.Telephone;

public interface TelephoneService {

	List<Telephone> findByPeopleCpfCnpj(String cpfCnpj);

	Telephone save(Telephone telephone);

}
