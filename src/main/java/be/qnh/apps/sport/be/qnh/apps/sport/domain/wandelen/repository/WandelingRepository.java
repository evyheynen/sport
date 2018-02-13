package be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.repository;

import be.qnh.apps.sport.be.qnh.apps.sport.domain.wandelen.service.Wandeling;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WandelingRepository extends JpaRepository<Wandeling, Long> {

}
