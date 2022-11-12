package com.depromeet.coquality.inner.post.domain;

import com.depromeet.coquality.inner.post.domain.code.PrimaryPostCategoryCode;
import com.depromeet.coquality.inner.post.domain.policy.validation.PostValidationPolicy;
import lombok.Getter;

@Getter
public class Post {

    private final Long id;
    private String title;
    private String contents;
    private PrimaryPostCategoryCode primaryPostCategoryCode;
    private String summary;
    private Long views;

    private Post(
        final Long id,
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final String summary,
        final Long views
    ) {
        this.id = id;
        this.title = title;
        this.contents = contents;
        this.primaryPostCategoryCode = primaryPostCategoryCode;
        this.summary = summary;
        this.views = views;
        PostValidationPolicy.validatePost(this);
    }

    public static Post of(
        final Long id,
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final String summary
    ) {
        return new Post(id, title, contents, primaryPostCategoryCode, summary, 0L);
    }

    public static Post of(
        final Long id,
        final String title,
        final String contents,
        final PrimaryPostCategoryCode primaryPostCategoryCode,
        final String summary,
        final Long views
    ) {
        return new Post(id, title, contents, primaryPostCategoryCode, summary, views);
    }

}