module org.openjfx.SEDatabaseProject {
    requires javafx.controls;
    requires javafx.fxml;
	requires javafx.base;
	requires javafx.graphics;

    opens org.openjfx.SEDatabaseProject to javafx.fxml;
    exports org.openjfx.SEDatabaseProject;
}