package company.windows;

import company.managers.TeamManager;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

public class ConfirmExit {

    private static boolean answer;

    public static boolean display(SessionFactory sessionFactory, TeamManager ceo) {

        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("ERROR");

        Label label = new Label();
        label.setText("Want to save your company?");

        Button yes = new Button("YES");
        yes.setOnAction(e -> {
            answer = true;
            Session session = sessionFactory.openSession();
            Transaction tx = null;
            try {
                tx = session.beginTransaction();
                session.save(ceo);
                tx.commit();
            } catch (HibernateException he) {
                if(tx!=null) {
                    tx.rollback();
                    he.printStackTrace();
                }
            } finally {
                session.close();
            }
            window.close();
        });

        Button no = new Button("NO");
        no.setOnAction(e -> {
            answer = true;
            window.close();
        });

        Button cancel = new Button("CANCEL");
        cancel.setOnAction(e -> {
            answer = false;
            window.close();
        });

        HBox buttons = new HBox(10);
        buttons.setAlignment(Pos.CENTER);
        buttons.setPadding(new Insets(10, 10, 10,10));
        buttons.getChildren().addAll(yes, no, cancel);

        VBox layout = new VBox();
        layout.setSpacing(10);
        layout.setPadding(new Insets(10, 10, 10,10));
        layout.getChildren().addAll(label, buttons);
        layout.setAlignment(Pos.CENTER);

        Scene scene = new Scene(layout);
        window.setScene(scene);
        window.showAndWait();

        return answer;
    }
}
