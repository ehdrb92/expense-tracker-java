import java.time.LocalDate;

public class Expense {
    private int id;
    private LocalDate date;
    private String description;
    private int amount;
    
    public Expense(int id, LocalDate date, String description, int amount) {
        this.id = id;
        this.date = date;
        this.description = description;
        this.amount = amount;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return this.date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getAmount() {
        return this.amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
