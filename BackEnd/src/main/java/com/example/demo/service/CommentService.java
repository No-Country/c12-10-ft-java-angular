package com.example.demo.service;


import com.example.demo.entity.Comment;
import com.example.demo.repository.CommentRepository;
import com.example.demo.requestEntity.CommentRE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service
public class CommentService {

    @Autowired
    CommentRepository commentRepository;

    public Comment createComment(CommentRE commentRE){

            Comment comment = new Comment();

        if(commentRE.getComment()!=null)
            comment.setComment(commentRE.getComment());

        return comment;

    }



}
