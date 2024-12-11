import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AppService {
    final private CommonUtil commonUtil = new CommonUtil();
    final private String filePath = "database.csv";
    List<Expense> expenses = new ArrayList<>();

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

    public void readDatas() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;

            line = reader.readLine();

            while ((line = reader.readLine()) != null) {
                String[] fields = line.split(",");
                int id = Integer.parseInt(fields[0].trim());
                String date = fields[1].trim();
                String description = fields[2].trim();
                int amount = Integer.parseInt(fields[3].trim());

                LocalDate convertedDate = commonUtil.convertStringToLocalDate(date);

                expenses.add(new Expense(id, convertedDate, description, amount));
            }
        } catch (IOException e) {

        }
    }

    public void saveDatas(List<Expense> expenses) {
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
