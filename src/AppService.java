import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
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
            System.out.println(e.getMessage());
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

    public void createExpense(Expense expense) {
        expenses.add(expense);
        System.out.println("Expense added successfully" + "(ID " + expense.getId() + ")");
    }

    public void getExpenses() {
        System.out.println("ID  Date      Description  Amount");
        for (Expense expense: expenses) {
            System.out.print(expense.getId());
            System.out.print(expense.getDate().toString());
            System.out.print(expense.getDescription());
            System.out.print("$" + expense.getAmount());
            System.out.println();
        }
        return;
    }

    public void updateExpenseDate(int id, String date) {
        for (Expense expense: expenses) {
            if (id == expense.getId()) {
                expense.setDate(commonUtil.convertStringToLocalDate(date));
                System.out.println("Expense updated successfully" + "(ID " + id + ")");
                return;
            }
        }
        System.out.println("Not found expense" + "(ID " + id + ")");
        return;
    }

    public void updateExpenseDescription(int id, String description) {
        for (Expense expense: expenses) {
            if (id == expense.getId()) {
                expense.setDescription(description);
                System.out.println("Expense updated successfully" + "(ID " + id + ")");
                return;
            }
        }
        System.out.println("Not found expense" + "(ID " + id + ")");
        return;
    }

    public void updateExpenseAmount(int id, int amount) {
        for (Expense expense: expenses) {
            if (id == expense.getId()) {
                expense.setAmount(amount);
                System.out.println("Expense updated successfully" + "(ID " + id + ")");
                return;
            }
        }
        System.out.println("Not found expense" + "(ID " + id + ")");
        return;
    }

    public void deleteExpense(int id) {
        Iterator<Expense> iterator = expenses.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getId() == 1) {
                iterator.remove();
                System.out.println("Expense deleted successfully" + "(ID " + id + ")");
                return;
            }
        }
        System.out.println("Not found expense" + "(ID " + id + ")");
        return;
    }
}
