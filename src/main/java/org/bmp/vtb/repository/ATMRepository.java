package org.bmp.vtb.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.bmp.vtb.entity.ATM;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@Tag(name = "atm-controller")
@RepositoryRestResource(collectionResourceRel = "atms", path = "atms")
public interface ATMRepository extends JpaRepository<ATM, Long>, PagingAndSortingRepository<ATM, Long> {
}
