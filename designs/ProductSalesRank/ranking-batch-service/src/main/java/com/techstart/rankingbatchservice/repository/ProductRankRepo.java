package com.techstart.rankingbatchservice.repository;



import com.techstart.rankingbatchservice.domain.ProductRank;
import com.techstart.rankingbatchservice.domain.ProductRankID;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRankRepo extends PagingAndSortingRepository<ProductRank, ProductRankID> {
}
