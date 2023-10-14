package org.bmp.vtb.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@Entity
@Table(name = "status")
public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "status_id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "status_id")
    private List<Office> officesList;

    public Status(String name, String description, List<Office> statusesList) {
        this.name = name;
        this.description = description;
        this.officesList = statusesList;
    }

    public void addProductToCategories(Office offices) {
        if (officesList == null) {
            officesList = new ArrayList<>();
        }

        officesList.add(offices);
    }
}