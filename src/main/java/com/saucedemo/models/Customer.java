package com.saucedemo.models;

public class Customer {

    private String username;
    private String password;
    private String product1;
    private String product2;
    private String firstName;
    private String lastName;
    private String postalCode;

    // ─── Constructor ──────────────────────────────────────────────────────────

    public Customer() {}

    public Customer(String username, String password,
                    String product1, String product2,
                    String firstName, String lastName,
                    String postalCode) {
        this.username    = username;
        this.password    = password;
        this.product1    = product1;
        this.product2    = product2;
        this.firstName   = firstName;
        this.lastName    = lastName;
        this.postalCode  = postalCode;
    }

    // ─── Getters & Setters ────────────────────────────────────────────────────

    public String getUsername()               { return username; }
    public void setUsername(String username)  { this.username = username; }

    public String getPassword()               { return password; }
    public void setPassword(String password)  { this.password = password; }

    public String getProduct1()               { return product1; }
    public void setProduct1(String product1)  { this.product1 = product1; }

    public String getProduct2()               { return product2; }
    public void setProduct2(String product2)  { this.product2 = product2; }

    public String getFirstName()                  { return firstName; }
    public void setFirstName(String firstName)    { this.firstName = firstName; }

    public String getLastName()                   { return lastName; }
    public void setLastName(String lastName)      { this.lastName = lastName; }

    public String getPostalCode()                     { return postalCode; }
    public void setPostalCode(String postalCode)      { this.postalCode = postalCode; }

    // ─── toString ─────────────────────────────────────────────────────────────

    @Override
    public String toString() {
        return "Customer{" +
                "username='" + username + '\'' +
                ", product1='" + product1 + '\'' +
                ", product2='" + product2 + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", postalCode='" + postalCode + '\'' +
                '}';
    }
}
