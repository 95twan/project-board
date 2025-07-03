package com.rodemtree.projectboard.service;

import com.rodemtree.projectboard.domain.type.SearchType;
import com.rodemtree.projectboard.dto.ArticleDto;
import com.rodemtree.projectboard.dto.ArticleUpdateDto;
import com.rodemtree.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@RequiredArgsConstructor
@Transactional
@Service
public class ArticleService {
    private final ArticleRepository articleRepository;

    @Transactional(readOnly = true)
    public Page<ArticleDto> searchArticles(SearchType searchType, String searchKeyword) {
        return Page.empty();
    }

    @Transactional(readOnly = true)
    public ArticleDto searchArticle(Long articleId) {
        return null;
    }


    public void saveArticle(ArticleDto dto) {
//        articleRepository.save()
    }

    public void updateArticle(Long articleId, ArticleUpdateDto dto) {
    }

    public void deleteArticle(Long articleId) {
    }
}
