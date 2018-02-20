package company;

import com.fasterxml.classmate.AnnotationConfiguration;
import company.managers.TeamManager;
import company.scenes.CeoScene;
import company.windows.AlertBox;
import company.windows.ConfirmExit;
import company.windows.SetupCompany;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.Service;
import org.hibernate.service.ServiceRegistry;

public class MainClass extends Application {

    private Button setup;
    private Button exit;
    private TeamManager ceo;
    private CeoScene ceoScene;
    private SessionFactory sessionFactory;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
        } catch(Exception e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Welcome to your company!");

        setup = new Button("SETUP YOUR COMPANY");
        exit = new Button("EXIT");
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(setup, exit);

        setup.setOnAction(e -> {
            ceo = SetupCompany.display();
            ceoScene = new CeoScene(ceo, sessionFactory);
            try {
                ceoScene.start(primaryStage);
            } catch (Exception e1) {
                AlertBox.display("Error loading window!");
            }
        });

        exit.setOnAction( e -> {
            if(ConfirmExit.display()) {
                primaryStage.close();
            }
        });

        Scene scene = new Scene(layout, 350, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
