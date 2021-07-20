package com.techstart.rankingbatchservice.repository;

import com.techstart.rankingbatchservice.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category,Long> {
}
