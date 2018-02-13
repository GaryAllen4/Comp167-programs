/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplecalc;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;

/**
 *
 * @author G-Smoove
 */
public class CircleButton extends StackPane {

    Label lblValue;
    Circle circle;

    CircleButton() {
lblValue = new Label("");
circle= new Circle();
circle.setFill(Color.BLUE);
    }
    
    CircleButton(String val) {
        lblValue = new Label();
        lblValue.setText(val);
     circle = new Circle();
     circle.setRadius(90);
    }
    
    public void setColor(Paint color) {
        circle.setFill(color);
    }
    
    public Paint getColor() {
        return circle.getFill();
        
    }
    
    public String getValue(){
        
        return lblValue.getText();
        
    }
}
