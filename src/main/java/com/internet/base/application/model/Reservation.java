package com.internet.base.application.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "reservation")
@NoArgsConstructor
@Builder
@Data
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int finalPrice;
    private String comment;
    private Date checkInDate;
    private Date checkOutDate;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "tourId", insertable = false, updatable = false)
    private Tour tour;
    private long tourId;

    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "clientId", insertable = false, updatable = false)
    private Client client;
    private long clientId;

}
