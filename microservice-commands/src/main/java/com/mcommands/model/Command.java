package com.mcommands.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Command {

    @Id
    @GeneratedValue
    private int id;
    private Integer productId, quantity;

    private Boolean payed;

    private LocalDate date;
}
