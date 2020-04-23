package hoangytm.reddit_clone.controller;

import hoangytm.reddit_clone.model.DTO.CommenstDTO;
import hoangytm.reddit_clone.service.CommentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.ResponseEntity.status;

/**
 * @author PhanHoang
 * 4/23/2020
 */
@RestController
@RequestMapping("/api/comments/")
public class CommentController {
    @Autowired
    CommentService commentService;

    @PostMapping
    public ResponseEntity<Void> createComment(@RequestBody CommenstDTO commenstDTO) {
        commentService.createComment(commenstDTO);
        return new ResponseEntity<>(CREATED);
    }

    @GetMapping("/{postID}")
    public ResponseEntity<List<CommenstDTO>> getAllCommentsForPost(@RequestParam("postId") Long postId) {
        return status(OK)
                .body(commentService.getCommentByPost(postId));
    }

    @GetMapping("/{userName}")
    public ResponseEntity<List<CommenstDTO>> getAllCommentsByUser(@RequestParam("userName") String userName) {
        return status(OK).body(commentService.getCommentsByUser(userName));
    }
}