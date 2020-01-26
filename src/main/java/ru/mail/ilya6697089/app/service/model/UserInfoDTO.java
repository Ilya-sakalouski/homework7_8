package ru.mail.ilya6697089.app.service.model;

public class UserInfoDTO {

    private int id;
    private String address;
    private String telephone;

    private UserInfoDTO(Builder builder) {
        id = builder.id;
        setAddress(builder.address);
        setTelephone(builder.telephone);
    }

    public static Builder newBuilder() {
        return new Builder();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public int getId() {
        return id;
    }

    public String getAddress() {
        return address;
    }

    public String getTelephone() {
        return telephone;
    }

    public static final class Builder {

        private String address;
        private String telephone;
        private int id;

        private Builder() {}

        public Builder address(String val) {
            address = val;
            return this;
        }

        public Builder telephone(String val) {
            telephone = val;
            return this;
        }

        public UserInfoDTO build() {
            return new UserInfoDTO(this);
        }

        public Builder id(int val) {
            id = val;
            return this;
        }

    }

    @Override
    public String toString() {
        return "User info (DTO): " +
                "address='" + address +
                ", telephone='" + telephone;
    }

}
