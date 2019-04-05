package hs.kr.dgsw._20190326.Repository;

import hs.kr.dgsw._20190326.Domain.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
    void deleteById(Long id);
}
