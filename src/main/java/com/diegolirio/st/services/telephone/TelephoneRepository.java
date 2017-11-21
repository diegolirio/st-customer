package com.diegolirio.st.services.telephone;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.diegolirio.st.domain.orm.Telephone;

@Repository
public interface TelephoneRepository extends CrudRepository<Telephone, String> {

	List<Telephone> findByPeopleCpfCnpj(String cpfCnpj); 

}
