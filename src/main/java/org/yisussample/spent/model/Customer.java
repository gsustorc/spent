package org.yisussample.spent.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString()
@Builder
public class Customer {

  @Id public String id;

  public String firstName;
  public String lastName;
}
