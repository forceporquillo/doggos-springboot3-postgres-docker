package dev.forcecodes.doggos;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/doggos")
final class DoggosController {

  private final DoggosService doggosService;

  @GetMapping("/{name}")
  public ResponseEntity<List<DoggosDto>> findAllByName(@PathVariable String name) {
    return ResponseEntity.ok(doggosService.doggosDtoList(name));
  }

  @GetMapping("/breed/{type}")
  public ResponseEntity<List<DoggosDto>> findByBreed(@PathVariable String type) {
    return ResponseEntity.ok(doggosService.getDoggosByBreed(type));
  }

  @GetMapping
  public ResponseEntity<List<DoggosDto>> findAllDoggos() {
    return ResponseEntity.ok(doggosService.getAllDoggos());
  }
}
