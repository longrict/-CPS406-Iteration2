/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package bugreportapplication;
import lombok.Data;

import javax.swing.*;
import java.util.ArrayList;

/**
 *
 * @author sonma
 */

@Data
//might not be needed
public class bugReport {
    private String title;
    private String description;
    private PriorityEnum priority;
    public enum PriorityEnum {
        High,Low,Medium
    }

    private String status;
    private ArrayList<User> users;
}

