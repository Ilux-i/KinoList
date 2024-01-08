package org.example.repository;

import org.example.entity.UserEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {

    @Query(value = "select * from kino_list where name =: username", nativeQuery = true)
    UserEntity findByName(String username);

}
