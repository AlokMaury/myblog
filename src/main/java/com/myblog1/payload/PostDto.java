package com.myblog1.payload;

import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
public class PostDto {
    private long id;

    // title should not be null  or empty
    // title should have at least 2 characters
    @NotEmpty(message ="Is Manadatory")
    @Size(min = 2, message = "Post title should have at least 2 characters")

    private String title;
    // post description should be not null or empty
    // post description should have at least 10 characters
    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters")

    private String description;

    @NotEmpty
    @Size(min = 10, message = "Post content should have at least 10 characters")
    private String content;
}
