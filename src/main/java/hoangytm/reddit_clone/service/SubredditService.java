package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.DTO.SubredditDTO;

import java.util.List;

/**
 * @author PhanHoang
 * 4/21/2020
 */
public interface SubredditService {
    List<SubredditDTO> getAll();

    SubredditDTO getSubreddit(Long id);

    SubredditDTO save(SubredditDTO subredditDto);
}
