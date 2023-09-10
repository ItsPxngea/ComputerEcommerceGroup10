package za.ac.cput.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.domain.Review;
import za.ac.cput.repository.ReviewRepository;
import za.ac.cput.service.ReviewService;

import java.util.List;

@Service
public class ReviewServiceImpl implements ReviewService {

    private ReviewRepository repository;

    @Autowired
    private ReviewServiceImpl(ReviewRepository repository){
        this.repository = repository;
    }
    @Override
    public Review create(Review review) {
        return this.repository.save(review);
    }

    @Override
    public Review read(String reviewID) {
        return this.repository.findById(reviewID).orElse(null);
    }

    @Override
    public Review update(Review review) {
        if(this.repository.existsById(review.getReviewID()))
            return this.repository.save(review);
        return null;
    }

    @Override
    public boolean delete(String id) {
        if(this.repository.existsById(id)){
            this.repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public List<Review> getAll() {
        return this.repository.findAll();
    }

}
