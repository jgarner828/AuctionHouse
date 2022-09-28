package com.garnerju.auctionhouse.repository;

import com.garnerju.auctionhouse.models.auctionmodels.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
