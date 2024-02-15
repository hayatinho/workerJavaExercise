package application;

import entities.Department;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = scanner.nextLine();
        System.out.println("Enter worker data:");
        System.out.print("Name: ");
        String workerName = scanner.nextLine();
        System.out.print("Level: ");
        WorkerLevel level = WorkerLevel.valueOf(scanner.nextLine().toUpperCase());
        System.out.print("Base salary: ");
        Double baseSalary = Double.parseDouble(scanner.nextLine());

        Worker worker = new Worker(workerName, level, baseSalary, new Department(departmentName), new ArrayList<>());

        System.out.print("How many contracts to this worker? ");
        Integer contracts = Integer.parseInt(scanner.nextLine());

        for (int i = 1; i <= contracts; i++) {
            HourContract hc = new HourContract();
            System.out.println("Enter contract #" + i + " data: ");
            System.out.print("Date (DD/MM/YYYY): ");
            hc.setDate(LocalDate.parse(scanner.nextLine(), fmt));
            System.out.print("Value per hour: ");
            hc.setValuePerHour(Double.parseDouble(scanner.nextLine()));
            System.out.print("Duration (hours): ");
            hc.setHours(Integer.parseInt(scanner.nextLine()));
            worker.addContract(hc);
        }

        System.out.println();

        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = scanner.nextLine();
        Integer month = Integer.parseInt(monthAndYear.substring(0, 2));
        Integer year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Department: " + worker.getDepartment().getName());
        System.out.println("Income for " + monthAndYear + ": " + String.format("%.2f", worker.income(year, month)));
    }
}
