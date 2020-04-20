package hoangytm.reddit_clone.model;

/**
 * @author PhanHoang
 * 4/20/2020
 */

public enum VoteType {
    UPVOTE(1), DOWNVOTE(-1),
    ;

    VoteType(int direction) {
    }
}