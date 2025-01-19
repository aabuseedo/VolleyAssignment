package com.example.volleyassignment;

public class User {
    private int id;
    private String name;
    private String username;
    private String email;
    private String address;
    private String phone;
    private String website;
    private String companyName;
    private String catchPhrase;
    private String bs;

    public User(int id, String name, String username, String email, String address, String phone, String website, String companyName, String catchPhrase, String bs) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.email = email;
        this.address = address;
        this.phone = phone;
        this.website = website;
        this.companyName = companyName;
        this.catchPhrase = catchPhrase;
        this.bs = bs;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getEmail() {
        return email;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getWebsite() {
        return website;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getCatchPhrase() {
        return catchPhrase;
    }

    public String getBs() {
        return bs;
    }
}
