package hoangytm.reddit_clone.service;

import hoangytm.reddit_clone.model.DTO.PostRequest;
import hoangytm.reddit_clone.model.DTO.PostResponse;
import hoangytm.reddit_clone.model.Post;
import hoangytm.reddit_clone.model.Subreddit;
import hoangytm.reddit_clone.model.User;
import hoangytm.reddit_clone.repository.PostRepository;
import hoangytm.reddit_clone.repository.SubredditRepository;
import hoangytm.reddit_clone.repository.UserRepository;
import hoangytm.reddit_clone.utils.ObjectMapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

import static java.util.stream.Collectors.toList;

/**
 * @author PhanHoang
 * 4/23/2020
 */
@Service
public class PostServiceImp implements PostService {

    @Autowired
    PostRepository postRepository;
    @Autowired
    SubredditRepository subredditRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    AuthService authService;

    @Transactional
    public PostResponse getPost(Long id) {
        Post post = postRepository.findById(id)
                .orElseThrow(() -> new RuntimeException(id.toString()));
        PostResponse postResponse = new PostResponse();
        return ObjectMapperUtils.map(post, postResponse);

    }

    @Transactional
    public List<PostResponse> getAllPosts() {
        PostResponse postResponse = new PostResponse();
        return postRepository.findAll()
                .stream()
                .map(p -> ObjectMapperUtils.map(p, postResponse))
                .collect(toList());
    }

    public void save(PostRequest postRequest) {
        Subreddit subreddit = subredditRepository.findByName(postRequest.getSubredditName())
                .orElseThrow(() -> new RuntimeException(postRequest.getSubredditName()));
        Post post = new Post();
        postRepository.save(ObjectMapperUtils.map(postRequest, post));
    }

    @Transactional
    public List<PostResponse> getPostsBySubreddit(Long subredditId) {
        Subreddit subreddit = subredditRepository.findById(subredditId)
                .orElseThrow(() -> new RuntimeException(subredditId.toString()));
        List<Post> posts = postRepository.findAllBySubreddit(subreddit);
        PostResponse postResponse = new PostResponse();
        return posts.stream().map(p -> ObjectMapperUtils.map(p, postResponse)).collect(toList());
    }

    @Transactional
    public List<PostResponse> getPostsByUsername(String username) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new RuntimeException(username));
        PostResponse postResponse = new PostResponse();
        return postRepository.findByUser(user)
                .stream()
                .map(p -> ObjectMapperUtils.map(p, postResponse))
                .collect(toList());
    }
}

