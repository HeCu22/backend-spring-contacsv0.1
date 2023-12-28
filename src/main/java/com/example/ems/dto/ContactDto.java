package com.example.ems.dto;


public class ContactDto {
    private Long Id;;

    private String firstName;
    private String lastName;
    private String email;

    public ContactDto(Long id, String firstName, String lastName, String email) {
        this.Id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public ContactDto() {};


    public Long getId() {
        return Id;
    }


    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }


    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(Long id) {
        Id = id;
    }
}
