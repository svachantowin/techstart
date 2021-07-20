package com.techstart.rankingbatchservice.domain;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter @Setter
@Entity(name = "Category")
public class Category {
    @Id
    private Long id;
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name="id")
    private Product product;



}
