package br.com.felipec.rabbitspringeventspoc.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

@Getter
public class Result {

  private final Integer sePublishedMessages;
  private final Integer rabbitPublishedMessages;
  private final Long rabbitTimeSpentInMs;
  private final Long springTimeSpentInMs;

  public Result(Integer sePublishedMessages, Integer rabbitPublishedMessages,
      Long rabbitTimeSpentInMs, Long springTimeSpentInMs) {
    this.sePublishedMessages = sePublishedMessages;
    this.rabbitPublishedMessages = rabbitPublishedMessages;
    this.rabbitTimeSpentInMs = rabbitTimeSpentInMs;
    this.springTimeSpentInMs = springTimeSpentInMs;
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
