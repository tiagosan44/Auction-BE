package com.tiagosan44.auction.repository;

import com.tiagosan44.auction.domain.Authority;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Spring Data JPA repository for the {@link Authority} entity.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Short> {

    Optional<Authority> findByAuthority(String authority);

}
