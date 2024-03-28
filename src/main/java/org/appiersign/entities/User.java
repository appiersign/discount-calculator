package org.appiersign.entities;

import org.appiersign.enums.EUserType;

import java.time.LocalDate;
import java.util.List;

public class User {
    private Long id;
    private String name;
    private EUserType type;
    private LocalDate createdAt;

    public User(Long id, String name, EUserType type, LocalDate createdAt) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.createdAt = createdAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EUserType getType() {
        return type;
    }

    public void setType(EUserType type) {
        this.type = type;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public boolean hasPercentageDiscount() {

        return List.of(EUserType.EMPLOYEE, EUserType.AFFILIATE).contains(getType());
    }

    public boolean qualifiesForTwoYearsDiscount() {
        return getCreatedAt().plusYears(2).isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}
