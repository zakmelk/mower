package com.moweritnow.model;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@Slf4j
@AllArgsConstructor
public class Task {
    private Mower mower;
    private List<OrderEnum> orders;

    public Mower executeOrders(Lawn lawn) {
        for (OrderEnum order : orders) {
            if (mower.isValidOrder(lawn,order)) {
                mower.executeOrder(order);
            } else {
                log.warn("Order {} is not valid for mower:{} and lawn:{}, skipping !", order, mower,lawn);
            }
        }
        return mower;
    }
}
