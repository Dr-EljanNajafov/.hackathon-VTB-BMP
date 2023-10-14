package org.bmp.vtb.service;

import org.bmp.vtb.entity.Office;
import org.bmp.vtb.rep.BankBranchRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BankBranchService {
    @Autowired
    private BankBranchRepository bankBranchRepository;

    public List<Office> getAllBankBranches() {
        return bankBranchRepository.findAll();
    }
}
