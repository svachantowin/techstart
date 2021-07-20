package com.techstart.rankingbatchservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;

@Getter @Setter
@Entity
public class SalesTransaction {
    Long productId;
    Long totalSales;
    Long successCount;
    Long returnCount;
}
