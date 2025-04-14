-- liquibase formatted sql


--changeset author:1
CREATE TABLE "cards" (
                         "card_number" uuid NOT NULL,
                         "owner_name" varchar(100) NOT NULL,
                         "expiration" date NOT NULL,
    -- A - active
    -- B - blocked
    -- E - expired
                         "status" char(1) NOT NULL,
                         "balance" double precision NOT NULL,
                         PRIMARY KEY ("card_number")
);

COMMENT ON COLUMN "cards"."status" IS 'A - active
B - blocked
E - expired';

CREATE TABLE "transactions" (
                                "transaction_id" uuid NOT NULL,
                                "card_from_id" uuid NOT NULL,
                                "card_to_id" uuid,
                                "amount" double precision,
                                "date" date,
                                PRIMARY KEY ("transaction_id")
);



CREATE TABLE "limits" (
                          "card_id" uuid NOT NULL,
                          "limit" double precision NOT NULL,
    -- Changes after every transaction
                          "current_limit" double precision NOT NULL,
                          "limit_duration" integer NOT NULL,
                          PRIMARY KEY ("card_id")
);

COMMENT ON COLUMN "limits"."current_limit" IS 'Changes after every transaction';


ALTER TABLE "cards"
    ADD CONSTRAINT "fk_cards_card_number_limits_card_id" FOREIGN KEY("card_number") REFERENCES "limits"("card_id");
