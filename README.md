# Expense Tracker (Java)

Expense Tracker is a expense management application. You can create, view, edit, delete, summary expenses. This project is an assignment for the link (https://roadmap.sh/projects/expense-tracker).

## Usage

`git clone https://github.com/ehdrb92/expense-tracker-java.git`

`cd expense-tracker-java/src`
`javac App.java`

- add expense: `java App add --description {description_value} --amount {amount_value}`
- get expenses: `java App list`
- update expense: `java App update {id} --{option} {option_value}`
  - option: date, description, amount
- delete expense: `java App delete {id}`
- summary expense: `java App summary --month {month}`
  - month option is optional