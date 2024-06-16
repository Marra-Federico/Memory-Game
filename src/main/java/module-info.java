module org.fmarra.memorygame {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.fmarra.memorygame to javafx.fxml;
    exports org.fmarra.memorygame;
}