/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bugreportapplication;
import javax.swing.*;
/**
 *
 * @author sonma
 */

//might not be needed
public class bugReport {
    private String title;
    private String description;
    private String priority;
    
    public bugReport(String title, String description,String priority){
        this.title = title;
        this.description = description;
        this.priority = priority;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
    
}
