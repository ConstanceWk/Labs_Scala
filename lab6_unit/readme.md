# Lab 6 - Scala Unit & Integration Testing

This project contains unit and integration tests for various Scala modules, including service logic, file processing, property-based testing, mocking, stubbing, and end-to-end testing.

## Prerequisites

You need to have [SDKMAN!](https://sdkman.io/) installed in order to easily manage Java versions.

### 1. Install SDKMAN

```bash
curl -s "https://get.sdkman.io" | bash
source "$HOME/.sdkman/bin/sdkman-init.sh"
```

### 2. Install Java 21 (Temurin)

```bash
sdk install java 21.0.3-tem
sdk use java 21.0.3-tem
```

> Note: Java 21 is required to ensure compatibility with test frameworks and dependencies.

---

## Running the Project

Once Java 21 is installed and selected, run the following commands to clean, compile, and test the project:

```bash
sbt clean compile test
```

This will:

- Remove all compiled artifacts
- Compile all source and test files
- Run all unit and integration tests using ScalaTest and ZIO Test

---

## Project Structure

- `src/main/scala` — main Scala source files
- `src/test/scala` — unit and integration test suites

---

## Common Issues

If you're using Java 23 or later, Mockito or ByteBuddy may throw errors during mocking or spying. Always ensure you are using **Java 21** with:

```bash
sdk use java 21.0.3-tem
```

---

## Contact

For questions or support, please contact the repository maintainer.

