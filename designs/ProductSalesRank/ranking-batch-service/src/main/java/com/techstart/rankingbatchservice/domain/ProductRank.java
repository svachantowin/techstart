package com.techstart.rankingbatchservice.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

@Getter @Setter
@Entity
@Table(name = "ProductRank")
public class ProductRank {

    @EmbeddedId
    private ProductRankID id;

    private Long rank;

    private Long totalSales;



}
