package com.rodemtree.projectboard.config;

import com.rodemtree.projectboard.domain.Article;
import com.rodemtree.projectboard.domain.ArticleComment;
import com.rodemtree.projectboard.domain.Hashtag;
import com.rodemtree.projectboard.domain.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Controller;

@Controller
public class DataRestConfig {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig((config, cors) ->
                config
                        .exposeIdsFor(UserAccount.class)
                        .exposeIdsFor(Article.class)
                        .exposeIdsFor(ArticleComment.class)
                        .exposeIdsFor(Hashtag.class)
        );
    }
}
