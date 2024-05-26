import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;

class FileReadWrite {
    public static void main(String[] args) {
        String filename = "data.txt"; // Ім'я файлу
        int min = 1;
        int max = 100;
        int count = 10;

        // Запис даних у файл
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            Random random = new Random();
            System.out.println("Writing data to the file...");
            for (int i = 0; i < count; i++) {
                int randomNumber = random.nextInt(max - min + 1) + min;
                writer.write(randomNumber + "\n");
                System.out.println("Data written to file: " + randomNumber);
            }
            System.out.println("Data has been written to the file successfully.");

            // Читання даних з файлу та виведення їх на консоль
            try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
                String line;
                System.out.println("Data read from the file:");
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                System.out.println("An error occurred while reading from the file: " + e.getMessage());
            }
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file: " + e.getMessage());
        }
    }
}
