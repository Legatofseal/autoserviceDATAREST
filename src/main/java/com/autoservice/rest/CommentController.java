package com.autoservice.rest;

import com.autoservice.model.Comment;
import com.autoservice.service.ClientService;
import com.autoservice.service.CommentService;
import com.autoservice.service.ContractorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Legat on 10/15/2016.
 */
@RestController
@RequestMapping(value = "comments")
public class CommentController {
    private final CommentService commentService;
    private final ClientService clientService;
    private final ContractorService contractorService;

    @Autowired
    public CommentController(CommentService commentService, ClientService clientService, ContractorService contractorService) {
        this.commentService = commentService;
        this.clientService = clientService;
        this.contractorService = contractorService;
    }


    @RequestMapping(value = "/addcomment", method = RequestMethod.PUT)
    public void addComment() {
        commentService.create(new Comment(clientService.get((long) 1), contractorService.get((long) 1), "message", 3));
    }
    @RequestMapping(value = "/getcommentsbyclient/{id}", method = RequestMethod.GET)
    public List<Comment> getCommentByClient(@PathVariable("id") Long id) {
        return commentService.getCommentsByClient(id);
    }

    @RequestMapping(value = "/getcommentsbycontractor/{id}", method = RequestMethod.GET)
    public List<Comment> getCommentByContractor(@PathVariable("id") Long id) {
        return commentService.getCommentsByContractor(id);
    }

    @RequestMapping(value = "/getcommentsbydate/{number}", method = RequestMethod.GET)
    public List<Comment> getCommentByDate(@PathVariable("number") int number) {
        ArrayList<Comment> tempList = (ArrayList<Comment>) commentService.getAllbyDate();
       Collections.sort(tempList);
        ArrayList<Comment> tempListRet = new ArrayList<Comment>();
        for (int i=0; i<number; i++){
            tempListRet.add(tempList.get(i));
        }
        return tempListRet;
    }
}
