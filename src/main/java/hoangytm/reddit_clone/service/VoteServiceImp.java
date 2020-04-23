package hoangytm.reddit_clone.service;


import hoangytm.reddit_clone.model.DTO.VoteDTO;
import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.Vote;
import hoangytm.reddit_clone.repository.PostRepository;
import hoangytm.reddit_clone.repository.VoteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static hoangytm.reddit_clone.model.VoteType.UPVOTE;


/**
 * @author PhanHoang
 * 4/23/2020
 */

@Service
@AllArgsConstructor
public class VoteServiceImp implements VoteService {

    @Autowired
    VoteRepository voteRepository;
    @Autowired
    PostRepository postRepository;
    @Autowired
    AuthService authService;

    @Transactional
    public void vote(VoteDTO voteDto) {
        Post post = postRepository.findById(voteDto.getPostId())
                .orElseThrow(() -> new RuntimeException("Post Not Found with ID - " + voteDto.getPostId()));
        Optional<Vote> voteByPostAndUser = voteRepository.findTopByPostAndUserOrderByVoteIdDesc(post, authService.getCurrentUser());
        if (voteByPostAndUser.isPresent() &&
                voteByPostAndUser.get().getVoteType()
                        .equals(voteDto.getVoteType())) {
            throw new RuntimeException("You have already "
                    + voteDto.getVoteType() + "'d for this post");
        }
        if (UPVOTE.equals(voteDto.getVoteType())) {
            post.setVoteCount(post.getVoteCount() + 1);
        } else {
            post.setVoteCount(post.getVoteCount() - 1);
        }
        voteRepository.save(mapToVote(voteDto, post));
        postRepository.save(post);
    }

    public Vote mapToVote(VoteDTO voteDto, Post post) {
        return Vote.builder()
                .voteType(voteDto.getVoteType())
                .post(post)
                .user(authService.getCurrentUser())
                .build();
    }
}
