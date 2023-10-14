package org.bmp.vtb.model;

import org.bmp.vtb.repository.OfficeRepository;
import org.springframework.stereotype.Service;

@Service
public class OfficeModel {
    private final OfficeRepository officeRepository;

    public OfficeModel(OfficeRepository officeRepository) {
        this.officeRepository = officeRepository;
    }
}
