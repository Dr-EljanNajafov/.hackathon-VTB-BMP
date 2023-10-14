package org.bmp.vtb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "office_filters")
public class Filters {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "filters_id")
    private int id;

    @Column(name = "ramp_having")
    private boolean ramp_having;

    @Column(name = "cash_return")
    private boolean cash_return;

    @Column(name = "pickup_locations")
    private boolean pickup_locations;

    @Column(name = "retail_auto_lending")
    private boolean retail_auto_lending;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "filters_id")
    private List<Office> officesList;

    public Filters(boolean ramp_having, boolean cash_return, boolean pickup_locations, boolean retail_auto_lending, List<Office> officesList) {
        this.ramp_having = ramp_having;
        this.cash_return = cash_return;
        this.pickup_locations = pickup_locations;
        this.retail_auto_lending = retail_auto_lending;
        this.officesList = officesList;
    }

    public void addProductToCategories(Office offices) {
        if (officesList == null) {
            officesList = new ArrayList<>();
        }

        officesList.add(offices);
    }
}


