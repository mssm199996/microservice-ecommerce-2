package com.mssmfactory.microserviceexpeditions.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

@Entity
@Getter
@Setter
public class Expedition {

    @Id
    @GeneratedValue
    private Integer id;

    @NotNull
    private Integer commandId;

    @NotNull
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
