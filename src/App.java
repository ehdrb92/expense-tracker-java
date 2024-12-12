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
                switch (args[2]) {
                    case "--date":
                        appService.updateExpenseDate(Integer.parseInt(args[1]), args[3]);
                        break;
                    case "--description":
                        appService.updateExpenseDescription(Integer.parseInt(args[1]), args[3]);
                        break;
                    case "--amount":
                        appService.updateExpenseAmount(Integer.parseInt(args[1]), Integer.parseInt(args[3]));
                        break;
                    default:
                        System.out.println("Check update option");
                        break;
                }
                break;
            case "delete":
                appService.deleteExpense(Integer.parseInt(args[1]));
                break;
            case "summary":
                if (args.length == 1) {
                    appService.summaryExpense();
                } else {
                    appService.summaryExpenseWithMonth(Integer.parseInt(args[2]));
                }
                break;
            default:
                System.out.println("check main command option");
                System.out.println("main option: add, list, update, delete, summary");
                break;
        }

        appService.saveDatas();
    }
}
