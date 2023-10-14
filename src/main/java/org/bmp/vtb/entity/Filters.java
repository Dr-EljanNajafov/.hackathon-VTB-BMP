package org.bmp.vtb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "office_filters")
public class Filters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filters_id")
    private long id;
    @Column(name = "ramp_having")
    private boolean rampHaving;
    @Column(name = "cash_return")
    private boolean cashReturn;
    @Column(name = "pickup_locations")
    private boolean pickupLocations;
    @Column(name = "retail_auto_lending")
    private boolean retailAutoLending;
    @OneToOne(mappedBy = "filters")
    @JoinColumn(name = "office_id")
    private Office office;

    public Filters(boolean rampHaving, boolean cashReturn, boolean pickupLocations, boolean retailAutoLending, Office office) {
        this.rampHaving = rampHaving;
        this.cashReturn = cashReturn;
        this.pickupLocations = pickupLocations;
        this.retailAutoLending = retailAutoLending;
        this.office = office;
    }
}