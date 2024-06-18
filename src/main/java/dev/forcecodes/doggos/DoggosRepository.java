package dev.forcecodes.doggos;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DoggosRepository extends JpaRepository<Doggos, Integer> {

  Optional<List<DoggosDto>> findDoggosByName(String name);

  Optional<List<DoggosDto>> findDoggosByBreed(String breed);

}
