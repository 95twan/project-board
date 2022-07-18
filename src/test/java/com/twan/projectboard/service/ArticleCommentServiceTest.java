package com.twan.projectboard.service;

import com.twan.projectboard.domain.Article;
import com.twan.projectboard.domain.ArticleComment;
import com.twan.projectboard.dto.ArticleCommentDto;
import com.twan.projectboard.dto.ArticleCommentUpdateDto;
import com.twan.projectboard.repository.ArticleCommentRepository;
import com.twan.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;


@DisplayName("댓글 로직")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks
    private ArticleCommentService sut;
    @Mock
    private ArticleCommentRepository articleCommentRepository;
    @Mock
    private ArticleRepository articleRepository;


    @DisplayName("댓글 ID로 검색")
    @Test
    void test1() {
        // give
        Long articleId = 1L;
        Article article = Article.of("title", "content", "#java");
        given(articleRepository.findById(articleId)).willReturn(Optional.of(article));

        // when
        List<ArticleCommentDto> articleComments = sut.searchArticleComments(articleId);

        // then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 생성")
    @Test
    void test2() {
        // give
        ArticleCommentDto dto = ArticleCommentDto.of(
                LocalDateTime.now(),
                "twan",
                LocalDateTime.now(),
                "twan",
                "content"
        );
        given(articleRepository.findById(1L)).willReturn(null);
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // when
        sut.saveArticleComment(1L, dto);

        // then
        then(articleRepository).should().findById(1L);
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글 수정")
    @Test
    void test3() {
        // give
        ArticleCommentUpdateDto dto = ArticleCommentUpdateDto.of("content");
        given(articleRepository.findById(1L)).willReturn(null);
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // when
        sut.updateArticleComment(1L, dto);

        // then
        then(articleRepository).should().findById(1L);
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }

    @DisplayName("댓글 삭제")
    @Test
    void test4() {
        // give
        Long articleCommentId = 1L;
        willDoNothing().given(articleCommentRepository).deleteById(articleCommentId);

        // when
        sut.deleteArticleComment(articleCommentId);

        // then
        then(articleCommentRepository).should().deleteById(articleCommentId);
    }

}
