package org.testTask.effectiveMobile.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import java.util.UUID;
import java.sql.Date;

@Entity(name = "cards")
public class CardEntity {
    @Id
    @GeneratedValue
    private UUID id;

    @Column(nullable = false)
    private String owner_name;

    @Column(nullable = false)
    private Date expiration;

    @Column(nullable = false)
    private Double balance;
}
