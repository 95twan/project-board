package com.rodemtree.projectboard.domain.projection;

import com.rodemtree.projectboard.domain.Article;
import com.rodemtree.projectboard.domain.UserAccount;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "withoutPassword", types = UserAccount.class)
public interface UserAccountProjection {
    String getUserId();
    String getEmail();
    String getNickname();
    String getMemo();
    LocalDateTime getCreatedAt();
    String getCreatedBy();
    LocalDateTime getModifiedAt();
    String getModifiedBy();
}
