package com.depromeet.coquality.inner.post.domain.policy.validation;

import com.depromeet.coquality.inner.common.domain.exception.CoQualityDomainExceptionCode;
import com.depromeet.coquality.inner.post.domain.Post;
import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;

public final class PostValidationPolicy {

    private static final int TITLE_MIN_LENGTH = 1;
    private static final int TITLE_MAX_LENGTH = 100;

    private static final int CONTENTS_MAX_LENGTH = 2000; // 임의 설정

    private PostValidationPolicy() {
    }

    public static void validatePost(final Post post) {
        validateTitle(post.getTitle());
        validateContents(post.getContents());
        validatePrimaryCategory(post.getPrimaryPostCategoryCode());
        validateSummary(post.getSummary());
    }

    public static void validateTitle(final String title) {
        if (title == null) {
            throw CoQualityDomainExceptionCode.POST_TITLE_IS_NULL.newInstance();
        }

        final var length = title.length();

        if (length > TITLE_MAX_LENGTH) {
            throw CoQualityDomainExceptionCode.POST_TITLE_MAX_LENGTH_VIOLATE.newInstance(
                TITLE_MAX_LENGTH);
        }

        if (length < TITLE_MIN_LENGTH) {
            throw CoQualityDomainExceptionCode.POST_TITLE_MIN_LENGTH_VIOLATE.newInstance(
                TITLE_MIN_LENGTH
            );
        }
    }

    public static void validateContents(final String contents) {
        if (contents == null) {
            throw CoQualityDomainExceptionCode.POST_CONTENTS_IS_NULL.newInstance();
        }

        final var length = contents.length();

        if (length > CONTENTS_MAX_LENGTH) {
            throw CoQualityDomainExceptionCode.POST_CONTENTS_MAX_LENGTH_VIOLATE.newInstance(
                CONTENTS_MAX_LENGTH
            );
        }
    }

    public static void validatePrimaryCategory(
        final PrimaryPostCategoryCode primaryPostCategoryCode) {
        if (primaryPostCategoryCode == null) {
            throw CoQualityDomainExceptionCode.POST_PRIMARY_CATEGORY_IS_NULL.newInstance();
        }
    }

    public static void validateSummary(final String summary) {
        if (summary == null) {
            throw CoQualityDomainExceptionCode.POST_SUMMARY_IS_NULL.newInstance();
        }
    }
}