package za.ac.cput.domain;

import java.util.Objects;

public class Address {
    public String unitNumber;
    public String complexName;
    public String streetNumber;
    public String streetName;
    public int postalCode;
    public City city;

    public String getUnitNumber() {
        return unitNumber;
    }

    public String getComplexName() {
        return complexName;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public String getStreetName() {
        return streetName;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public za.ac.cput.domain.City getCity() {
        return city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Address address)) return false;
        return getPostalCode() == address.getPostalCode() && Objects.equals(getUnitNumber(), address.getUnitNumber()) && Objects.equals(getComplexName(), address.getComplexName()) && Objects.equals(getStreetNumber(), address.getStreetNumber()) && Objects.equals(getStreetName(), address.getStreetName()) && Objects.equals(getCity(), address.getCity());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getUnitNumber(), getComplexName(), getStreetNumber(), getStreetName(), getPostalCode(), getCity());
    }

    @Override
    public String toString() {
        return "Address{" +
                "unitNumber='" + unitNumber + '\'' +
                ", complexName='" + complexName + '\'' +
                ", streetNumber='" + streetNumber + '\'' +
                ", streetName='" + streetName + '\'' +
                ", postalCode=" + postalCode +
                ", City=" + city +
                '}';
    }

    private Address(Address.Builder builder) {
        this.unitNumber = builder.unitNumber;
        this.complexName = builder.complexName;
        this.streetNumber = builder.streetNumber;
        this.streetName = builder.streetName;
        this.postalCode = builder.postalCode;
        this.city = builder.city;
    }

    public static class Builder {
        public String unitNumber;
        public String complexName;
        public String streetNumber;
        public String streetName;
        public int postalCode;
        public City city;

        public Builder setUnitNumber(String unitNumber) {
            this.unitNumber = unitNumber;
            return this;
        }

        public Builder setComplexName(String complexName) {
            this.complexName = complexName;
            return this;
        }

        public Builder setStreetNumber(String streetNumber) {
            this.streetNumber = streetNumber;
            return this;
        }

        public Builder setStreetName(String streetName) {
            this.streetName = streetName;
            return this;
        }

        public Builder setPostalCode(int postalCode) {
            this.postalCode = postalCode;
            return this;
        }

        public Builder setCity(za.ac.cput.domain.City city) {
            this.city = city;
            return this;
        }

        public Address.Builder copy(Address address) {
            this.unitNumber = address.unitNumber;
            this.complexName = address.complexName;
            this.streetNumber = address.streetNumber;
            this.streetName = address.streetName;
            this.postalCode = address.postalCode;
            this.city = address.city;
            return this;
        }

        public Address build() {
            return new Address(this);
        }

    }

}
