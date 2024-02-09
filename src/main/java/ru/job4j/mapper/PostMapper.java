package ru.job4j.mapper;

import org.mapstruct.Mapper;
import ru.job4j.dto.PostDto;
import ru.job4j.model.Post;

@Mapper(componentModel = "spring")
public interface PostMapper {
    Post map(PostDto postDto);

    PostDto map(Post post);
}
