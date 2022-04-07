package br.com.felipec.rabbitspringeventspoc.model.repository.spring;

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
@Table(name = "spring_messages")
@AllArgsConstructor
@NoArgsConstructor
public class SpringMessage {

  @Id
  @GeneratedValue
  @Column(name = "id")
  private Long id;

  @Column(name = "spring_message")
  private String message;
}
