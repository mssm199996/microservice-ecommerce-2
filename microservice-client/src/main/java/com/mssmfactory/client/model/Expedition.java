package com.mssmfactory.client.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
public class Expedition {

    private Integer id;
    private Integer commandId;
    private ExpeditionState expeditionState;

    @Getter
    @ToString
    public static enum ExpeditionState {
        UNDER_PREPARATION("Under preparation"),
        SHIPPED("Shipped"),
        DELIVERED("Delivered");

        private String designation;

        ExpeditionState(String designation) {
            this.designation = designation;
        }
    }
}
