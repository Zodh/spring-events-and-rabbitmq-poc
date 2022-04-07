package br.com.felipec.rabbitspringeventspoc.model.spring.event;

import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class MessageSpringEvent extends ApplicationEvent {

  private final String message;

  public MessageSpringEvent(Object source, String message) {
    super(source);
    this.message = message;
  }
}
