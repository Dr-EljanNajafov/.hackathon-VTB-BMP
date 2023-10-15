package org.bmp.vtb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bmp.vtb.entity.converter.OfficeStatusConverter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "office")
public class Office {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "office_id")
    private long id;
    private String name, address, city;
    private double latitude, longitude;
    @Column(name = "postal_code")
    private String postalCode;
    @Column(name = "working_hours")
    private String workingHours;
    @Convert(converter = OfficeStatusConverter.class)
    private Status status;
    @OneToOne
    @JoinTable(name = "office_filters", inverseJoinColumns = @JoinColumn(name = "office_id"))
    private Filters filters;
    @OneToOne
    @JoinTable(name = "workload", inverseJoinColumns = @JoinColumn(name = "office_id"))
    private OfficeWorkload officeWorkload;

    public Office(String name, String address, String city, double latitude, double longitude, String postalCode, String workingHours, Status status) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.latitude = latitude;
        this.longitude = longitude;
        this.postalCode = postalCode;
        this.workingHours = workingHours;
        this.status = status;
    }

    public boolean getFilterState(int filterId) {
        return switch (filterId) {
            case 1 -> this.filters.isRampHaving();
            case 2 -> this.filters.isCashReturn();
            case 3 -> this.filters.isPickupLocations();
            case 4 -> this.filters.isRetailAutoLending();
            default -> throw new IllegalStateException("Unexpected value: " + filterId);
        };
    }

    public enum Status {
        FREE(1), NORMAL(2), MEDIUM(3), HEAVY(4);

        private final int id;

        Status(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }

    public enum Filter {
        RAMP_HAVING(1), CASH_RETURN(2), PICKUP_LOCATIONS(3), RETAIL_AUTO_LENDING(4);

        private final int id;

        Filter(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }
    }
}