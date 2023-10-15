package org.bmp.vtb.model;

import org.bmp.vtb.dto.Office;
import org.bmp.vtb.model.algorithms.SearchOffice;
import org.bmp.vtb.repository.OfficeRepository;
import org.bmp.vtb.utilites.GeographicUtils;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OfficeModel {
    private final OfficeRepository officeRepository;
    private final GeographicUtils geographicUtils;

    public OfficeModel(OfficeRepository officeRepository, GeographicUtils geographicUtils) {
        this.officeRepository = officeRepository;
        this.geographicUtils = geographicUtils;
    }

    public Office nearby(double latitude, double longitude, int radius, String filters) {
        SearchOffice searchOffice = new SearchOffice(officeRepository, geographicUtils, latitude, longitude, radius, filters == null ? "" : filters);
        return new Office(searchOffice.getOffice());
    }

    public List<Office> fullNearby(double latitude, double longitude, int radius, String filters) {
        SearchOffice searchOffice = new SearchOffice(officeRepository, geographicUtils, latitude, longitude, radius, filters == null ? "" : filters);
        return searchOffice.getFullOffices().stream().map(Office::new).toList();
    }
}
