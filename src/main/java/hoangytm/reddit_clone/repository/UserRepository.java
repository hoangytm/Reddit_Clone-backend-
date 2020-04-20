package hoangytm.reddit_clone.repository;

import hoangytm.reddit_clone.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * @author PhanHoang
 * 4/20/2020
 */
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}

