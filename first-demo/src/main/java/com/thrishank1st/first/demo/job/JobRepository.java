package com.thrishank1st.first.demo.job;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, Long> { //entity type, id type
}
