package br.com.fabio.dto.vo;

import java.io.Serializable;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "first_name", "last_name", "gender", "address"})
public class PersonDto implements Serializable{

	private static final long serialVersionUID = 1L;

	private long id;
	
	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;
	private String address;
	
	@JsonIgnore
	private String gander;
	
	public PersonDto() {
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
		return Objects.hash(address, firstName, gander, id, lastName);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		PersonDto other = (PersonDto) obj;
		return Objects.equals(address, other.address) && Objects.equals(firstName, other.firstName)
				&& Objects.equals(gander, other.gander) && id == other.id && Objects.equals(lastName, other.lastName);
	}
	
}
