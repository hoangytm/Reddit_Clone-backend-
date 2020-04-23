package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.DTO.PostRequest;
import hoangytm.reddit_clone.model.DTO.PostResponse;

import java.util.List;

/**
 * @author PhanHoang
 * 4/23/2020
 */
public interface PostService {
     PostResponse getPost(Long id);
    List<PostResponse> getAllPosts();
    void save(PostRequest postRequest);
    List<PostResponse> getPostsBySubreddit(Long subredditId);
    List<PostResponse> getPostsByUsername(String username);
}
