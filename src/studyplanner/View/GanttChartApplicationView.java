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
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import javafx.geometry.Side;
import javafx.scene.Cursor;

// TODO: use date for x-axis
public class GanttChartApplicationView extends Application {

    @Override public void start(Stage stage) {

        stage.setTitle("Gantt Chart");
      
        String[] tasks = new String[] { "Task 5", "Task 4", "Tasks 3", "Task 2"
        , "Task 1"};
        //ArrayList<Date> dates = new ArrayList<>();

        final DateAxis xAxis = new DateAxis(new GregorianCalendar(2017,3,1,00,00,00).getTime(),new GregorianCalendar(2017,3,8,00,00,00).getTime());
        final CategoryAxis yAxis = new CategoryAxis();

       final GanttChartView<Date,String> chart = new GanttChartView<Date,String>(xAxis,yAxis);
        xAxis.setLabel("Time");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        //xAxis.setMinorTickCount(1);
        //xAxis.setTickLabelGap(1);
        xAxis.setTickLabelGap(3);
        //xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(dates)));
        xAxis.setTickLabelRotation(90);
 //       xAxis.setLowerBound(DateAxis);
        xAxis.setSide(Side.TOP);
        
        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        yAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(tasks)));

        chart.setTitle("Study Planner");
        chart.setLegendVisible(false);
        chart.setBlockHeight( 25); //sets depth of block
        String task;
        float x = 103.0f;
        task = tasks[0];
        XYChart.Series series1 = new XYChart.Series();
        series1.getData().add(new XYChart.Data(new GregorianCalendar(2017,3,5,14,00).getTime(), task, new ExtraData( 2*x, "status-red")));

        task = tasks[1];
        XYChart.Series series2 = new XYChart.Series();
        series2.getData().add(new XYChart.Data(new GregorianCalendar(2017,3,4).getTime(), task, new ExtraData( x, "status-green")));

        task = tasks[2];
        XYChart.Series series3 = new XYChart.Series();
        series3.getData().add(new XYChart.Data(new GregorianCalendar(2017,3,3).getTime(), task, new ExtraData( x, "status-blue")));

        task = tasks[3];
        XYChart.Series series4 = new XYChart.Series();
        series4.getData().add(new XYChart.Data(new GregorianCalendar(2017,3,2).getTime(), task, new ExtraData(x, "status-x")));
        
        
        task = tasks[4];
        XYChart.Series series5 = new XYChart.Series();
        series5.getData().add(new XYChart.Data(new GregorianCalendar(2017,3,1,24,00).getTime() , task, new ExtraData(x, "status-green")));
       
        
        chart.getData().addAll(series1, series2, series3, series4, series5);           

        //System.out.println(getClass().getResource("."));
        chart.getStylesheets().add(getClass().getResource("GanttChartView.css").toExternalForm());

        //StackPane stack = new StackPane();
        ScrollPane sp = new ScrollPane();
        //
        
        
        //sp.setContent(chart);
       // stack.getChildren().add(sp);
        
        Scene scene  = new Scene(chart,800,600);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
        //stack.getChildren().add(xAxis);
    }

    public static void main(String[] args) {
        launch(args);
    }
}