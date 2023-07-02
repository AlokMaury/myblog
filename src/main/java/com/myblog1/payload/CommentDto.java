package com.myblog1.payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private long id;
    @NotEmpty
    @Size(min=2,message = "Name should be at least 2 characters")
    private String name;
    @NotEmpty
    @Size(min=5,message = "Name should be at least 5 characters")
    private String body;
    @NotEmpty
    @Email
    private String email;
}
