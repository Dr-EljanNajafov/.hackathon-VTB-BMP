package org.bmp.vtb.repository;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.bmp.vtb.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@Tag(name = "office-controller")
@RepositoryRestResource(collectionResourceRel = "offices", path = "offices")
public interface OfficeRepository extends JpaRepository<Office, Long>, PagingAndSortingRepository<Office, Long> {
    @Query(value = "FROM Office WHERE getDistance(:lat, :lon, latitude, longitude) < :radius")
    List<Office> findByCordsAndRadius(double lat, double lon, int radius);
}
