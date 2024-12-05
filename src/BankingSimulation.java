import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class BankingSimulation extends Application {
    private double balance = 500; // Exemple de solde initial
    private Label balanceLabel;
    private TextField amountField;

    @Override
    public void start(Stage primaryStage) {
        // Étiquette pour afficher le solde
        balanceLabel = new Label("Solde actuel : $500");

        // Champ de saisie pour le montant
        amountField = new TextField();
        amountField.setPromptText("Entrez un montant");

        // Boutons pour dépôt et retrait
        Button depositButton = new Button("Déposer");
        Button withdrawButton = new Button("Retirer");

        depositButton.setOnAction(e -> deposit());
        withdrawButton.setOnAction(e -> withdraw());

        // Disposition verticale
        VBox layout = new VBox(10, balanceLabel, amountField, depositButton, withdrawButton);
        layout.setStyle("-fx-padding: 20; -fx-alignment: center;");

        // Configuration de la scène
        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setTitle("Simulation Bancaire");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void deposit() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0) {
                balance += amount;
                updateBalance();
            } else {
                showAlert("Erreur", "Le montant doit être positif.");
            }
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez entrer un montant valide.");
        }
    }

    private void withdraw() {
        try {
            double amount = Double.parseDouble(amountField.getText());
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                updateBalance();
            } else if (amount > balance) {
                showAlert("Erreur", "Fonds insuffisants.");
            } else {
                showAlert("Erreur", "Le montant doit être positif.");
            }
        } catch (NumberFormatException e) {
            showAlert("Erreur", "Veuillez entrer un montant valide.");
        }
    }

    private void updateBalance() {
        balanceLabel.setText("Solde actuel : $" + balance);
        amountField.clear();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
