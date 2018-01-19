package sample;

import javafx.scene.Group;
import javafx.scene.SubScene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import java.io.FileInputStream;
import java.io.FileNotFoundException;


public class Anims {

    public static SubScene getAnim() throws FileNotFoundException {
        //Circle circle = new Circle(20, 20f, 15);
        FileInputStream inputstream = new FileInputStream("/Users/aramiB/Desktop/Academy/SidoProjekt/chessi/src/sample/45px-Chess_pdt45.svg.png");
        Image image = new Image(inputstream);
        //Image iv = new Image("https://upload.wikimedia.org/wikipedia/commons/4/47/Chess_qdt45.svg");
        ImageView imgV = new ImageView(image);
        //circle.setFill(Color.RED);
        Group group = new Group();
        group.getChildren().add(imgV);
        SubScene scene = new SubScene(group, 40, 40);
        //scene.setFill(Color.BLUE);
        return scene;
    }
}

