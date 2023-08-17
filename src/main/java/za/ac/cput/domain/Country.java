package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;
@Entity
public class Country implements Serializable {
    @Id
    @Column(name = "countryid")
    public String ID;
    public String countryName;

    public Country() {
    }

   /* public Country(String ID, String countryName) {
        this.ID = ID;
        this.countryName = countryName;
    }
*/
    public String getID() {
        return ID;
    }

    public String getCountryName() {
        return countryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Country country)) return false;
        return Objects.equals(getID(), country.getID()) && Objects.equals(getCountryName(), country.getCountryName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCountryName());
    }

    @Override
    public String toString() {
        return "Country{" +
                "ID='" + ID + '\'' +
                ", countryName='" + countryName + '\'' +
                '}';
    }

    private Country(Country.Builder builder) {
        this.ID = builder.ID;
        this.countryName = builder.countryName;
    }

    public static class Builder {
        public String ID;
        public String countryName;

        public Builder setID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder setCountryName(String countryName) {
            this.countryName = countryName;
            return this;
        }

        public Country.Builder copy(Country country) {
            this.ID = country.ID;
            this.countryName = country.countryName;
            return this;
        }

        public Country build() {
            return new Country(this);
        }

    }

}
