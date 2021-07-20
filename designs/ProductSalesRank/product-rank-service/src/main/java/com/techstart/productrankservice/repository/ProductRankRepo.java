package com.techstart.productrankservice.repository;


import com.techstart.productrankservice.domain.ProductRank;
import com.techstart.productrankservice.domain.ProductRankID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRankRepo extends PagingAndSortingRepository<ProductRank, ProductRankID> {
}
