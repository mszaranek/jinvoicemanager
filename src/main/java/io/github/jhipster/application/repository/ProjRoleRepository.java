package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.ProjRole;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjRoleRepository extends JpaRepository<ProjRole, Long> {
}
