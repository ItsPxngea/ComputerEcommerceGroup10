package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
import java.util.stream.Collectors;

@Entity
public class SalesItem implements Serializable {

    @Id
    private String salesItemID;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "salesID")
    Sales sales;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "sales_item_products",
            joinColumns = @JoinColumn(name = "sales_item_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id")
    )
    private List<Product> products = new ArrayList<>();
    private int quantity;
    private double itemPrice;

    public SalesItem() {
    }

    private SalesItem(Builder b){
        this.salesItemID = b.salesItemID;
        this.sales = b.sales;
        this.products = b.products;
        this.quantity = b.quantity;
        this.itemPrice = b.itemPrice;
    }

    public String getSalesItemID() {
        return salesItemID;
    }

    public Sales getSales() {
        return sales;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getItemPrice() {
        return itemPrice;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void addProducts(List<Product> products) {
        this.products.addAll(products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SalesItem salesItem = (SalesItem) o;
        return quantity == salesItem.quantity && Double.compare(salesItem.itemPrice, itemPrice) == 0 && Objects.equals(salesItemID, salesItem.salesItemID) && Objects.equals(sales, salesItem.sales) && Objects.equals(products, salesItem.products);
    }

    @Override
    public int hashCode() {
        return Objects.hash(salesItemID, sales, products, quantity, itemPrice);
    }

    @Override
    public String toString() {

        String productIds = products.stream()
                .map(Product::getProductID)
                .collect(Collectors.joining(", "));

        return "SalesItem{" +
                "salesItemID='" + salesItemID + '\'' +
                ", itemPrice=" + itemPrice +
                ", quantity=" + quantity +
                ", productIDs=" + productIds +
                '}';
    }

    public static class Builder {
        private String salesItemID;
        @JoinColumn(name = "sales_id")
        private Sales sales;
        @JoinColumn(name = "product_id")
        private List<Product> products = new ArrayList<>();
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

        public Builder addProduct(Product product) {
            this.products.add(product);
            return this;
        }

        public Builder setProducts(List<Product> products) {
            this.products = products;
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
            this.products = salesItem.products;
            this.quantity = salesItem.quantity;
            this.itemPrice = salesItem.itemPrice;
            return this;
        }

        public SalesItem build(){return new SalesItem(this);}
    }
}
