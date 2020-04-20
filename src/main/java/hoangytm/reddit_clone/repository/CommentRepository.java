package hoangytm.reddit_clone.repository;

import hoangytm.reddit_clone.model.Comment;
import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author PhanHoang
 * 4/20/2020
 */
public interface CommentRepository extends JpaRepository<Comment, Long> {
    List<Comment> findByPost(Post post);

    List<Comment> findAllByUser(User user);
}