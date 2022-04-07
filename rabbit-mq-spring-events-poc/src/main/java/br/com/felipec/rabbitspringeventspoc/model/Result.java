package br.com.felipec.rabbitspringeventspoc.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
public class Result {

  private final Long rabbitTimeSpentInMs;
  private final Long springTimeSpentInMs;
  private final Integer numberOfEvents;

  public Result(Long rabbitTimeSpentInMs, Long springTimeSpentInMs, Integer numberOfEvents) {
    this.rabbitTimeSpentInMs = rabbitTimeSpentInMs;
    this.springTimeSpentInMs = springTimeSpentInMs;
    this.numberOfEvents = numberOfEvents;
  }

  @Override
  public String toString() {
    try {
      return new ObjectMapper().writeValueAsString(this);
    } catch (Exception exception) {
      return null;
    }
  }
}
