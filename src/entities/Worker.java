package entities;

import entities.enums.WorkerLevel;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Worker {
    private String name;
    private WorkerLevel level;
    private Double baseSalary;
    private Department department;
    private List<HourContract> contractList;

    public Worker() {
    }

    public Worker(String name, WorkerLevel level, Double baseSalary, Department department, List<HourContract> contractList) {
        this.name = name;
        this.level = level;
        this.baseSalary = baseSalary;
        this.department = department;
        this.contractList = contractList;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public WorkerLevel getLevel() {
        return level;
    }

    public void setLevel(WorkerLevel level) {
        this.level = level;
    }

    public Double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(Double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public List<HourContract> getContractList() {
        return contractList;
    }

    public void addContract(HourContract contract) {
        contractList.add(contract);
    }

    public void removeContract(HourContract contract) {
        contractList.remove(contract);
    }

    public Double income(Integer year, Integer month) {
        Double totalIncome = this.baseSalary;
        for (HourContract hc : contractList) {
            LocalDate date = hc.getDate();
            if (date.getMonthValue() == month && date.getYear() == year) {
                totalIncome += hc.totalValue();
            }
        }
        return totalIncome;
    }


}
