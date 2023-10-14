package org.bmp.vtb.repository;

import org.bmp.vtb.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.webmvc.RepositoryRestController;

@RepositoryRestController
public interface OfficeRepository extends JpaRepository<Office, Long>, PagingAndSortingRepository<Office, Long> {
}
