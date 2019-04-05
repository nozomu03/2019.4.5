package hs.kr.dgsw._20190326.Controller;

import hs.kr.dgsw._20190326.Domain.Comment;
import hs.kr.dgsw._20190326.Protocol.CommentUserNameProtocol;
import hs.kr.dgsw._20190326.Service.Comment.CommentService;
import hs.kr.dgsw._20190326.Service.CommnetUser.CommentUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentController {

    @Autowired
    private CommentUserService commentUserService;
    @Autowired
    private CommentService commentService;

    @GetMapping("/comment")
    public List<CommentUserNameProtocol> list() {
        return this.commentUserService.listAllComments();
    }

    @GetMapping("/comment/{id}")
    public CommentUserNameProtocol view(@PathVariable Long id){
        return this.commentUserService.view(id);
    }

    @PostMapping("/comment")
    public Comment add(@RequestBody Comment comment){
        return this.commentService.add(comment);
    }

    @PutMapping("/comment/{id}")
    public Comment update(@PathVariable Long id, @RequestBody Comment comment){
        return this.commentService.update(id, comment);
    }

    @DeleteMapping("/comment/{id}")
    public boolean delete(@PathVariable Long id){
        return this.commentService.delete(id);
    }
}
