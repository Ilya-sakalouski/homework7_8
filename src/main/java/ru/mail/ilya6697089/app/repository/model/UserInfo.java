package ru.mail.ilya6697089.app.repository.model;

public class UserInfo {

    private Integer id;
    private String address;
    private String telephone;

    public Integer getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    private UserInfo(Builder builder) {
        id = builder.id;
        address = builder.address;
        telephone = builder.telephone;
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public static final class Builder {

        private Integer id;
        private String address;
        private String telephone;

        private Builder() {}

        public Builder id(Integer val) {
            id = val;
            return this;
        }

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder telephone(String val) {
            telephone = val;
            return this;
        }

        public UserInfo build() {
            return new UserInfo(this);
        }

    }

    @Override
    public String toString() {
        return id + " "
                + address + " "
                + telephone;
    }

}
