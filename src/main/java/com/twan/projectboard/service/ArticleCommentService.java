package com.twan.projectboard.service;

import com.twan.projectboard.dto.ArticleCommentDto;
import com.twan.projectboard.dto.ArticleCommentUpdateDto;
import com.twan.projectboard.repository.ArticleCommentRepository;
import com.twan.projectboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Transactional
@Service
public class ArticleCommentService {

    private final ArticleRepository articleRepository;
    private final ArticleCommentRepository articleCommentRepository;

    @Transactional(readOnly = true)
    public List<ArticleCommentDto> searchArticleComments(Long articleId) {
        return List.of();
    }

    public void saveArticleComment(Long articleId, ArticleCommentDto dto) {
    }

    public void updateArticleComment(Long articleId, ArticleCommentUpdateDto dto) {
    }

    public void deleteArticleComment(Long articleCommentId) {
    }
}
