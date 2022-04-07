package br.com.felipec.rabbitspringeventspoc.service.rabbitmq;

import br.com.felipec.rabbitspringeventspoc.model.repository.rabbitmq.RabbitMessage;
import br.com.felipec.rabbitspringeventspoc.model.repository.rabbitmq.RabbitMessageRepository;
import java.util.UUID;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class RabbitService {

  private final RabbitMessageRepository rabbitMessageRepository;

  private final AmqpTemplate amqpTemplate;

  @Autowired
  public RabbitService(RabbitMessageRepository rabbitMessageRepository, AmqpTemplate amqpTemplate) {
    this.rabbitMessageRepository = rabbitMessageRepository;
    this.amqpTemplate = amqpTemplate;
  }

  public void sendMessage() {
    amqpTemplate.convertAndSend("Caller", UUID.randomUUID().toString());
  }

  @Transactional
  @RabbitListener(queues = "Caller")
  private void listenMessage(String message) {
    try {
      rabbitMessageRepository.save(new RabbitMessage(null, message));
    } catch (Exception exception) {
    }
  }

}
