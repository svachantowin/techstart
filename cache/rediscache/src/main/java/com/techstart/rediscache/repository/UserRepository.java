package com.techstart.rediscache.repository;

import com.techstart.rediscache.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository< User,Long> {
}
