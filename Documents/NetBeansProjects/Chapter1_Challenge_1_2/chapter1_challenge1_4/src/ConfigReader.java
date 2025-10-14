
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ConfigReader {

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new FileReader("config.txt"))) {

            String versionLine = reader.readLine();
            int configVersion = Integer.parseInt(versionLine);

            if (configVersion < 2) {
                throw new Exception("Config version too old!");
            }

            String filePath = reader.readLine();
            File file = new File(filePath);
            if (!file.exists()) {
                throw new IOException("File at config path does not exist: " + filePath);
            }

            System.out.println("Config file read successfully.");

        } catch (FileNotFoundException e) {
            System.out.println("Error: config.txt file not found.");
        } catch (IOException e) {
            System.out.println("Error: I/O issue occurred - " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error: Config version is not a valid number.");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Config read attempt finished.");
        }
    }
}
