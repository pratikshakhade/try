package cdac.in.repositry;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cdac.in.module.RegistartionParlour;

@Repository
public interface RegistrationParlourRep extends JpaRepository<RegistartionParlour, Integer> {

}
