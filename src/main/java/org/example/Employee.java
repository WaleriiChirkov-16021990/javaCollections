package org.example;

import java.util.Objects;

public class Employee {
    private int personnelNumber;
    private String name;
    private int experience;
    private int mobNumber;

    public Employee(int personnelNumber, String name, int experience, int mobNumber) {
        this.personnelNumber = personnelNumber;
        this.name = name;
        this.experience = experience;
        this.mobNumber = mobNumber;
    }

    public Employee() {
    }

    public int getPersonnelNumber() {
            return personnelNumber;
    }

    public void setPersonnelNumber(int personnelNumber) {
        this.personnelNumber = personnelNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getExperience() {
        return experience;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public int getMobNumber() {
        return mobNumber;
    }

    public void setMobNumber(int mobNumber) {
        this.mobNumber = mobNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Employee)) return false;
        Employee employee = (Employee) o;
        return getPersonnelNumber() == employee.getPersonnelNumber() && getMobNumber() == employee.getMobNumber();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getPersonnelNumber(), getMobNumber());
    }
}
