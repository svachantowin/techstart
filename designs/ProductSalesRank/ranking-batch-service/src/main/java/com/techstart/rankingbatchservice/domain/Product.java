package com.techstart.rankingbatchservice.domain;



import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity(name = "Product")
public class Product {
    @Id
    private Long id;
    private String name;
    private String description;

    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true,mappedBy = "product")
    private Set<Category> categorySet;

}
