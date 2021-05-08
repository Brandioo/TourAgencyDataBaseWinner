package com.internet.base.application.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tour")
@NoArgsConstructor
@Builder
@Data
public class Tour {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private int days;
    private int maxPeople;
    private int minPeople;
    private String description;
    private String departure;
    private String photo;
    private boolean featured;
    @Enumerated(EnumType.STRING)
    private TravelType travelType;
    private int price;
    private int quantity;
    private Date createdAt;


    @ManyToOne
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    @JoinColumn(name = "destinationId", insertable = false, updatable = false)
    private Destination destination;
    private int destinationId;

}

