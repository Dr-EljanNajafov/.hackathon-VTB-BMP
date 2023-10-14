package org.bmp.vtb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "workload")
public class OfficeWorkload {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "workload_id")
    private long id;
    @OneToOne(mappedBy = "officeWorkload")
    private Office office;
    private int hour0, hour1, hour2, hour3, hour4, hour5, hour6, hour7, hour8, hour9, hour10, hour11, hour12, hour13,
            hour14, hour15, hour16, hour17, hour18, hour19, hour20, hour21, hour22, hour23;

    public OfficeWorkload(Office office) {
        this.office = office;
    }
}
