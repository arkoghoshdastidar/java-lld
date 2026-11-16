package com.LibraryManagementSystem.datatypes;

public class Address {
    public String streetAddress;
    public String city;
    public String state;
    public int zipCode;
    public String country;

    private Address(String streetAddress, String city, String state, int zipCode, String country) {
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.country = country;
    }

    public static class Builder {
        private String streetAddress;
        private String city;
        private String state;
        private int zipCode;
        private String country;

        public Builder Builder(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setCity(String city) {
            this.city = city;
            return this;
        }

        public Builder setState(String state) {
            this.state = state;
            return this;
        }

        public Builder setZipCode(int zipCode) {
            this.zipCode = zipCode;
            return this;
        }

        public Builder setCountry(String country) {
            this.country = country;
            return this;
        }

        public Address build() {
            return new Address(streetAddress, city, state, zipCode, country);
        }
    }
}