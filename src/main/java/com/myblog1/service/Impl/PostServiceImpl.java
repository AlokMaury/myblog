package com.myblog1.service.Impl;

import com.myblog1.entities.Post;
import com.myblog1.exeception.ResouceNotFoundException;
import com.myblog1.payload.PostDto;
import com.myblog1.payload.PostResponse;
import com.myblog1.repository.PostRepository;
import com.myblog1.service.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    private ModelMapper modelMapper;

    public PostServiceImpl(PostRepository postRepository,ModelMapper mapper) {

        this.postRepository = postRepository;
        this.modelMapper=mapper;
    }

    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post newPost = postRepository.save(post);
        PostDto dto = mapToDto(newPost);
        return dto;
    }

    @Override
    public PostResponse getAllPost(int PageNo,int PageSize,String sortBy,String sortDir) {

      Sort sort= sortDir.equalsIgnoreCase(Sort.Direction.ASC.name())?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(PageNo, PageSize,sort);
        Page<Post> posts = postRepository.findAll(pageable);
        List<Post> content = posts.getContent();
        List<PostDto> postDtos = content.stream().map(post -> mapToDto(post)).collect(Collectors.toList());

        PostResponse postResponse=new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNo(posts.getNumber());
        postResponse.setPageSize(posts.getSize());
        postResponse.setTotalPages(posts.getTotalPages());
        postResponse.setTotelElements(posts.getTotalElements());
        postResponse.setLast(posts.isLast());
        return postResponse;

    }

    @Override
    public PostDto getPostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResouceNotFoundException("post", "id", id)
        );
        return mapToDto(post);
    }

    @Override
    public PostDto updatePost(PostDto postDto, long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResouceNotFoundException("post", "id", id)
        );

        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        post.setTitle(postDto.getTitle());

        Post posts = postRepository.save(post);
        PostDto dto = mapToDto(posts);
        return dto;
    }

    @Override
    public void deletePostById(long id) {
        Post post = postRepository.findById(id).orElseThrow(
                () -> new ResouceNotFoundException("post", "id", id)
        );
        postRepository.delete(post);
    }

    public PostDto mapToDto(Post newPost) {
        PostDto dto = modelMapper.map(newPost,PostDto.class);
//        PostDto dto = new PostDto();
//        dto.setContent(newPost.getContent());
//        dto.setId(newPost.getId());
//        dto.setDescription(newPost.getDescription());
//        dto.setTitle(newPost.getTitle());
        return dto;
    }

    public Post mapToEntity(PostDto postDto) {
        Post post = modelMapper.map(postDto, Post.class);
//        Post post = new Post();
//        post.setContent(postDto.getContent());
//        post.setTitle(postDto.getTitle());
//        post.setDescription(postDto.getDescription());
//        post.setId(postDto.getId());
        return post;
    }


}

