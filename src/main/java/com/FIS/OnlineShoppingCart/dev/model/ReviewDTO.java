package com.FIS.OnlineShoppingCart.dev.model;

public class ReviewDTO {

    private int id;
    private String review;
    private int starNumber;
    private String reviewDate;
    private UserDTO userDTO;
    private ProductDTO productDTO;

    public ReviewDTO() {
        super();
        // TODO Auto-generated constructor stub
    }

    public ReviewDTO(int id, String review, int starNumber, String reviewDate, UserDTO userDTO,
                     ProductDTO productDTO) {
        super();
        this.id = id;
        this.review = review;
        this.starNumber = starNumber;
        this.reviewDate = reviewDate;
        this.userDTO = userDTO;
        this.productDTO = productDTO;
    }


    public String getReview() {
        return review;
    }
    public void setReview(String review) {
        this.review = review;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getStarNumber() {
        return starNumber;
    }
    public void setStarNumber(int startNumber) {
        this.starNumber = startNumber;
    }
    public String getReviewDate() {
        return reviewDate;
    }
    public void setReviewDate(String reviewDate) {
        this.reviewDate = reviewDate;
    }
    public UserDTO getUserDTO() {
        return userDTO;
    }
    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }
    public ProductDTO getProductDTO() {
        return productDTO;
    }
    public void setProductDTO(ProductDTO productDTO) {
        this.productDTO = productDTO;
    }


}

