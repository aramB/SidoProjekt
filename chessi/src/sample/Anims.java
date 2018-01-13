package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class Anims {

    public static SubScene getAnim() {
        Circle circle = new Circle(20, 20f, 15);
        circle.setFill(Color.RED);
        Group group = new Group();
        group.getChildren().add(circle);
        SubScene scene = new SubScene(group, 40, 40);
        scene.setFill(Color.WHITE);
        return scene;
    }
}

