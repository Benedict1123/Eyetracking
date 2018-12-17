import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.animation.Animation;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class BallMoving extends Application{
    public void start(Stage pr) {
        Pane pane=new Pane();
        Circle circle=new Circle(50,50,20);

        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.getChildren().add(circle);
        HBox hbox=new HBox();
        Button bt1=new Button("left");
        Button bt2=new Button("right");
        Button bt3=new Button("up");
        Button bt4=new Button("down");

        hbox.getChildren().addAll(bt1,bt2,bt3,bt4);
        hbox.setAlignment(Pos.CENTER);
        hbox.setSpacing(10);
        BorderPane bdpane=new BorderPane();
        bdpane.setLeft(pane);
        bdpane.setBottom(hbox);

        Scene scene=new Scene(bdpane,400,200);
        pr.setTitle("152");
        pr.setScene(scene);
        pr.show();

        bt1.setOnAction(new EventHandler<ActionEvent>() {
            public void handle(ActionEvent e) {
                circle.setCenterX(circle.getCenterX() > 0 ? circle.getCenterX() - 10 : 0);
            }
        });
        bt2.setOnAction(e->{circle.setCenterX(circle.getCenterX() < scene.getWidth() ? circle.getCenterX() + 10 : 0);});
        bt3.setOnAction(e->{circle.setCenterY(circle.getCenterY() > 0 ? circle.getCenterY() - 10 : 0);});
        bt4.setOnAction(e->{circle.setCenterY(circle.getCenterY() < scene.getHeight() ? circle.getCenterY() + 10 : 0);});
    }


    public static void main(String[] args) {
        Application.launch(args);
    }

}



