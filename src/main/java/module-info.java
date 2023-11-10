module com.example.midtermfinal {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.midtermfinal to javafx.fxml;
    exports com.example.midtermfinal;
}