package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.Comment;
import hoangytm.reddit_clone.model.DTO.CommenstDTO;
import hoangytm.reddit_clone.model.NotificationEmail;
import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.User;
import hoangytm.reddit_clone.repository.CommentRepository;
import hoangytm.reddit_clone.repository.PostRepository;
import hoangytm.reddit_clone.repository.UserRepository;
import hoangytm.reddit_clone.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PhanHoang
 * 4/23/2020
 */
@Service
public class CommentServiceImp implements CommentService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    CommentRepository commentRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthService authService;
    @Autowired
    MailContentBuilder mailContentBuilder;
    @Autowired
    MailService mailService;

    public void createComment(CommenstDTO commenstDTO) {
        Post post = postRepository.findById(commenstDTO.getPostId())
                .orElseThrow(() -> new RuntimeException(commenstDTO.getPostId().toString()));
        Comment comment = new Comment();
        commentRepository.save(ObjectMapperUtils.map(commenstDTO, comment));
//thong bao mail khi comment
//        String message = mailContentBuilder.build(post.getUser().getUsername() + " posted a comment on your post." );
//        sendCommentNotification(message, post.getUser());
    }

    public List<CommenstDTO> getCommentByPost(Long postId) {
        Post post = postRepository.findById(postId)
                .orElseThrow(() -> new RuntimeException(postId.toString()));
        CommenstDTO commenstDTO = new CommenstDTO();
        return commentRepository.findByPost(post)
                .stream()
                .map(p -> ObjectMapperUtils.map(p, commenstDTO))
                .collect(toList());
    }

    public List<CommenstDTO> getCommentsByUser(String userName) {
        User user = userRepository.findByUsername(userName)
                .orElseThrow(() -> new RuntimeException(userName));
        CommenstDTO commenstDTO = new CommenstDTO();
        return commentRepository.findAllByUser(user)
                .stream()
                .map(p -> ObjectMapperUtils.map(p, commenstDTO))
                .collect(toList());
    }

    public void sendCommentNotification(String message, User user) {
        mailService.sendMail(new NotificationEmail(user.getUsername() + " Commented on your post", user.getEmail(), message));
    }
}
