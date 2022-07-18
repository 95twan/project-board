package com.twan.projectboard.service;

import com.twan.projectboard.domain.Article;
import com.twan.projectboard.domain.type.SearchType;
import com.twan.projectboard.dto.ArticleDto;
import com.twan.projectboard.dto.ArticleUpdateDto;
import com.twan.projectboard.repository.ArticleRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.*;

@DisplayName("게시글 로직")
@ExtendWith(MockitoExtension.class)
class ArticleServiceTest {

    @InjectMocks
    private ArticleService sut;
    @Mock
    private ArticleRepository articleRepository;

    @DisplayName("게시글 검색")
    @Test
    void test1() {
        // give
//        SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // when
        Page<ArticleDto> articles = sut.searchArticles(SearchType.TITLE, "search keyword");

        // then
        assertThat(articles).isNotNull();
    }

    @DisplayName("게시글 ID로 검색")
    @Test
    void test2() {
        // give
//        SearchParameters param = SearchParameters.of(SearchType.TITLE, "search keyword");

        // when
        ArticleDto article = sut.searchArticle(1L);

        // then
        assertThat(article).isNotNull();
    }

    @DisplayName("게시글 생성")
    @Test
    void test3() {
        // give
        ArticleDto dto = ArticleDto.of(LocalDateTime.now(), "twan", "title", "content", "#java");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.saveArticle(dto);

        // then
        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글 수정")
    @Test
    void test4() {
        // give
        ArticleUpdateDto dto = ArticleUpdateDto.of("title", "content", "#java");
        given(articleRepository.save(any(Article.class))).willReturn(null);

        // when
        sut.updateaArticle(1L, dto);

        // then
        then(articleRepository).should().save(any(Article.class));

    }

    @DisplayName("게시글 삭제")
    @Test
    void test5() {
        // give
        Long articleId = 1L;
        willDoNothing().given(articleRepository).deleteById(articleId);

        // when
        sut.deleteArticle(articleId);

        // then
        then(articleRepository).should().deleteById(articleId);

    }
}
