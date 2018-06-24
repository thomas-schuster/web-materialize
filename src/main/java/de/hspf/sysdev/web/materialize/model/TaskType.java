package de.hspf.sysdev.web.materialize.model;

/**
 *
 * @author thomas.schuster
 */
public enum TaskType {
    EPIC ("Epic"), 
    USERSTORY ("User Story"), 
    TASK ("Task"), 
    SUBTASK ("Sub Task");

    private TaskType(String label) {
        this.label = label;
    }
    private String label;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    
    
}
