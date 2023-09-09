package za.ac.cput.domain;
/*
Author: Hanno Visser Immelman 221074414
*/
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Objects;
@Entity
public class StoreDetails implements Serializable {
    @Id
    private String storeID;
    private String storeName;
    private String storeAddress;
    private String storeTel;
    private String storeEmail;

    public StoreDetails() {
    }

    public String getStoreID() {
        return storeID;
    }

    public String getStoreName() {
        return storeName;
    }

    public String getStoreAddress() {
        return storeAddress;
    }

    public String getStoreTel() {
        return storeTel;
    }

    public String getStoreEmail() {
        return storeEmail;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreDetails that = (StoreDetails) o;
        return Objects.equals(storeID, that.storeID) && Objects.equals(storeName, that.storeName) && Objects.equals(storeAddress, that.storeAddress) && Objects.equals(storeTel, that.storeTel) && Objects.equals(storeEmail, that.storeEmail);
    }

    @Override
    public int hashCode() {
        return Objects.hash(storeID, storeName, storeAddress, storeTel, storeEmail);
    }

    @Override
    public String toString() {
        return "StoreDetails{" +
                "storeID='" + storeID + '\'' +
                ", storeName='" + storeName + '\'' +
                ", storeAddress='" + storeAddress + '\'' +
                ", storeTel='" + storeTel + '\'' +
                ", storeEmail='" + storeEmail + '\'' +
                '}';
    }

    private StoreDetails(Builder b){
        this.storeID = b.storeID;
        this.storeName = b.storeName;
        this.storeAddress = b.storeAddress;
        this.storeTel = b.storeTel;
        this.storeEmail = b.storeEmail;
    }
    public static class Builder {
        private String storeID;
        private String storeName;
        private String storeAddress;
        private String storeTel;
        private String storeEmail;

        public Builder setStoreID(String storeID){
            this.storeID = storeID;
            return this;
        }

        public Builder setStoreName(String storeName){
            this.storeName = storeName;
            return this;
        }

        public Builder setStoreAddress(String storeAddress){
            this.storeAddress = storeAddress;
            return this;
        }

        public Builder setStoreTel(String storeTel){
            this.storeID = storeID;
            return this;
        }

        public Builder setStoreEmail(String storeEmail){
            this.storeEmail = storeEmail;
            return this;
        }

        public Builder copy(StoreDetails storeDetails){
            this.storeID = storeDetails.storeID;
            this.storeName = storeDetails.storeName;
            this.storeAddress = storeDetails.storeAddress;
            this.storeTel = storeDetails.storeTel;
            this.storeEmail = storeDetails.storeEmail;
            return this;
        }

        public StoreDetails build(){
            return new StoreDetails(this);
        }
    }
}
