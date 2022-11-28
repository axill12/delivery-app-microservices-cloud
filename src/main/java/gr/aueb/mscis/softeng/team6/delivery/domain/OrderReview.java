package gr.aueb.mscis.softeng.team6.delivery.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

/**
 * Order review entity.
 *
 * @since 0.1.0
 */
@Entity
@Table(name = "order_review")
public class OrderReview extends Review {
  /** Optional comment field. */
  @Column(length = 1000)
  private String comment;

  /** Order relation field. */
  @OneToOne(fetch = FetchType.LAZY, optional = false)
  protected Order order;

  /** Product reviews relation field. */
  @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent", orphanRemoval = true)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private List<ProductReview> productReviews = new ArrayList<>();

  public String getComment() {
    return comment;
  }

  public OrderReview setComment(String comment) {
    this.comment = comment;
    return this;
  }

  public Order getOrder() {
    return order;
  }

  public OrderReview setOrder(Order order) {
    this.order = order;
    return this;
  }

  @Override
  public OrderReview setRating(Short rating) {
    this.rating = rating;
    return this;
  }

  public List<ProductReview> getProductReviews() {
    return productReviews;
  }

  public OrderReview setProductReviews(List<ProductReview> productReviews) {
    this.productReviews = productReviews;
    return this;
  }

  /**
   * Add a product review to the order review.
   *
   * @param product the product to be reviewed.
   * @param rating the rating of the product.
   */
  public void addProductReview(OrderProduct product, short rating) {
    var review = new ProductReview().setParent(this).setProduct(product).setRating(rating);
    productReviews.add(review);
  }

  @Override
  public String toString() {
    return String.format(
        "OrderReview{order=\"%s\", rating=%d, comment=\"%s\"}", order.getUuid(), rating, comment);
  }
}
