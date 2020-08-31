Steps for execution:
1. Unzip the zip file.
2. Build the tool -
   Project_Directory> mvn package
3. Run the tool -
   Syntax:  Project_Directory> java -cp <jar file name> <main class name> arguments
   Example: Project_Directory> java -cp target\CO2_Calculator-1.0-SNAPSHOT.jar org.example.App --transportation-method medium-diesel-car --distance 15 --unit-of-distance km