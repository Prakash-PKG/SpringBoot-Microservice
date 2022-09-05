package com.party.entity;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="party")
public class PartyEntity implements Serializable{

private static final long serialVersionUID = 4210721834283946946L;

@Id
@Column(name="party_id")
private Integer partyId;

@Column(name="party_name")
private String partyName;

@Column(name="founder_name")
private String founderName;


@Column(name="founder_year")
private Integer founderYear;


public Integer getPartyId() {
	return partyId;
}


public void setPartyId(Integer partyId) {
	this.partyId = partyId;
}


public String getPartyName() {
	return partyName;
}


public void setPartyName(String partyName) {
	this.partyName = partyName;
}


public String getFounderName() {
	return founderName;
}


public void setFounderName(String founderName) {
	this.founderName = founderName;
}


public Integer getFounderYear() {
	return founderYear;
}


public void setFounderYear(Integer founderYear) {
	this.founderYear = founderYear;
}
	
 


}
