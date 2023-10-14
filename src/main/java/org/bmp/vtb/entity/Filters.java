package org.bmp.vtb.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "data", name = "office_filters")
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

    public Filters() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isRamp_having() {
        return ramp_having;
    }

    public void setRamp_having(boolean ramp_having) {
        this.ramp_having = ramp_having;
    }

    public boolean isCash_return() {
        return cash_return;
    }

    public void setCash_return(boolean cash_return) {
        this.cash_return = cash_return;
    }

    public boolean isPickup_locations() {
        return pickup_locations;
    }

    public void setPickup_locations(boolean pickup_locations) {
        this.pickup_locations = pickup_locations;
    }

    public boolean isRetail_auto_lending() {
        return retail_auto_lending;
    }

    public void setRetail_auto_lending(boolean retail_auto_lending) {
        this.retail_auto_lending = retail_auto_lending;
    }

    public List<Office> getOfficesList() {
        return officesList;
    }

    public void setOfficesList(List<Office> officesList) {
        this.officesList = officesList;
    }

    @Override
    public String toString() {
        return "Filters{" +
                "id=" + id +
                ", ramp_having=" + ramp_having +
                ", cash_return=" + cash_return +
                ", pickup_locations=" + pickup_locations +
                ", retail_auto_lending=" + retail_auto_lending +
                ", officesList=" + officesList +
                '}';
    }
}


