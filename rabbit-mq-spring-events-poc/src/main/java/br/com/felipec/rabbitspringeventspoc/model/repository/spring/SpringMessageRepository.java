package br.com.felipec.rabbitspringeventspoc.model.repository.spring;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpringMessageRepository extends JpaRepository<SpringMessage, Long> {

}
