package hs.kr.dgsw._20190326.Service.CommnetUser;

import hs.kr.dgsw._20190326.Protocol.CommentUserNameProtocol;

import java.util.List;

public interface CommentUserService {
    List<CommentUserNameProtocol> listAllComments();
    CommentUserNameProtocol view(Long id);
}
