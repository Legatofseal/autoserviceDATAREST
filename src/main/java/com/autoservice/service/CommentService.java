package com.autoservice.service;

import com.autoservice.exception.AlreadyExistsException;
import com.autoservice.model.Comment;
import com.autoservice.repo.ClientRepository;
import com.autoservice.repo.CommentRepository;
import com.autoservice.repo.ContractorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final ClientRepository clientRepository;
    private final ContractorRepository contractorRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository, ClientRepository clientRepository, ContractorRepository contractorRepository) {
        this.commentRepository = commentRepository;
        this.clientRepository = clientRepository;
        this.contractorRepository = contractorRepository;
    }

    public Comment create(Comment comment) {


        // Example of custom logic
        if (comment.getId() != null && commentRepository.findOne(comment.getId()) != null) {
            throw new AlreadyExistsException("Comment", comment.getId());
        }

        Comment result = commentRepository.save(comment);
        return comment;
    }

    public List<Comment> getCommentsByClient(Long id){
        return commentRepository.findByClient(clientRepository.findOne(id));
    }
    public List<Comment> getCommentsByContractor(Long id){
        return commentRepository.findByContractor(contractorRepository.findOne(id));
    }
    public List<Comment> getAllbyDate(){
        return commentRepository.findAll();
    }
}
