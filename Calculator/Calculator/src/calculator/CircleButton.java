/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package calculator;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author Gary Allen
 */
public class CircleButton extends StackPane{
    
    private Label lblValue;
    private Circle circle;
    
    public CircleButton() {
        circle = new Circle();
        lblValue = new Label("");
        
        circle.setRadius(90);
        circle.setFill(Color.WHITE);
        
        this.setPrefSize(100, 100);
        
        this.getChildren().add(circle);
        this.getChildren().add(lblValue);
    }
    
    public CircleButton(String val) {
        circle = new Circle();
        lblValue = new Label(val);
        
        circle.setRadius(90);
        circle.setFill(Color.WHITE);
        
        this.setPrefSize(100, 100);
        
        this.getChildren().add(circle);
        this.getChildren().add(lblValue);
    }
    
    public void setColor(Paint color) {
        circle.setFill(color);
    }
    
    public Paint getColor() {
        return circle.getFill();
    }
    
    public String getValue() {
        return lblValue.getText();
    }

}
