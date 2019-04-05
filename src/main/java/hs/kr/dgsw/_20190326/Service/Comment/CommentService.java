package hs.kr.dgsw._20190326.Service.Comment;

import hs.kr.dgsw._20190326.Domain.Comment;

public interface CommentService {
    Comment add(Comment comment);
    Comment update(Long id, Comment comment);
    boolean delete(Long id);
}
