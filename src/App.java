import java.time.LocalDate;

public class App {
    private static final AppService appService = new AppService();

    public static void main(String[] args) throws Exception {
        appService.initApplication();
        appService.readDatas();

        switch (args[0]) {
            case "add":
                int id = ++appService.lastId;
                LocalDate nowDate = LocalDate.now();
                String description = args[2];
                int amount = Integer.parseInt(args[4]);
                Expense expense = new Expense(id, nowDate, description, amount);
                appService.createExpense(expense);
                break;
            case "list":
                appService.getExpenses();
                break;
            case "update":
                break;
            case "delete":
                break;
            case "summary":
                break;
            default:
                break;
        }

        appService.saveDatas();
    }
}
