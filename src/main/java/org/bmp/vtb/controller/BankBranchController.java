package org.bmp.vtb.controller;

import org.bmp.vtb.entity.Office;
import org.bmp.vtb.service.BankBranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/bank-branches")
public class BankBranchController {
    @Autowired
    private BankBranchService bankBranchService;

    @GetMapping("/all")
    public List<Office> getAllBankBranches() {
        List<Office> branches = bankBranchService.getAllBankBranches();
        return branches;
    }
}
