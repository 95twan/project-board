package com.rodemtree.projectboard.domain.projection;

import com.rodemtree.projectboard.domain.Article;
import com.rodemtree.projectboard.domain.UserAccount;
import org.springframework.data.rest.core.config.Projection;

import java.time.LocalDateTime;

@Projection(name = "withUserAccount", types = Article.class)
public interface ArticleProjection {
    Long getId();
    UserAccount getUserAccount();
    String getTitle();
    String getContent();
    LocalDateTime getCreatedAt();
    String getCreatedBy();
    LocalDateTime getModifiedAt();
    String getModifiedBy();
}
