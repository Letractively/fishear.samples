package net.fishear.sampleapps.evocus.services;


import net.fishear.data.generic.query.QueryFactory;
import net.fishear.data.generic.services.AbstractService;
import net.fishear.exceptions.ValidationException;
import net.fishear.sampleapps.evocus.entities.Person;
import net.fishear.utils.Texts;


public class 
	PersonService 
extends
	AbstractService<Person>
{
	public void validate(Person entity) {
		if(Texts.tos(entity.getPersonCode()).length() == 0) {
			throw new ValidationException("missing-person-code");
		}
		if(Texts.tos(entity.getFirstName()).length() == 0) {
			throw new ValidationException("missing-first-name");
		}
		if(Texts.tos(entity.getLastName()).length() == 0) {
			throw new ValidationException("missing-last-name");
		}
		if(entity.isNew()) {
			if(super.list(QueryFactory.equals("personCode", entity.getPersonCode())).size() > 0) {
				throw new ValidationException("person-code-already-exists", entity.getPersonCode());
			}
		}
	}
	
	public Person getByPersonCode(String code) {
		return super.read(QueryFactory.equals("personCode", code));
	}
}
