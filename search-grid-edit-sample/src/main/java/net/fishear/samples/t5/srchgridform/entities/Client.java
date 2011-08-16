package net.fishear.samples.t5.srchgridform.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import net.fishear.data.generic.entities.AbstractStdandardEntity;

@Entity
@Table(name = "CLIENTS")
public class Client extends AbstractStdandardEntity
{

	private String remark;

	private Person person;

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getRemark() {
		return remark;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID")
	public Person getPerson() {
		return person;
	}
	
	@Transient
	public String entityDescription () {
		return "Client '" + (get("person.firstName", "") + " " + get("person.lastName", "")).trim() + "'";
	} 
	
}
