package com.rodemtree.projectboard.repository;

import com.rodemtree.projectboard.domain.UserAccount;
import com.rodemtree.projectboard.domain.projection.UserAccountProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(excerptProjection = UserAccountProjection.class)
public interface UserAccountRepository extends JpaRepository<UserAccount, String> {
}
