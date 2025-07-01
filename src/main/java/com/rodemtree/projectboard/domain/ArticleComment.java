package com.rodemtree.projectboard.domain;

import java.time.LocalDateTime;

public class ArticleComment {
    private Long id;
    private Article article;
    private String content;

    private LocalDateTime createdAt;
    private Long createdBy;
    private LocalDateTime modifiedAt;
    private Long modifiedBy;
}
