package hoangytm.reddit_clone.repository;

import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.Subreddit;
import hoangytm.reddit_clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author PhanHoang
 * 4/20/2020
 */
public interface PostRepository extends JpaRepository<Post, Long> {
    List<Post> findAllBySubreddit(Subreddit subreddit);

    List<Post> findByUser(User user);
}