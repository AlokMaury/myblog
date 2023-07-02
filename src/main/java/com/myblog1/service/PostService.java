package com.myblog1.service;

import com.myblog1.payload.PostDto;
import com.myblog1.payload.PostResponse;

public interface PostService {
    PostDto createPost(PostDto postDto);

  PostResponse getAllPost(int PageNo, int PageSize, String sortBy, String sortDir);

    PostDto getPostById(long id);

    PostDto updatePost(PostDto postDto, long id);

    void deletePostById(long id);
}
