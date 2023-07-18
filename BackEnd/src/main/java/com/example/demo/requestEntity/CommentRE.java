package com.example.demo.requestEntity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommentRE {

    private String id;
    private String comment;
    private String ownership_id;
    private String user_id;
}
