package hoangytm.reddit_clone.model;

import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

import static javax.persistence.FetchType.LAZY;
import static javax.persistence.GenerationType.AUTO;

/**
 * @author PhanHoang
 * 4/20/2020
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
@Table(name = "vote")
public class Vote {
    @Id
    @GeneratedValue(strategy = AUTO)
    @Column(name = "vode_id")
    private Long voteId;
    @Column(name = "vote_type")
    private VoteType voteType;
    @NotNull
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "post", referencedColumnName = "post_id")
    private Post post;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    private User user;
}
