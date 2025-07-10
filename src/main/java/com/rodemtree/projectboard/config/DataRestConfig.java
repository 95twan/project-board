package com.rodemtree.projectboard.config;

import com.rodemtree.projectboard.domain.UserAccount;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.stereotype.Controller;

@Controller
public class DataRestConfig {
    @Bean
    public RepositoryRestConfigurer repositoryRestConfigurer() {
        return RepositoryRestConfigurer.withConfig((config, cors) ->
                config.exposeIdsFor(UserAccount.class)
        );
    }
}
