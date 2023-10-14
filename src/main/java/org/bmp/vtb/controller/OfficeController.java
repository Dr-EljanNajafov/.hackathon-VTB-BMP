package org.bmp.vtb.controller;

import org.bmp.vtb.model.OfficeModel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/bank-branches")
public class OfficeController {
    private final OfficeModel officeModel;

    public OfficeController(OfficeModel officeModel) {
        this.officeModel = officeModel;
    }
}
