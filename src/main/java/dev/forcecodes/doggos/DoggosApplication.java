package dev.forcecodes.doggos;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.nio.charset.Charset;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

@Slf4j
@AllArgsConstructor
@SpringBootApplication
class DoggosApplication {

  private final DoggosRepository doggosRepository;

  public static void main(String[] args) {
    SpringApplication.run(DoggosApplication.class, args);
  }

  @Component
  private class DoggosCLIRunner implements CommandLineRunner {

    @Value("classpath:/doggos.txt")
    private Resource doggosFile;

    private static final Charset DEFAULT_CHARSET = Charset.defaultCharset();

    @Override
    public void run(String... args) throws IOException {
      log.info("Running SimpleCommandLineRunner");
      try (Reader reader = new InputStreamReader(doggosFile.getInputStream(), DEFAULT_CHARSET)) {
        final BufferedReader br = new BufferedReader(reader);
        String line;
        while ((line = br.readLine()) != null) {
          final String[] parts = line.split(":");
          final String name = parts[0].trim();
          final String breed = parts[1].trim();
          doggosRepository.save(new Doggos(name, breed));
        }
      }
    }
  }
}
