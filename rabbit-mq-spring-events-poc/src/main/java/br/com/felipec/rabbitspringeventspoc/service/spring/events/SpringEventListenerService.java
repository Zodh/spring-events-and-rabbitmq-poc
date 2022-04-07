package br.com.felipec.rabbitspringeventspoc.service.spring.events;

import br.com.felipec.rabbitspringeventspoc.model.repository.spring.SpringMessage;
import br.com.felipec.rabbitspringeventspoc.model.repository.spring.SpringMessageRepository;
import br.com.felipec.rabbitspringeventspoc.model.spring.event.MessageSpringEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Service;

@Service
public class SpringEventListenerService implements ApplicationListener<MessageSpringEvent> {

  @Autowired
  private SpringMessageRepository springMessageRepository;

  @Override
  public void onApplicationEvent(MessageSpringEvent event) {
    try {
      springMessageRepository.save(new SpringMessage(null, event.getMessage()));
    } catch (Exception exception) {

    }
  }
}
