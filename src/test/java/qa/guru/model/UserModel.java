package qa.guru.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UserModel {
    private Integer id;
    private String name;
    private Integer age;
    private String email;
    private AddressModel address;
    private List<String> hobbies;
    @JsonProperty("is_active")
    private boolean isActive;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public AddressModel getAddress() {
        return address;
    }

    public List<String> getHobbies() {
        return hobbies;
    }

    public boolean isActive() {
        return isActive;
    }

    public static class AddressModel {
        private String street;
        private String city;
        private String state;
        private String zipcode;

        public String getStreet() {
            return street;
        }

        public String getCity() {
            return city;
        }

        public String getState() {
            return state;
        }

        public String getZipcode() {
            return zipcode;
        }
    }

}
