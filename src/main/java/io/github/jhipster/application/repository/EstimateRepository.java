package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.Estimate;
import io.github.jhipster.application.domain.Task;
import io.github.jhipster.application.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstimateRepository extends JpaRepository<Estimate, Long> {

    Optional<Estimate> findByUserAndTask(User user, Task task);

}
