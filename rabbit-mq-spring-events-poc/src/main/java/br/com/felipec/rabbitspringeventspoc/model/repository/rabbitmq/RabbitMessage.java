package br.com.felipec.rabbitspringeventspoc.model.repository.rabbitmq;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "rabbit_messages")
@AllArgsConstructor
@NoArgsConstructor
public class RabbitMessage {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "rabbit_message")
  private String message;
}
