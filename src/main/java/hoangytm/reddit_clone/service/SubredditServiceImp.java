package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.DTO.SubredditDTO;
import hoangytm.reddit_clone.model.Subreddit;
import hoangytm.reddit_clone.repository.SubredditRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.List;

import static java.time.Instant.now;
import static java.util.stream.Collectors.toList;

/**
 * @author PhanHoang
 * 4/21/2020
 */
@Service
public class SubredditServiceImp implements SubredditService {
    @Autowired
    private SubredditRepository subredditRepository;
    @Autowired
    private AuthService authService;

    @Transactional
    public List<SubredditDTO> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(p-> mapToDto(p))
                .collect(toList());
    }

    @Transactional
    public SubredditDTO save(SubredditDTO subredditDTO) {
        Subreddit subreddit = subredditRepository.save(mapToSubreddit(subredditDTO));
        subredditDTO.setId(subreddit.getId());
        return subredditDTO;
    }

    @Transactional
    public SubredditDTO getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Subreddit not found with id -" + id));
        return mapToDto(subreddit);
    }

    private SubredditDTO mapToDto(Subreddit subreddit) {
        return SubredditDTO.builder().name(subreddit.getName())
                .id(subreddit.getId())
                .postCount(subreddit.getPosts().size())
                .build();
    }

    private Subreddit mapToSubreddit(SubredditDTO subredditDTO) {
        return Subreddit.builder().name(  subredditDTO.getName())
                .description(subredditDTO.getDescription())
                .user(authService.getCurrentUser())
                .createdDate(now()).build();
    }
}
