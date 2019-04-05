package hs.kr.dgsw._20190326.Service.Comment;

import hs.kr.dgsw._20190326.Domain.Comment;
import hs.kr.dgsw._20190326.Repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentRepository commentRepository;

    @Override
    public Comment add(Comment comment) {
        if(comment.getContent()!=null)
            return commentRepository.save(comment);
        else
            return null;

    }

    @Override
    public Comment update(Long id, Comment comment) {
        return this.commentRepository.findById(id)
            .map(found -> {
                if(comment.getContent() == null) return null;
                found.setContent(comment.getContent());
                return this.commentRepository.save(found);
            })
            .orElse(null);
    }

    @Override
    public boolean delete(Long id){
        return this.commentRepository.findById(id)
            .map(found -> {
                this.commentRepository.deleteById(id);
                return true;
            })
            .orElse(false);
    }
}
