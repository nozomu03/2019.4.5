package hs.kr.dgsw._20190326.Service.User;

import hs.kr.dgsw._20190326.Domain.User;
import hs.kr.dgsw._20190326.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> list() {
        return this.userRepository.findAll();
    }

    @Override
    public User view(String email) {
        return this.userRepository.findByEmail(email);
    }

    @Override
    public User add(User user) {
        User found = this.userRepository.findByEmail(user.getEmail());
        if(found != null){
            return null;
        }
        return this.userRepository.save(user);
    }

    @Override
    public boolean delete(Long id) {
        try{
            this.userRepository.deleteById(id);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    @Override
    public User update(Long id, User user) {
        return this.userRepository.findById(id)
            .map(found -> {
                if(user.getEmail() != null) found.setEmail(user.getEmail());
                if(user.getUserName() != null) found.setUserName(user.getUserName());
                found.setLocation(user.getLocation());
                found.setFileN(user.getFileN());
                this.userRepository.save(found);
                return found;
            })
            .orElse(null);
    }
}
