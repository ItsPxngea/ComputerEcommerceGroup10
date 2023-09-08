package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class SupplierAddress implements Serializable {
    @Id
    private String supplierAddressID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressID")
    public Address address;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "supplierid")
    private Supplier supplier;

    private SupplierAddress(Builder builder){
        this.supplierAddressID = builder.supplierAddressID;
        this.address = builder.address;
        this.supplier = builder.supplier;
    }

    public SupplierAddress() {
    }

    public String getSupplierAddressID() {
        return supplierAddressID;
    }

    public Address getAddress() {
        return address;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SupplierAddress that)) return false;
        return Objects.equals(getSupplierAddressID(), that.getSupplierAddressID()) && Objects.equals(getAddress(), that.getAddress()) && Objects.equals(getSupplier(), that.getSupplier());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSupplierAddressID(), getAddress(), getSupplier());
    }

    @Override
    public String toString() {
        return "SupplierAddress{" +
                "supplierAddressID='" + supplierAddressID + '\'' +
                ", address=" + address +
                ", supplier=" + supplier +
                '}';
    }

    public static class Builder{
        private String supplierAddressID;
        private Address address;
        private Supplier supplier;

        public Builder setSupplierAddressID(String supplierAddressID) {
            this.supplierAddressID = supplierAddressID;
            return this;
        }

        public Builder setAddress(Address address) {
            this.address = address;
            return this;
        }

        public Builder setSupplier(Supplier supplier) {
            this.supplier = supplier;
            return this;
        }

        public Builder copy (SupplierAddress supplierAddress){
            this.supplierAddressID = supplierAddress.supplierAddressID;
            this.address = supplierAddress.address;
            this.supplier = supplierAddress.supplier;
            return this;
        }

        public SupplierAddress build(){return new SupplierAddress(this);}

    }
}
