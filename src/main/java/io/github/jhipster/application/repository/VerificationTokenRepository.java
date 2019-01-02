package io.github.jhipster.application.repository;

import io.github.jhipster.application.domain.User;
import io.github.jhipster.application.domain.VerificationToken;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {

    VerificationToken findByToken(String token);
    VerificationToken findByUser(User user);
}
