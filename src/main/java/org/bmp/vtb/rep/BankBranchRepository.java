package org.bmp.vtb.rep;

import org.bmp.vtb.entity.Office;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface BankBranchRepository extends JpaRepository<Office, Long> {
    // Можно определить дополнительные методы запросов здесь, если необходимо
}

