package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.DTO.CommenstDTO;
import hoangytm.reddit_clone.model.User;

import java.util.List;

/**
 * @author PhanHoang
 * 4/23/2020
 */
public interface CommentService {
    void createComment(CommenstDTO commenstDTO);
    List<CommenstDTO> getCommentByPost(Long postId);
    List<CommenstDTO> getCommentsByUser(String userName);
    void sendCommentNotification(String message, User user);
}
