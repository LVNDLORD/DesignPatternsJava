public class Main {
    public static void main(String[] args) {
        NewDateInterface dateAdapter = new CalendarToNewDateAdapter();

        // Set date to 9th of April, 2024
        dateAdapter.setYear(2024);
        dateAdapter.setMonth(4);
        dateAdapter.setDay(9);

        System.out.println("Original date: " +
                dateAdapter.getDay() + "." +
                dateAdapter.getMonth() + "." +
                dateAdapter.getYear());

        dateAdapter.advanceDays(22);

        System.out.println("New date: " +
                dateAdapter.getDay() + "." +
                dateAdapter.getMonth() + "." +
                dateAdapter.getYear());
    }
}

