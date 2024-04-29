module firok.demo.javafx21helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens firok.demo.javafx21helloworld to javafx.fxml;
    exports firok.demo.javafx21helloworld;
}