package com.rodemtree.projectboard.controller;

import com.rodemtree.projectboard.dto.UserAccountDto;
import com.rodemtree.projectboard.dto.request.ArticleCommentRequest;
import com.rodemtree.projectboard.service.ArticleCommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@RequestMapping("/comments")
@Controller
public class ArticleCommentController {

    private final ArticleCommentService articleCommentService;

    @PostMapping("/new")
    public String postNewArticleComment(ArticleCommentRequest articleCommentRequest) {
        UserAccountDto userAccountDto = UserAccountDto.of("uno", "asdf1234", "<EMAIL>", "Uno", "memo");
        articleCommentService.saveArticleComment(articleCommentRequest.toDto(userAccountDto));

        return "redirect:/articles/" + articleCommentRequest.articleId();
    }

    @PostMapping("/{commentId}/delete")
    public String deleteArticleComment(@PathVariable Long commentId, Long articleId) {
        articleCommentService.deleteArticleComment(commentId);
        return "redirect:/articles/" + articleId;
    }
}
