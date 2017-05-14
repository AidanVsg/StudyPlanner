/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyplanner.View;

import java.util.Arrays;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import studyplanner.View.GanttChartView.ExtraData;

// TODO: use date for x-axis
public class GanttChartApplicationView extends Application {

    @Override public void start(Stage stage) {

        stage.setTitle("Gantt Chart");

        String[] tasks = new String[] { "Task 1", "Task 2", "Tasks 3", "Task 4"
        , "Task 5"};

        final NumberAxis xAxis = new NumberAxis();
        final CategoryAxis yAxis = new CategoryAxis();

//        final GanttChartView<Number,String> chart = new GanttChartView<Number,String>(xAxis,yAxis);
//        xAxis.setLabel("Time");
//        xAxis.setTickLabelFill(Color.CHOCOLATE);
//        xAxis.setMinorTickCount(3);

        final GanttChartView<Number,String> chart = new GanttChartView<Number,String>(xAxis,yAxis);
        xAxis.setLabel("Time");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setMinorTickCount(3);


        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(tasks)));

        chart.setTitle("Study Planner");
        chart.setLegendVisible(false);
        chart.setBlockHeight( 25); //sets depth of block
        String task;

        task = tasks[0];
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(4, task, new ExtraData( 1, "status-red")));

        task = tasks[1];
        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data(3, task, new ExtraData( 1, "status-green")));

        task = tasks[2];
        XYChart.Series series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data(2, task, new ExtraData( 1, "status-blue")));
        

        task = tasks[3];
        XYChart.Series series4 = new XYChart.Series();
        series4.getData().add(new XYChart.Data(1, task, new ExtraData(1, "status-x")));
        
        
        
         task = tasks[4];
        XYChart.Series series5 = new XYChart.Series();
        series4.getData().add(new XYChart.Data(0, task, new ExtraData(1, "status-yello")));
       
        
        chart.getData().addAll(series1, series2, series3, series4, series5);           

        //System.out.println(getClass().getResource("."));
        chart.getStylesheets().add(getClass().getResource("GanttChartView.css").toExternalForm());

      
        Scene scene  = new Scene(chart,620,350);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}