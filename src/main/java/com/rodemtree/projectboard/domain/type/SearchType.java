package com.rodemtree.projectboard.domain.type;

import lombok.Getter;

public enum SearchType {
    TITLE("제목"),
    CONTENT("본문"),
    ID("유저 ID"),
    HASHTAG("해시태그"),
    NICKNAME("닉네임");

    @Getter
    private final String description;

    SearchType(String description) {
        this.description = description;
    }
}
