package org.bmp.vtb.entity;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(schema = "data", name = "status")
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

    public Status() {
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Office> getStatusesList() {
        return officesList;
    }

    public void setStatusesList(List<Office> statusesList) {
        this.officesList = statusesList;
    }

    @Override
    public String toString() {
        return "Status{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", statusesList=" + officesList +
                '}';
    }
}


