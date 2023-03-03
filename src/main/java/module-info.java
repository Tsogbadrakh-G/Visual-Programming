module com.example.collegeparkautoparts {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.collegeparkautoparts to javafx.fxml;
    exports com.example.collegeparkautoparts;
}