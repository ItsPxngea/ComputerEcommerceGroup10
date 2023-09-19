package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Entity
public class Review implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // or other strategy
    public Long reviewID;

    private int rating;
    @ManyToOne
    @JoinColumn(name = "customerID")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "productID")
    private Product product;

    public Review(){

    }
    private Review(Builder b) {
        this.reviewID = b.reviewID;
        this.rating = b.rating;
        this.customer = b.customer;
        this.product = b.product;
    }


    public Long getReviewID() {
        return reviewID;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Product getProduct() {
        return product;
    }

    public int getRating() {
        return rating;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return Objects.equals(reviewID, review.reviewID) && Objects.equals(rating, review.rating) && Objects.equals(product, review.product) && Objects.equals(customer, review.customer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewID, rating, product, customer);
    }


    @Override
    public String toString() {

        return "Review{" +
                "reviewID='" + reviewID + '\'' +
                ", customer='" + customer + '\'' +
                ", product='" + product + '\'' +
                ", rating=" + rating +
                '}';
    }

    public static class Builder {
        public Long reviewID;
        private int rating;
        private Customer customer;
        private Product product;


        public Builder setReviewID(Long reviewID){
            this.reviewID = reviewID;
            return this;
        }

        public Builder setRating(int rating){
            this.rating = rating;
            return this;
        }

        public Builder setCustomer(Customer customer){
            this.customer = customer;
            return this;
        }

        public Review.Builder setProduct(Product product) {
            this.product = product;
            return this;
        }

        public Builder copy(Review review){
            this.reviewID = review.reviewID;
            this.rating = review.rating;
            this.customer = review.customer;
            this.product = review.product;

            return this;
        }

        public Review build(){
            return new Review(this);
        }
    }
}

