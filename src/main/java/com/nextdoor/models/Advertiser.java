package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.api.response.NextDoorModel;

import java.io.Serializable;
import java.util.List;

public class Advertiser extends NextDoorModel implements Serializable {
    @JsonProperty("id")
    public String id;

    @JsonProperty("profile_id")
    public String profileId;

    @JsonProperty("name")
    public String advertiserName;

    @JsonProperty("website_url")
    public String websiteUrl;

    @JsonProperty("categories")
    public List<String> categories;

    @JsonProperty("address")
    public Address address;

    @JsonProperty("billing_limit")
    public String billingLimit;

    @JsonProperty("payment_profile_id")
    public String paymentProfileId;

    @JsonProperty("bill_to_payment_profile_id")
    public String billToPaymentProfileId;

    @JsonProperty("account_balance")
    public String accountBalance;

    public Advertiser() {

    }

    public Advertiser(String id, String profileId, String advertiserName, String websiteUrl, List<String> categories, Address address, String billingLimit, String paymentProfileId, String billToPaymentProfileId, String accountBalance) {
        this.id = id;
        this.profileId = profileId;
        this.advertiserName = advertiserName;
        this.websiteUrl = websiteUrl;
        this.categories = categories;
        this.address = address;
        this.billingLimit = billingLimit;
        this.paymentProfileId = paymentProfileId;
        this.billToPaymentProfileId = billToPaymentProfileId;
        this.accountBalance = accountBalance;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProfileId() {
        return profileId;
    }

    public void setProfileId(String profileId) {
        this.profileId = profileId;
    }

    public String getAdvertiserName() {
        return advertiserName;
    }

    public void setAdvertiserName(String advertiserName) {
        this.advertiserName = advertiserName;
    }

    public String getWebsiteUrl() {
        return websiteUrl;
    }

    public void setWebsiteUrl(String websiteUrl) {
        this.websiteUrl = websiteUrl;
    }

    public List<String> getCategories() {
        return categories;
    }

    public void setCategories(List<String> categories) {
        this.categories = categories;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getBillingLimit() {
        return billingLimit;
    }

    public void setBillingLimit(String billingLimit) {
        this.billingLimit = billingLimit;
    }

    public String getPaymentProfileId() {
        return paymentProfileId;
    }

    public void setPaymentProfileId(String paymentProfileId) {
        this.paymentProfileId = paymentProfileId;
    }

    public String getBillToPaymentProfileId() {
        return billToPaymentProfileId;
    }

    public void setBillToPaymentProfileId(String billToPaymentProfileId) {
        this.billToPaymentProfileId = billToPaymentProfileId;
    }

    public String getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(String accountBalance) {
        this.accountBalance = accountBalance;
    }

    public static class Address {
        @JsonProperty("street_address")
        public String streetAddress;

        @JsonProperty("street_address_2")
        public String streetAddress2;

        @JsonProperty("city")
        public String city;

        @JsonProperty("state")
        public String state;

        @JsonProperty("postal_code")
        public String postalCode;

        @JsonProperty("country")
        public String country;

        public Address() {

        }

        public Address(String streetAddress, String streetAddress2, String city, String state, String postalCode, String country) {
            this.streetAddress = streetAddress;
            this.streetAddress2 = streetAddress2;
            this.city = city;
            this.state = state;
            this.postalCode = postalCode;
            this.country = country;
        }

        public String getStreetAddress() {
            return streetAddress;
        }

        public void setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
        }

        public String getStreetAddress2() {
            return streetAddress2;
        }

        public void setStreetAddress2(String streetAddress2) {
            this.streetAddress2 = streetAddress2;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getState() {
            return state;
        }

        public void setState(String state) {
            this.state = state;
        }

        public String getPostalCode() {
            return postalCode;
        }

        public void setPostalCode(String postalCode) {
            this.postalCode = postalCode;
        }

        public String getCountry() {
            return country;
        }

        public void setCountry(String country) {
            this.country = country;
        }
    }
}
