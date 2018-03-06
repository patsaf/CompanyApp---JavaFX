package company;

import company.employees.AbstractEmployee;
import company.managers.TeamManager;
import company.scenes.CeoScene;
import company.windows.AlertBox;
import company.windows.ConfirmExit;
import company.windows.SetupCompany;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import javax.persistence.NoResultException;

public class MainClass extends Application {

    private Button setup;
    private Button exit;
    private Button load;
    private TeamManager ceo;
    private CeoScene ceoScene;
    private static SessionFactory sessionFactory;
    private Session session;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        ceo = null;
        try {
            sessionFactory = new Configuration()
                    .configure()
                    .buildSessionFactory();
            session = sessionFactory.openSession();
        } catch (Exception e) {
            e.printStackTrace();
        }

        primaryStage.setTitle("Welcome to your company!");

        setup = new Button("SETUP YOUR COMPANY");
        load = new Button("LOAD FROM DATABASE");
        exit = new Button("EXIT");
        VBox layout = new VBox(10);
        layout.setAlignment(Pos.CENTER);
        layout.getChildren().addAll(setup, load, exit);

        load.setOnAction(e -> {
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                try {
                    Query<AbstractEmployee> query = session.createQuery("select c from AbstractEmployee c where c.role='CEO'",
                            AbstractEmployee.class);
                    ceo = (TeamManager) query.getSingleResult();
                    ceoScene = new CeoScene(ceo, sessionFactory, session);
                } catch (NoResultException nre) {
                    AlertBox.display("No saved instance available!");
                }
                tx.commit();
                try {
                    ceoScene.start(primaryStage);
                } catch (Exception e1) {
                }
            } catch (HibernateException he) {
                tx.rollback();
                he.printStackTrace();
            }
        });

        setup.setOnAction(e -> {
            ceo = SetupCompany.display(session);
            ceoScene = new CeoScene(ceo, sessionFactory, session);
            try {
                ceoScene.start(primaryStage);
            } catch (Exception e1) {
            }
        });

        exit.setOnAction(e -> {
            if (ConfirmExit.display(sessionFactory, ceo, session)) {
                primaryStage.close();
            }
        });

        Scene scene = new Scene(layout, 350, 400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
