package br.com.felipec.rabbitspringeventspoc.threads;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import lombok.Getter;

@Getter
public class TimeGather extends Thread {

  private final LocalDateTime finalTime;
  private LocalDateTime timeNow;
  private Boolean status = true;

  @Getter
  private Long remainingTime;

  public TimeGather(Integer seconds) {
    this.timeNow = LocalDateTime.now();
    this.finalTime = LocalDateTime.now().plusSeconds(seconds);
    start();
  }

  @Override
  public void run() {
    while (timeNow.isBefore(finalTime)) {
      timeNow = LocalDateTime.now();
      remainingTime = timeNow.until(finalTime, ChronoUnit.SECONDS);
    }
    this.status = false;
  }

}
