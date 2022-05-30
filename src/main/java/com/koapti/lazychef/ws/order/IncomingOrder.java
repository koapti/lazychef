package com.koapti.lazychef.ws.order;

import lombok.Getter;

import java.util.List;

@Getter
public class IncomingOrder {
    private Integer tableNr;
    private List<Integer> foodIds;
}
