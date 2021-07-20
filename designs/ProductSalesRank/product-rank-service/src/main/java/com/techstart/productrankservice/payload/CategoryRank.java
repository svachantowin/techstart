package com.techstart.productrankservice.payload;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class CategoryRank {
    Long categoryId;
    Long rank;
}
