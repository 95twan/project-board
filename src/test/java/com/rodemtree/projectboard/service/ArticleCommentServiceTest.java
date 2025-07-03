package com.rodemtree.projectboard.service;

import com.rodemtree.projectboard.domain.Article;
import com.rodemtree.projectboard.domain.ArticleComment;
import com.rodemtree.projectboard.dto.ArticleCommentDto;
import com.rodemtree.projectboard.repository.ArticleCommentRepository;
import com.rodemtree.projectboard.repository.ArticleRepository;
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
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;

@DisplayName("비즈니스 로직 - 댓글")
@ExtendWith(MockitoExtension.class)
class ArticleCommentServiceTest {

    @InjectMocks private ArticleCommentService sut;
    @Mock private ArticleCommentRepository articleCommentRepository;
    @Mock private ArticleRepository articleRepository;

    @DisplayName("게시글 ID로 조회하면, 해당하는 댓글 리스트를 반환한다.")
    @Test
    void givenArticleId_whenSearchingComments_thenReturnsComments() {
        // Given
        Long articleId = 1L;
        Article article = Article.of("title", "content", "#hashtag");
        given(articleRepository.findById(articleId)).willReturn(Optional.of(article));

        // When
        List<ArticleCommentDto> articleComments = sut.searchArticleComments(1L);

        // Then
        assertThat(articleComments).isNotNull();
        then(articleRepository).should().findById(articleId);
    }

    @DisplayName("댓글 정보를 입력하면, 댓글을 저장한다.")
    @Test
    void givenCommentInfo_whenSavingComments_thenSavesComments() {
        // Given
        given(articleCommentRepository.save(any(ArticleComment.class))).willReturn(null);

        // When
        sut.saveArticleComment(ArticleCommentDto.of("new content", LocalDateTime.now(), "test", LocalDateTime.now(), "test"));

        // Then
        then(articleCommentRepository).should().save(any(ArticleComment.class));
    }
}
