package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.effect.DropShadow;
import javafx.scene.paint.Color;
import javafx.scene.shape.*;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Drawing Shapes");
        Group grp = new Group();
        Scene scene = new Scene(grp, 306, 550, Color.WHITE);

        // Sine wave
        CubicCurve cubicCurve= new CubicCurve(
                50,     // starting x position
                75,     // start y point
                80,     // control x1 point
                -25,    // control y1 point
                110,    // control x2 point
                175,    // control y2 point
                140,    // end x point
                75      // end y point
        );
        cubicCurve.setStrokeType(StrokeType.CENTERED);
        cubicCurve.setStroke(Color.BLACK);
        cubicCurve.setStrokeWidth(3);

        grp.getChildren().add(cubicCurve);

        // Ice Cream Cone
        Path path = new Path();
        path.setStrokeWidth(3);

        // create top part beginning on the left
        MoveTo moveTo = new MoveTo();
        moveTo.setX(50);
        moveTo.setY(150);

        // curve ice cream (dome)
        QuadCurveTo quadCurveTo = new QuadCurveTo();
        quadCurveTo.setX(150);
        quadCurveTo.setY(150);
        quadCurveTo.setControlX(100);
        quadCurveTo.setControlY(50);

        // cone rim
        LineTo lineTo1 = new LineTo();
        lineTo1.setX(50);
        lineTo1.setY(150);

        // left side of cone
        LineTo lineTo2 = new LineTo();
        lineTo2.setX(100);
        lineTo2.setY(275);

        // right side of cone
        LineTo lineTo3 = new LineTo();
        lineTo3.setX(150);
        lineTo3.setY(150);

        path.getElements().addAll(moveTo, quadCurveTo, lineTo1, lineTo2, lineTo3);

        path.setTranslateY(30);

        grp.getChildren().add(path);

        // A smile
        QuadCurve quad = new QuadCurve(
                50,     // start x point
                50,     // start y point
                125,    // control x point
                150,    // control y point
                150,    // end x point
                50    // end y point
        );
        quad.setTranslateY(path.getBoundsInParent().getMaxY());
        quad.setStrokeWidth(3);
        quad.setStroke(Color.BLACK);
        quad.setFill(Color.WHITE);

        grp.getChildren().add(quad);

        // outer donut
        Ellipse bigCircle = new Ellipse(
                100,    // center x
                100,    // center y
                50,     // radius x
                75/2    // radius y
        );
        bigCircle.setStrokeWidth(3);
        bigCircle.setStroke(Color.BLACK);
        bigCircle.setFill(Color.WHITE);

        // donut hole
        Ellipse smallCircle = new Ellipse(
                100,    // center x
                100,    // center y
                35/2,   // radius x
                25/2    // radius y
        );

        // make a donut
        Shape donut = Path.subtract(bigCircle, smallCircle);
        donut.setStrokeWidth(2.2);
        donut.setStroke(Color.BLACK);

        // orange glaze
        donut.setFill(Color.rgb(255, 200, 0));

        // add drop shadow
        DropShadow dropShadow = new DropShadow(
                5,      // radius
                2.0f,   // offset X
                2.0f,   // offset Y
                Color.rgb(50, 50, 50, .588));

        // move slightly down
        donut.setTranslateY(quad.getBoundsInParent().getMinY() + 30);

        grp.getChildren().add(donut);

        primaryStage.setScene(scene);
        primaryStage.show();



    }



    public static void main(String[] args) {
        launch(args);
    }
}
