package Tweet;

import AppUser.AppUser;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name= "tweet")
public class Tweet {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "published_at")
    @CreationTimestamp
    private Date publishedAt;
    private String message;

    @ManyToOne(cascade = {CascadeType.MERGE, CascadeType.PERSIST})
    @JoinColumn(name = "author_fk")
    private AppUser author;

    public Tweet(){

    }

    public Long getId() {
        return id;
    }

    public Date getPublishedAt() {
        return publishedAt;
    }

    public String getMessage() {
        return message;
    }

    public AppUser getAuthor() {
        return author;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setPublishedAt(Date publishedAt) {
        this.publishedAt = publishedAt;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAuthor(AppUser author) {
        this.author = author;
    }
}
