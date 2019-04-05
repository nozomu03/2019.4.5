package hs.kr.dgsw._20190326.Domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
@Data
@NoArgsConstructor
public class Comment {
    @Id
    @GeneratedValue
    private Long id;

    private Long userId;
    private String content;

    @CreationTimestamp
    private LocalDateTime created;
    @UpdateTimestamp
    private LocalDateTime modified;

    public Comment(Long userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public Comment(Comment comment) {
        this.id = comment.getId();
        this.userId = comment.getUserId();
        this.content = comment.getContent();
        this.created = comment.getCreated();
        this.modified = comment.getModified();
    }
}
