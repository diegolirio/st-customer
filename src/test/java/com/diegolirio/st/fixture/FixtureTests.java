package com.diegolirio.st.fixture;

import java.util.Random;

import org.springframework.stereotype.Component;

import com.diegolirio.st.domain.orm.Address;
import com.diegolirio.st.domain.orm.Customer;
import com.diegolirio.st.domain.orm.People;
import com.diegolirio.st.domain.orm.State;

import br.com.six2six.fixturefactory.Fixture;
import br.com.six2six.fixturefactory.Rule;

@Component
public class FixtureTests {

	public Customer fixtureCustomer() {
		Fixture.of(Customer.class).addTemplate("valid", new Rule() {{
    		  add("cpfCnpj", String.valueOf(new Random().nextLong()));
    		  add("name", firstName());
    		  add("email", "${name}@email.com");
    		  add("active", true);
    		}});
    	return Fixture.from(Customer.class).gimme("valid");
	}	
	

	public Address fixtureAddress(People people, State state) {
		Fixture.of(Address.class).addTemplate("valid", new Rule() {{
			add("cep", "08544640");
			add("publicPlace", "Rua Ribeira Iguape");
			add("neighborhood", "Vila Nações");
			add("city", "Ferraz de Vasconcelos");
			add("number", 1);
			add("state", state);
			add("people", people);
			add("active", true);
		}});
		return Fixture.from(Address.class).gimme("valid");
	}	
	
}
