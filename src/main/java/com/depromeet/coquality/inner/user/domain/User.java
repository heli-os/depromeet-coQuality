package com.depromeet.coquality.inner.user.domain;

import com.depromeet.coquality.inner.user.domain.policy.validation.UserValidationPolicy;
import lombok.Getter;

@Getter
public class User {
    private String nickname;
    private String socialId;
    private String socialEmail;

    private User(final String socialId, final String socialEmail) {
        this.socialId = socialId;
        this.socialEmail = socialEmail;
        UserValidationPolicy.validate(this);
    }
    public static User of(final String socialId, final String socialEmail){
        return new User(socialId, socialEmail);
    }
}
