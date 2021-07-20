package com.techstart.productrankservice.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductRankResponse {
    Long productId;
    List<CategoryRank> categoryRanks;
}
