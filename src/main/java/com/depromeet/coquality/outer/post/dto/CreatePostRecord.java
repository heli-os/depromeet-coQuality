package com.depromeet.coquality.outer.post.dto;

import javax.validation.constraints.NotEmpty;

public record CreatePostRecord(@NotEmpty String title) {

}
