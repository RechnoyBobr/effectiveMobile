package org.testTask.effectiveMobile.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

@Entity(name = "limits")
public class LimitsEntity {
    @Id
    @OneToOne(optional = false)
    @JoinColumn(name = "card_id", nullable = false)
    private CardEntity cardEntity;

    @Column
    private Double cardLimit;

    @Column
    private Double currentLimit;

    @Column
    private Integer limitDuration;

}
