package org.zerock.j2.repositoryTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.zerock.j2.entity.Product;
import org.zerock.j2.entity.ProductReview;
import org.zerock.j2.repository.ProductReviewRepository;

@SpringBootTest
public class ReviewTests {
  
  @Autowired
  ProductReviewRepository repository;

  @Test
  public void insertReview() {

    Long[] pnoArr = {200L, 195L, 190L, 185L};

    for (Long pno : pnoArr) {

      int score = (int)(Math.random() * 5) +1 ;
      
      Product product = Product.builder().pno(pno).build();

      for (int i = 0; i< 10; i++) {

        ProductReview review = ProductReview.builder()
        .content("cccccccc")
        .reviewer("user"+i)
        .score(score)
        .product(product)
        .build();

        repository.save(review);

      }//end for

    }//end for

  }//end test

}
