package br.com.felipec.rabbitspringeventspoc.api;

import br.com.felipec.rabbitspringeventspoc.model.Result;
import br.com.felipec.rabbitspringeventspoc.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class ResultController {

  @Autowired
  private ResultService resultService;

  @GetMapping("/result")
  public ResponseEntity<Result> getPocBenchmark() {
    return new ResponseEntity<>(resultService.getPocResult(), HttpStatus.OK);
  }

}
