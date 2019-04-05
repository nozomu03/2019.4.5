package hs.kr.dgsw._20190326.Repository;

import hs.kr.dgsw._20190326.Domain.User;
import org.springframework.data.jpa.repository.JpaRepository;


public interface UserRepository extends JpaRepository<User, Long> {
   User findByEmail(String email);
   void deleteById(Long id);
}
