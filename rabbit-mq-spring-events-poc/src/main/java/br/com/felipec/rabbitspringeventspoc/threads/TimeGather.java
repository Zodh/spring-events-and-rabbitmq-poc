package br.com.felipec.rabbitspringeventspoc.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Getter;

@Getter
public class TimeGather extends Thread {

  private final LocalDateTime finalTime;
  private LocalDateTime timeSpent;
  private Boolean status = true;

  @Getter
  private Long remainingTime;

  public TimeGather(Integer seconds) {
    this.timeSpent = LocalDateTime.now();
    this.finalTime = LocalDateTime.now().plusSeconds(seconds);
    start();
  }

  @Override
  public void run() {
    while (timeSpent.isBefore(finalTime)) {
      timeSpent = LocalDateTime.now();
      remainingTime = timeSpent.until(finalTime, ChronoUnit.SECONDS);
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
    this.status = false;
  }

}
