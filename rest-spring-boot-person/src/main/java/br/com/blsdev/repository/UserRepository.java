package br.com.blsdev.repository;

import br.com.blsdev.data.model.Person;
import br.com.blsdev.data.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u from User u where u.userName =:userName" )
    User findByUsername(@Param("userName") String userName);
}
