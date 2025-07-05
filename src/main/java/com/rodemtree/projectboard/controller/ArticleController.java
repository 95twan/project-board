package com.rodemtree.projectboard.controller;

import com.rodemtree.projectboard.domain.type.SearchType;
import com.rodemtree.projectboard.dto.ArticleWithCommentsDto;
import com.rodemtree.projectboard.dto.response.ArticleResponse;
import com.rodemtree.projectboard.dto.response.ArticleWithCommentsResponse;
import com.rodemtree.projectboard.service.ArticleService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@RequestMapping("/articles")
@Controller
public class ArticleController {

    private final ArticleService articleService;

    @GetMapping
    public String articles(
            @RequestParam(required = false) SearchType searchType,
            @RequestParam(required = false) String searchKeyword,
            @PageableDefault(size = 10, sort = "createdAt", direction = Sort.Direction.DESC) Pageable pageable,
            ModelMap map
    ) {

        map.addAttribute("articles", articleService.searchArticles(searchType, searchKeyword, pageable).map(ArticleResponse::from));
        return "articles/index";
    }

    @GetMapping("/{articleId}")
    public String articles(@PathVariable Long articleId, ModelMap map) {
        ArticleWithCommentsDto articleWithCommentsDto = articleService.getArticle(articleId);
        ArticleWithCommentsResponse article = ArticleWithCommentsResponse.from(articleWithCommentsDto);
        map.addAttribute("article", article);
        map.addAttribute("articleComments", article.articleCommentsResponse());
        return "articles/detail";
    }

}
