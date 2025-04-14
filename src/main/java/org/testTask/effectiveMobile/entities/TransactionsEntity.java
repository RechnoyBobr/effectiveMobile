package org.testTask.effectiveMobile.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import java.util.UUID;
import java.sql.Date;

@Entity(name = "transactions")
public class TransactionsEntity {
    @Id
    private UUID id;

    @ManyToOne
    @JoinColumn(name = "transactions.card_from_id", nullable = false)
    private CardEntity cardFromId;

    @Column(nullable = true)
    private UUID cardToId;

    @Column(nullable = false)
    private UUID amount;

    @Column(nullable = false)
    private Date transactionDate;
}
