package hoangytm.reddit_clone.repository;

import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.User;
import hoangytm.reddit_clone.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author PhanHoang
 * 4/20/2020
 */
public interface VoteRepository extends JpaRepository<Vote, Long> {
    Optional<Vote> findTopByPostAndUserOrderByVoteIdDesc(Post post, User currentUser);
}