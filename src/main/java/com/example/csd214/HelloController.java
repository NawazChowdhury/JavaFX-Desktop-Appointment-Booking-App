package com.example.csd214;

import com.example.csd214.Model.Appointment;
import com.example.csd214.Model.AppointmentDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import java.net.URL;
import java.util.ResourceBundle;
import java.sql.*;
public class HelloController implements Initializable {

    public TextField nameInput;
    public TextField doctorInput;
    public TextField roomInput;
    public TextField input1;


    @FXML
    private TableView<Appointment> tableView;
    @FXML
    private TableColumn<Appointment, Integer> id;
    @FXML
    private TableColumn<Appointment, String> name;
    @FXML
    private TableColumn<Appointment, String> doctor;
    @FXML
    private TableColumn<Appointment, Integer> room;

    ObservableList<Appointment> list = FXCollections.observableArrayList();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        id.setCellValueFactory(new
                PropertyValueFactory<Appointment, Integer>("id"));
        name.setCellValueFactory(new
                PropertyValueFactory<Appointment, String>("name"));
        doctor.setCellValueFactory(new
                PropertyValueFactory<Appointment, String>("doctor"));
        room.setCellValueFactory(new
                PropertyValueFactory<Appointment, Integer>("room"));
        tableView.setItems(list);
    }


    @FXML
    protected void onHelloButtonClick() {
        AppointmentDAO a = new AppointmentDAO(); // creating object
        list = a.populateTable(); // calling method using object of that class
        tableView.setItems(list);//setting ObservableList list

    }

    public void populateTable() {
// Establish a database connection
        String jdbcUrl = "jdbc:mysql://localhost:3306/csd214lab1";
        String dbUser = "root";
        String dbPassword = "";
        try (Connection connection = DriverManager.getConnection(jdbcUrl, dbUser,
                dbPassword)) {
// Execute a SQL query to retrieve data from the database
            String query = "SELECT * FROM tbl_appointment";
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
// Populate the table with data from the database
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String doctor = resultSet.getString("doctor");
                int room = resultSet.getInt("Room");
                tableView.getItems().add(new Appointment(id, name, doctor,
                        room));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    public void UpdateClick(ActionEvent actionEvent) {

        String name = nameInput.getText();
        String doctor = doctorInput.getText();
        int room = Integer.parseInt(roomInput.getText());
        int id = Integer.parseInt(input1.getText());
        AppointmentDAO a = new AppointmentDAO(); // creating object
        a.UpdateData(name, doctor, room, id);
    }

    public void InsertClick(ActionEvent actionEvent) {

        String name = nameInput.getText();
        String doctor = doctorInput.getText();
        int room = Integer.parseInt(roomInput.getText());
        AppointmentDAO a = new AppointmentDAO(); // creating object
        a.InsertData(name, doctor, room);
    }

    public void DeleteClick(ActionEvent actionEvent) {
        int id = Integer.parseInt(input1.getText());
        AppointmentDAO a = new AppointmentDAO(); // creating object
        a.DeleteData(id);
    }

    public void loadData(ActionEvent actionEvent) {

        int id = Integer.parseInt(input1.getText());
        AppointmentDAO a = new AppointmentDAO(); // creating object
        list = a.loadData(id);

        nameInput.setText(list.getFirst().getName());
        doctorInput.setText(list.getFirst().getDoctor());
        String x =Integer.toString(list.getFirst().getRoom());
        roomInput.setText(x);


    }
}