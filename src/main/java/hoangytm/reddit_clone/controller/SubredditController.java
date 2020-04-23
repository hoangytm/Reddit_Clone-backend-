package hoangytm.reddit_clone.controller;

import hoangytm.reddit_clone.model.DTO.SubredditDTO;
import hoangytm.reddit_clone.service.SubredditService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author PhanHoang
 * 4/21/2020
 */
@RestController
@RequestMapping("/api/subreddit")
public class SubredditController {
    @Autowired
    SubredditService subredditService;

    @GetMapping
    public List<SubredditDTO> getAllSubreddits() {
        return subredditService.getAll();
    }

    @GetMapping("/{id}")
    public SubredditDTO getSubreddit(@PathVariable Long id) {
        return subredditService.getSubreddit(id);
    }

    @PostMapping
    public SubredditDTO create(@RequestBody @Valid SubredditDTO subredditDTO) {
            return subredditService.save(subredditDTO);
    }

}
