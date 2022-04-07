package br.com.felipec.rabbitspringeventspoc.service.spring.events;

import br.com.felipec.rabbitspringeventspoc.model.spring.event.MessageSpringEvent;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;


@Service
public class SpringEventService {

  private final ApplicationEventPublisher applicationEventPublisher;

  @Autowired
  public SpringEventService(ApplicationEventPublisher applicationEventPublisher) {
    this.applicationEventPublisher = applicationEventPublisher;
  }

  public void publishSpringMessage() {
    applicationEventPublisher.publishEvent(
        new MessageSpringEvent(this, UUID.randomUUID().toString()));
  }

}
