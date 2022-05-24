module desarrollointerfaces.dms.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;

    opens desarrollointerfaces.dms.proyectofinal to javafx.fxml;
    exports desarrollointerfaces.dms.proyectofinal;
    requires javafx.graphics;
}
