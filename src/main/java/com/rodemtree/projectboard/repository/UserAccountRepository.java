package com.rodemtree.projectboard.repository;

import com.rodemtree.projectboard.domain.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
