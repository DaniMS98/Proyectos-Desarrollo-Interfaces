module desarrollointerfaces.dms.proyectofinal {
    requires javafx.controls;
    requires javafx.fxml;

    opens desarrollointerfaces.dms.proyectofinal to javafx.fxml;
    exports desarrollointerfaces.dms.proyectofinal;
}
