package hs.kr.dgsw._20190326.Service.User;

import hs.kr.dgsw._20190326.Domain.User;

import java.util.List;

public interface UserService {
    List<User> list();
    User view(String email);
    User add(User user);
    boolean delete(Long id);
    User update(Long id, User user);
}
