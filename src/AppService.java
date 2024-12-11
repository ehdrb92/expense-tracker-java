import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class AppService {
    final String filePath = "database.csv";

    public void initApplication() {
        File file = new File(filePath);

        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void saveData(List<Expense> expenses) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            writer.write("ID,Date,Description,Amount");
            writer.newLine();

            for (Expense expense: expenses) {
                String line = expense.getId() + "," + expense.getDate() + "," + expense.getDescription() + "," + expense.getAmount();
                writer.write(line);
                writer.newLine();
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
