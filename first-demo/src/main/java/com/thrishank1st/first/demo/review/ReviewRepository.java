package com.thrishank1st.first.demo.review;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    List<Review> findByCompanyId(Long companyId); // no need to implement this manually it generates the method run time with help of jpaRepository(it identify 'findBy'-> 'companyId' )
}
