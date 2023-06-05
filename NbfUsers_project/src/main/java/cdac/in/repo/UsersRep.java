package cdac.in.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.in.module.Users;

@Repository
public interface UsersRep extends JpaRepository<Users, String> {

}
