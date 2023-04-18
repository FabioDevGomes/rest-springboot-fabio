package br.com.fabio.dto.vo.v2;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

public class PersonDtoV2 implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	private String firstName;
	private String lastName;
	private String address;
	private String gander;
	private Date birthDay;
	
	public PersonDtoV2() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGander() {
		return gander;
	}

	public void setGander(String gander) {
		this.gander = gander;
	}


	@Override
	public int hashCode() {
		return Objects.hash(address, birthDay, firstName, gander, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDtoV2 other = (PersonDtoV2) obj;
		return Objects.equals(address, other.address) && Objects.equals(birthDay, other.birthDay)
				&& Objects.equals(firstName, other.firstName) && Objects.equals(gander, other.gander) && id == other.id
				&& Objects.equals(lastName, other.lastName);
	}

	public Date getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(Date birthDay) {
		this.birthDay = birthDay;
	}
	
}
