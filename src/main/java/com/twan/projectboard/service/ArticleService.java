package com.twan.projectboard.service;

import com.twan.projectboard.domain.type.SearchType;
import com.twan.projectboard.dto.ArticleDto;
import com.twan.projectboard.dto.ArticleWithCommentsDto;
import com.twan.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword, Pageable pageable) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleWithCommentsDto getArticle(Long articleId) {
        return null;
    }

    public void saveArticle(ArticleDto dto) {

    }

    public void updateaArticle(ArticleDto dto) {
    }

    public void deleteArticle(long articleId) {
    }
}
