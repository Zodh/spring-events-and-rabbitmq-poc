package br.com.felipec.rabbitspringeventspoc.service;

import br.com.felipec.rabbitspringeventspoc.model.Result;
import br.com.felipec.rabbitspringeventspoc.service.rabbitmq.RabbitService;
import br.com.felipec.rabbitspringeventspoc.service.spring.events.SpringEventService;
import br.com.felipec.rabbitspringeventspoc.threads.TimeGather;
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
    var springPublishedMessages = 0;
    var springTimer = new TimeGather(5);
    var initialTimeSpringEvent = LocalDateTime.now();
    System.out.println("Spring Events Starting");
    while (Boolean.TRUE.equals(springTimer.getStatus())) {
      springEventService.publishSpringMessage();
      springPublishedMessages++;
    }
    System.out.println(springPublishedMessages);
    System.out.println("Spring Events Finishing");
    var finalTimeSpringEvent = LocalDateTime.now();
    var springTime = ChronoUnit.MILLIS.between(initialTimeSpringEvent, finalTimeSpringEvent);

    var rabbitMessagesSent = 0;
    var rabbitTimer = new TimeGather(5);
    var initialTimeRabbit = LocalDateTime.now();
    System.out.println("RabbitMQ Starting");
    while (Boolean.TRUE.equals(rabbitTimer.getStatus())) {
      rabbitService.sendMessage();
      rabbitMessagesSent++;
    }
    System.out.println(rabbitMessagesSent);
    System.out.println("RabbitMQ Finishing");
    var finalTimeRabbit = LocalDateTime.now();
    var rabbitTime = ChronoUnit.MILLIS.between(initialTimeRabbit, finalTimeRabbit);

    var result = new Result(springPublishedMessages, rabbitMessagesSent, rabbitTime, springTime);
    System.out.println(result);
    return result;
  }
}
