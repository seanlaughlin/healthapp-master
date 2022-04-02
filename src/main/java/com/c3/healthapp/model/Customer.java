package com.c3.healthapp.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Collection;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class Customer extends User {

    private Date dateOfBirth;
    private int height;
    private CustomerSex customerSex;
    private CustomerUnitsPreference customerUnitsPreference;

    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<Role> roles = new ArrayList<>();
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<HeartRateEntry> heartRateEntries = new ArrayList<>();
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    private Collection<WeightEntry> weightEntries = new ArrayList<>();

}