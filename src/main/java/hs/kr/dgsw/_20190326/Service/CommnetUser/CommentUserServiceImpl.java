package hs.kr.dgsw._20190326.Service.CommnetUser;

import hs.kr.dgsw._20190326.Domain.Comment;
import hs.kr.dgsw._20190326.Domain.User;
import hs.kr.dgsw._20190326.Protocol.CommentUserNameProtocol;
import hs.kr.dgsw._20190326.Repository.CommentRepository;
import hs.kr.dgsw._20190326.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CommentUserServiceImpl implements CommentUserService {

    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private UserRepository userRepository;

    @PostConstruct
    public void init(){
        User u = new User("weg", "weg@ggg", null, null);
        this.userRepository.save(u);
        this.commentRepository.save(new Comment(u.getId(), "wegwegewg"));
    }
    @Override
    public List<CommentUserNameProtocol> listAllComments() {
        List<Comment> commentList = this.commentRepository.findAll();
        List<CommentUserNameProtocol> cupList = new ArrayList<>();
        commentList.forEach(comment -> {
            Optional<User> found = this.userRepository.findById(comment.getUserId());
            String userName = (found.isPresent()) ? found.get().getUserName() : null;
            cupList.add(new CommentUserNameProtocol(comment, userName));
        });
        return cupList;
    }

    @Override
    public CommentUserNameProtocol view(Long id) {
        Optional<Comment> foundComment = this.commentRepository.findById(id);
        if(foundComment.isPresent()){
            Optional<User> foundUser = this.userRepository.findById(foundComment.get().getUserId());
            String userName = (foundUser.isPresent()) ? foundUser.get().getUserName() : null;
            return new CommentUserNameProtocol(foundComment.get(), userName);
        }
        return null;
    }
}
