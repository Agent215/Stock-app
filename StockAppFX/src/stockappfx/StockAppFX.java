/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package stockappfx;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

/**
 *
 * @author Bert
 */
public class StockAppFX extends Application {

    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

        Scene scene = new Scene(root, 700, 700);

        stage.setTitle("Stock Quotes");

        stage.setScene(scene);
        scene.getStylesheets().add(StockAppFX.class.getResource("StockCss.css").toExternalForm());
        stage.show();
    }//end start

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }//end main

    private LineChart<Number, Number> createLineChart(Double[] axisValues) {
        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Time");
        //creating the chart
        final LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);

        lineChart.setTitle("Axis' values");
        //defining a series
        XYChart.Series<Number, Number> series = new LineChart.Series<>();
        series.setName("X Axis");
        //populating the series with data
        for (int i = 0; i < axisValues.length; i++) {
            XYChart.Data<Number, Number> data = new LineChart.Data<>(i, axisValues[i]);
            series.getData().add(data);
        }
        lineChart.getData().add(series);
        return lineChart;
    }
}//end class StockAppFX
