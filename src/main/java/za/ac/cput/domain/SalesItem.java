package za.ac.cput.domain;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class SalesItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String salesItemID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesID")
    private Sales sales;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "itemID")
    public Product product;
    private int quantity;
    private double itemPrice;

    public SalesItem() {
    }

    private SalesItem(Builder b){
        this.salesItemID = b.salesItemID;
        this.sales = b.sales;
        this.product = b.product;
        this.quantity = b.quantity;
        this.itemPrice = b.itemPrice;
    }

    public String getSalesItemID() {
        return salesItemID;
    }

    public Sales getSales() {
        return sales;
    }

    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesItem salesItem = (SalesItem) o;
        return quantity == salesItem.quantity && Double.compare(salesItem.itemPrice, itemPrice) == 0 && Objects.equals(salesItemID, salesItem.salesItemID) && Objects.equals(sales, salesItem.sales) && Objects.equals(product, salesItem.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesItemID, sales, product, quantity, itemPrice);
    }

    @Override
    public String toString() {
        return "SalesItem{" +
                "salesItemID='" + salesItemID + '\'' +
                ", sales=" + sales +
                ", product=" + product +
                ", quantity=" + quantity +
                ", itemPrice=" + itemPrice +
                '}';
    }

    public static class Builder {
        private String salesItemID;
        private Sales sales;
        public Product product;
        private int quantity;
        private double itemPrice;

        public Builder setSalesItemID(String salesItemID) {
            this.salesItemID = salesItemID;
            return this;
        }

        public Builder setSales(Sales sales) {
            this.sales = sales;
            return this;
        }

        public Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder setQuantity(int quantity) {
            this.quantity = quantity;
            return this;
        }

        public Builder setItemPrice(double itemPrice) {
            this.itemPrice = itemPrice;
            return this;
        }

        public Builder copy(SalesItem salesItem){
            this.salesItemID = salesItem.salesItemID;
            this.sales = salesItem.sales;
            this.product = salesItem.product;
            this.quantity = salesItem.quantity;
            this.itemPrice = salesItem.itemPrice;
            return this;
        }

        public SalesItem build(){return new SalesItem(this);}
    }
}
