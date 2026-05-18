package com.ndt.CRM_project.entity;


public class User {
    private Integer id;

    private String fullname;

    private String firstName;

    private String lastName;

    private String email;

    private String password;

    private String roleName;


    public User() {

    }


    public User(Integer id, String fullname) {
        this.id = id;
        this.fullname = fullname;
    }


    public User(Integer id, String email, String password) {
        this.id = id;
        this.email = email;
        this.password = password;
    }


    public User(Integer id, String fullname, String firstName, String lastName, String email, String roleName, String password) {
        this.id = id;
        this.fullname = fullname;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleName = roleName;
        this.password = password;
    }


    public User(Integer id, String firstName, String lastName, String email, String roleName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.roleName = roleName;
    }


    public User(Integer id, String firstName, String lastName, String email, String roleName, String password) {
        this(id, firstName, lastName, email, roleName);
        this.password = password;
    }


    public Integer getId() {
        return id;
    }


    public void setId(Integer id) {
        this.id = id;
    }


    public String getFullname() {
        return fullname;
    }


    public void setFullname(String fullname) {
        this.fullname = fullname;
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


    public String getEmail() {
        return email;
    }


    public void setEmail(String email) {
        this.email = email;
    }


    public String getRoleName() {
        return roleName;
    }


    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
            "id=" + id +
            ", fullname='" + fullname + '\'' +
            ", firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", roleName='" + roleName + '\'' +
            '}';
    }
}
