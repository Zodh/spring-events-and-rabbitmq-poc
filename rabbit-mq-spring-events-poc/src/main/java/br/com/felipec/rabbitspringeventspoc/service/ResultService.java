package br.com.felipec.rabbitspringeventspoc.service;

import br.com.felipec.rabbitspringeventspoc.model.Result;
import br.com.felipec.rabbitspringeventspoc.service.rabbitmq.RabbitService;
import br.com.felipec.rabbitspringeventspoc.service.spring.events.SpringEventService;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResultService {

  private final SpringEventService springEventService;

  private final RabbitService rabbitService;

  @Autowired
  public ResultService(SpringEventService springEventService, RabbitService rabbitService) {
    this.springEventService = springEventService;
    this.rabbitService = rabbitService;
  }

  public Result getPocResult() {
    var numberOfEvents = 500;

    var initialTimeSpringEvent = LocalDateTime.now();
    System.out.println("Spring Events Starting");
    for (var i = 0; i <= numberOfEvents; i++) {
      springEventService.publishSpringMessage();
    }
    System.out.println("Spring Events Finishing");
    var finalTimeSpringEvent = LocalDateTime.now();
    var springTime = ChronoUnit.MILLIS.between(initialTimeSpringEvent, finalTimeSpringEvent);

    var initialTimeRabbit = LocalDateTime.now();
    System.out.println("RabbitMQ Starting");
    for (var i = 0; i <= numberOfEvents; i++) {
      rabbitService.sendMessage();
    }
    System.out.println("RabbitMQ Finishing");
    var finalTimeRabbit = LocalDateTime.now();
    var rabbitTime = ChronoUnit.MILLIS.between(initialTimeRabbit, finalTimeRabbit);

    var result = new Result(rabbitTime, 1L, numberOfEvents);
    System.out.println(result);
    return result;
  }
}
