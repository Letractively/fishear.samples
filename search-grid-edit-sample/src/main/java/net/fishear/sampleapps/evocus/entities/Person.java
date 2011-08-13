package net.fishear.sampleapps.evocus.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.fishear.data.generic.entities.AbstractStdandardEntity;

@Entity
@Table(name="PERSON")
public class 
	Person
extends
	AbstractStdandardEntity
{

	private String firstName;
	
    private String lastName;
    
    private String personCode;
    
    private String titles;
    
    @Column(name = "LASTNAME")
    public String getLastName() { 
    	return lastName;
    }

    public void setLastName(String message) { 
    	this.lastName = message;
    }

	public void setPersonCode(String personCode) {
		this.personCode = personCode;
	}

	@Column(name = "CODE")
	public String getPersonCode() {
		return personCode;
	}

	public void setFirstName(String recName) {
		this.firstName = recName;
	}

	@Column(name = "FIRSTNAME")
	public String getFirstName() {
		return firstName;
	}
	
	public void setTitles(String titles) {
		this.titles = titles;
	}

	@Column(name = "TITLES")
	public String getTitles() {
		return titles;
	}
}
