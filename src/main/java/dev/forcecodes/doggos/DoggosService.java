package dev.forcecodes.doggos;

import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
final class DoggosService {

  private final DoggosRepository repository;
  private final DoggosMapper doggosMapper;

  public List<DoggosDto> doggosDtoList(String name) {
    return repository.findDoggosByName(name).orElseThrow(() -> new NotFoundException(name));
  }

  public List<DoggosDto> getDoggosByBreed(String breed) throws NotFoundException {
    return repository.findDoggosByBreed(breed).orElseThrow(() -> new NotFoundException(breed));
  }

  public List<DoggosDto> getAllDoggos() {
    return doggosMapper.doggosDtoToDoggos(repository.findAll());
  }
}
