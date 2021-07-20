package com.techstart.rankingbatchservice.external;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class SalesFeed {
    Long productId;
    Long transactionCount;
    SalesEventType eventType;

}
