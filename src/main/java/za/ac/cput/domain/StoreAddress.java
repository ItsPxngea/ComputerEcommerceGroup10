package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class StoreAddress implements Serializable {
    @Id
    private String storeAddressID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressID")
    private Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "storeID")
    private StoreDetails storeDetails;

    public StoreAddress() {}
    private StoreAddress(Builder builder){
        this.storeAddressID = builder.storeAddressID;
        this.address = builder.address;
        this.storeDetails = builder.storeDetails;
    }

    public String getStoreAddressID() {return storeAddressID;}
    public Address getAddress() {return address;}
    public StoreDetails getStoreDetails() {return storeDetails;}

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreAddress that = (StoreAddress) o;
        return Objects.equals(storeAddressID, that.storeAddressID) && Objects.equals(address, that.address) && Objects.equals(storeDetails, that.storeDetails);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeAddressID, address, storeDetails);
    }

    @Override
    public String toString() {
        return "StoreAddress{" +
                "storeAddressID='" + storeAddressID + '\'' +
                ", address=" + address +
                ", storeDetails=" + storeDetails +
                '}';
    }

    public static class Builder {
        private String storeAddressID;
        private Address address;
        private StoreDetails storeDetails;

        public Builder setStoreAddressID(String storeAddressID) {
            this.storeAddressID = storeAddressID;
            return this;
        }
        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }
        public Builder setStoreDetails(StoreDetails storeDetails) {
            this.storeDetails = storeDetails;
            return this;
        }

        public Builder copy(StoreAddress storeAddress){
            this.storeAddressID = storeAddress.storeAddressID;
            this.address = storeAddress.address;
            this.storeDetails = storeAddress.storeDetails;
            return this;
        }

        public StoreAddress build(){
            return new StoreAddress(this);
        }

    }


}
