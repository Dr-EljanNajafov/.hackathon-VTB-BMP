package org.bmp.vtb.model.algorithms;

import org.bmp.vtb.entity.Office;
import org.bmp.vtb.repository.OfficeRepository;
import org.bmp.vtb.utilites.GeographicUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SearchOffice {
    private final OfficeRepository officeRepository;
    private final GeographicUtils geographicUtils;
    private final double lat, lon;
    private final int maxRadius;
    private final List<Integer> filterIds;

    public SearchOffice(OfficeRepository officeRepository, GeographicUtils geographicUtils, double lat, double lon, int maxRadius, String filters) {
        this.officeRepository = officeRepository;
        this.geographicUtils = geographicUtils;
        this.lat = lat;
        this.lon = lon;
        this.maxRadius = maxRadius;
        this.filterIds = !filters.isEmpty() ? Arrays.stream(filters.split(",")).map(Integer::parseInt).toList() : new ArrayList<>();
    }

    private List<Office> getOffices() {
        return officeRepository.findByCordsAndRadius(lat, lon, maxRadius)
                .stream()
                .map(office -> new OfficeCoefficient(office, geographicUtils.getDistance(lat, lon, office.getLatitude(), office.getLongitude()) / (Office.Filter.values().length + 1 - office.getStatus().getId())))
                .filter(office -> {
                    boolean predicate = true;
                    for(Integer id : filterIds) {
                        predicate = predicate && office.office().getFilterState(id);
                    }
                    return predicate;
                })
                .sorted(Comparator.comparing(OfficeCoefficient::k))
                .map(OfficeCoefficient::office)
                .toList();
    }

    public Office getOffice() {
        return getOffices().get(0);
    }

    public List<Office> getFullOffices() {
        return getOffices();
    }

    public record OfficeCoefficient(Office office, double k) {}
}
