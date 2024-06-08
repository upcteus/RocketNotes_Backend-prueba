package com.fivestars.rocketnotes.profiles.domain.model.valueobjects;

import jakarta.persistence.Embeddable;


@Embeddable
public record EmailAddress(@Email String address) {
    public EmailAddress() {
        this(null);
    }
}