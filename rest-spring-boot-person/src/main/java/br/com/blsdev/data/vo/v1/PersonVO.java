package br.com.blsdev.data.vo.v1;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.io.Serializable;
import java.util.Objects;

@JsonPropertyOrder({"id", "first_Name", "last_Name",  "address", "gender"})
public class PersonVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private long id;
    @JsonProperty("first_Name")
    private String firstName;
    @JsonProperty("last_Name")
    private String lastName;
    private String address;
    private String gender;

    public PersonVO() {
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

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonVO personVO = (PersonVO) o;
        return id == personVO.id &&
                Objects.equals(firstName, personVO.firstName) &&
                Objects.equals(lastName, personVO.lastName) &&
                Objects.equals(address, personVO.address) &&
                Objects.equals(gender, personVO.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstName, lastName, address, gender);
    }
}