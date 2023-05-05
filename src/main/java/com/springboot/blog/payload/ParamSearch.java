package com.springboot.blog.payload;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParamSearch {
    private String title;
    private String description;
    private String content;

}
