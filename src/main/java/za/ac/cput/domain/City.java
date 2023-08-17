package za.ac.cput.domain;

import java.util.Objects;

public class City {
    public String ID;
    public String cityName;
    public Country country;

    public String getID() {
        return ID;
    }

    public String getCityName() {
        return cityName;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof City city)) return false;
        return Objects.equals(getID(), city.getID()) && Objects.equals(getCityName(), city.getCityName()) && Objects.equals(getCountry(), city.getCountry());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getID(), getCityName(), getCountry());
    }

    @Override
    public String toString() {
        return "City{" +
                "ID='" + ID + '\'' +
                ", cityName='" + cityName + '\'' +
                ", country=" + country +
                '}';
    }

    private City(City.Builder builder) {
        this.ID = builder.ID;
        this.cityName = builder.cityName;
        this.country = builder.country;
    }

    public static class Builder {
        public String ID;
        public String cityName;
        public Country country;

        public Builder setID(String ID) {
            this.ID = ID;
            return this;
        }

        public Builder setCityName(String cityName) {
            this.cityName = cityName;
            return this;
        }

        public Builder setCountry(Country country) {
            this.country = country;
            return this;
        }

        public City.Builder copy(City city) {
            this.ID = city.ID;
            this.cityName = city.cityName;
            this.country = city.country;
            return this;
        }

        public City build() {
            return new City(this);
        }

    }

}
