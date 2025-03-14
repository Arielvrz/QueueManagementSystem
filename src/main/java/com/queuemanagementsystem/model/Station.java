package com.queuemanagementsystem.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Represents a physical station where employees attend to clients.
 */
public class Station {
    private int id;
    private int number;
    private String status; // "OPEN", "CLOSED"
    private Employee assignedEmployee;
    private List<Category> supportedCategories;

    /**
     * Default constructor
     */
    public Station() {
        this.status = "CLOSED";
        this.supportedCategories = new ArrayList<>();
    }

    /**
     * Parameterized constructor with essential fields
     *
     * @param id Station's unique identifier
     * @param number Station's display number
     */
    public Station(int id, int number) {
        this.id = id;
        this.number = number;
        this.status = "CLOSED";
        this.supportedCategories = new ArrayList<>();
    }

    /**
     * Complete constructor with all fields
     *
     * @param id Station's unique identifier
     * @param number Station's display number
     * @param status Station's operational status
     * @param assignedEmployee Employee assigned to this station
     */
    public Station(int id, int number, String status, Employee assignedEmployee) {
        this.id = id;
        this.number = number;
        this.status = status;
        this.assignedEmployee = assignedEmployee;
        this.supportedCategories = new ArrayList<>();
    }

    /**
     * Opens the station for service
     *
     * @return true if the station was opened successfully, false otherwise
     */
    public boolean openStation() {
        if (assignedEmployee != null) {
            this.status = "OPEN";
            return true;
        }
        return false;
    }

    /**
     * Closes the station
     *
     * @return true indicating the station was closed
     */
    public boolean closeStation() {
        this.status = "CLOSED";
        return true;
    }

    /**
     * Adds a service category to this station
     *
     * @param category The category to add
     * @return true if the category was added successfully, false otherwise
     */
    public boolean addCategory(Category category) {
        if (category != null && !supportedCategories.contains(category)) {
            return supportedCategories.add(category);
        }
        return false;
    }

    /**
     * Removes a service category from this station
     *
     * @param category The category to remove
     * @return true if the category was removed successfully, false otherwise
     */
    public boolean removeCategory(Category category) {
        return supportedCategories.remove(category);
    }

    /**
     * Checks if this station supports a specific category
     *
     * @param category The category to check
     * @return true if the station supports the category, false otherwise
     */
    public boolean supportsCategory(Category category) {
        return supportedCategories.contains(category);
    }

    // Getters and Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee employee) {
        this.assignedEmployee = employee;
        if (employee != null) {
            employee.setAssignedStation(this);
        }
    }

    public List<Category> getSupportedCategories() {
        return new ArrayList<>(supportedCategories);  // Return a copy to maintain encapsulation
    }

    /**
     * Compares this Station to another object for equality
     *
     * @param o The object to compare with
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Station station = (Station) o;
        return id == station.id;
    }

    /**
     * Generates a hash code for this Station
     *
     * @return The hash code
     */
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    /**
     * Returns a string representation of this Station
     *
     * @return A string representation
     */
    @Override
    public String toString() {
        return "Station{" +
                "id=" + id +
                ", number=" + number +
                ", status='" + status + '\'' +
                ", employee=" + (assignedEmployee != null ? assignedEmployee.getName() : "None") +
                ", supportedCategories=" + supportedCategories.size() +
                '}';
    }
}