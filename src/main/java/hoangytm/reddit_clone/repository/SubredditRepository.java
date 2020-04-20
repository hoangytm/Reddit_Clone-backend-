package hoangytm.reddit_clone.repository;

import hoangytm.reddit_clone.model.Subreddit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author PhanHoang
 * 4/20/2020
 */
public interface SubredditRepository extends JpaRepository<Subreddit, Long> {
    Optional<Subreddit> findByName(String subredditName);
}