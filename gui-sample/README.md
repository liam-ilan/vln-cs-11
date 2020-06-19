# GUI Sample

## Running the Compiled JAR
To run a built jar of this program, you will need to run the following command through the terminal/command line.
``` bash
  java --module-path <Path to JavaFx, should be a lib directory> --add-modules javafx.controls,javafx.fxml -jar <Path to jar>
```
In version 14, javaFX jars, and the javaFX runtime are not bundled in with the built jar.

## Running through Intellij
To run this program through intellij, add this to your VM options:
``` bash
  --module-path <Path to JavaFx, should be a lib directory> --add-modules javafx.controls,javafx.fxml
```