package br.com.felipec.rabbitspringeventspoc.model.repository.rabbitmq;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RabbitMessageRepository extends JpaRepository<RabbitMessage, Long> {

}
