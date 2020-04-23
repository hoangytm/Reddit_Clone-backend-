package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.DTO.VoteDTO;
import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.Vote;

/**
 * @author PhanHoang
 * 4/23/2020
 */
public interface VoteService {
    void vote(VoteDTO voteDTO);

    Vote mapToVote(VoteDTO voteDto, Post post);
}
