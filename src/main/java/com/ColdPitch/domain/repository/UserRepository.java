package com.ColdPitch.domain.repository;

import com.ColdPitch.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryCustom {
    Optional<User> findByEmail(String email);

    Optional<User> findOneWithAuthoritiesByEmail(String email);

    Optional<User> findByNickname(String nickname);

    void deleteByEmail(String email);
}
