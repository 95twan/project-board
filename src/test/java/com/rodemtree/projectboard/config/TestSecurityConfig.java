package com.rodemtree.projectboard.config;

import com.rodemtree.projectboard.domain.UserAccount;
import com.rodemtree.projectboard.dto.UserAccountDto;
import com.rodemtree.projectboard.repository.UserAccountRepository;
import com.rodemtree.projectboard.service.UserAccountService;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.event.annotation.BeforeTestMethod;

import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.BDDMockito.given;

@Import(SecurityConfig.class)
public class TestSecurityConfig {


    // Todo - @MockitoBean사용시 생성 안됨
    @MockBean
    private UserAccountRepository userAccountRepository;

    @MockBean
    private UserAccountService userAccountService;

    @BeforeTestMethod
    public void securitySetup() {
        given(userAccountService.searchUser(anyString())).willReturn(Optional.of(createUserAccountDto()));
        given(userAccountService.saveUser(anyString(), anyString(), anyString(), anyString(), anyString())).willReturn(
                createUserAccountDto()
        );
    }

    private UserAccountDto createUserAccountDto() {
        return UserAccountDto.of("test", "pw", "test@email.com", "testNick", "test memo");
    }
}
