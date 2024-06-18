package dev.forcecodes.doggos;

class NotFoundException extends RuntimeException {

  public NotFoundException(String name) {
    super("%s not found".formatted(name));
  }
}
