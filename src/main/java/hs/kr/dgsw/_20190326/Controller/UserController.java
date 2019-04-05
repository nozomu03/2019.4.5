package hs.kr.dgsw._20190326.Controller;

import hs.kr.dgsw._20190326.Domain.User;
import hs.kr.dgsw._20190326.Service.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/user")
    @ResponseBody
    public List<User> list() {
        return this.userService.list();
    }

    @GetMapping("/user/{email}")
    @ResponseBody
    public User view(@PathVariable String email) {
        return this.userService.view(email);
    }

    @PostMapping("/user")
    @ResponseBody
    public User add(@RequestBody User user){
        return this.userService.add(user);
    }

    @DeleteMapping("/user/{id}")
    @ResponseBody
    public boolean delete(@PathVariable Long id) {
        return this.userService.delete(id);
    }

    @PutMapping("/user/{id}")
    @ResponseBody
    public User update(@PathVariable Long id, @RequestBody User user){
        return this.userService.update(id, user);
    }
}
