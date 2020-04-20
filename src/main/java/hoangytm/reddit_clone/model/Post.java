package hoangytm.reddit_clone.model;

import com.sun.istack.Nullable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

import static javax.persistence.FetchType.LAZY;

/**
 * @author PhanHoang
 * 4/20/2020
 */
@Data
@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "post_id")
    private Long postId;
    @NotBlank(message = "Post Name cannot be empty or Null")
    @Column(name = "post_name")
    private String postName;
    @Nullable
    @Column(name = "url")
    private String url;
    @Nullable
    @Lob
    @Column(name = "description")
    private String description;
    @Column(name = "vote_count")
    private Integer voteCount;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user", referencedColumnName = "user_id")
    private User user;
    @Column(name = "created_date")
    private Date createdDate;
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "subreddit", referencedColumnName = "id")
    private Subreddit subreddit;
}
