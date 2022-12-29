package fr.openobservatory.backend.dtos;

import lombok.Data;

@Data
public class ResponseDTO {

  public ResponseDTO(String message) {
    this.message = message;
  }

  public ResponseDTO(Object payload) {
    this.payload = payload;
  }

  private String status = "success";
  private String message;
  private Object payload;
}
