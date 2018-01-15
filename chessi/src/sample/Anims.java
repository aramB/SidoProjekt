package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;


public class Anims {

    public static SubScene getAnim() {
        //Circle circle = new Circle(20, 20f, 15);
        //FileInputStream inputstream = new FileInputStream("D:\\GitProjects\\SidoProjekt\\chessi\\src\\chessPieces\\45px-Chess_pdt45.svg.png");
        //Image image = new Image(inputstream);
        Image iv = new Image("45px-Chess_pdt45.svg.png");
        ImageView imgV = new ImageView(iv);
        //circle.setFill(Color.RED);
        Group group = new Group();
        group.getChildren().add(imgV);
        SubScene scene = new SubScene(group, 40, 40);
        scene.setFill(Color.TRANSPARENT);
        return scene;
    }
}

