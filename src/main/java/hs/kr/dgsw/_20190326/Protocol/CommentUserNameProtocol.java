package hs.kr.dgsw._20190326.Protocol;

import hs.kr.dgsw._20190326.Domain.Comment;
import lombok.Data;

@Data
public class CommentUserNameProtocol extends Comment {
    private String userName;

    public CommentUserNameProtocol(Comment comment, String userName) {
        super(comment);
        this.userName = userName;
    }
}
