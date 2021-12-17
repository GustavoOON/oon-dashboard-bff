package com.dashboardbff.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.math.BigInteger;

@JsonIgnoreProperties(ignoreUnknown = true)
public class UserResponse {
    private BigInteger id;
    private String name;
    private String email;
    private boolean readonly;
    private String disabled;
    private String phone;

    public UserResponse(@JsonProperty("id") BigInteger id,
                        @JsonProperty("name") String name,
                        @JsonProperty("email") String email,
                        @JsonProperty("readonly") boolean readonly,
                        @JsonProperty("disabled") String disabled,
                        @JsonProperty("phone") String phone) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.readonly = readonly;
        this.disabled = disabled;
        this.phone = phone;
    }

    public BigInteger getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public boolean getReadonly() {
        return readonly;
    }

    public String getDisabled() {
        return disabled;
    }

    public String getPhone() {

        return phone;
    }
}
