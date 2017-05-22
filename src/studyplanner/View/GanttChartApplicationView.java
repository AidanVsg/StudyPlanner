/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyplanner.View;

import studyplanner.Model.*;

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

<<<<<<< HEAD
    private void showGanttChart(Assignment a, Date firstDateToShow, Date lastDateToShow)
    {
        Stage stage = new Stage();
        
         stage.setTitle("Gantt Chart");
     
        //Assignment game = new Assignment(0.6,"Game","Make a game",new GregorianCalendar(2017,4,5,15,00,00).getTime(), new GregorianCalendar(2017,4,25,15,00,00).getTime());

        //Task task1 = new Task();
        //task1.setName("Reading");
        //task1.setStart(new GregorianCalendar(2017,4,10,00,00,00).getTime());
        //task1.setEnd(new GregorianCalendar(2017,4,12,00,00,00).getTime());
        
        //Task task2 = new Task();
        //task2.setName("Smoke a joint");
        //task2.setStart(new GregorianCalendar(2017,4,9,00,00,00).getTime());
        //task2.setEnd(new GregorianCalendar(2017,4,10,00,00,00).getTime());
        
        //game.addTask(task1);
        //game.addTask(task2);
        
        //final DateAxis xAxis = new DateAxis(new GregorianCalendar(2017,4,9,00,00,00).getTime(),new GregorianCalendar(2017,4,16,00,00,00).getTime());
        final DateAxis xAxis = new DateAxis(firstDateToShow,lastDateToShow);
=======
    @Override public void start(Stage stage) {

        stage.setTitle("Gantt Chart");
      
        String[] tasks = new String[] { "Task 5", "Task 4", "Tasks 3", "Task 2"
        , "Task 1"};
        //ArrayList<Date> dates = new ArrayList<>();

        final DateAxis xAxis = new DateAxis(new GregorianCalendar(2017,3,1,00,00,00).getTime(),new GregorianCalendar(2017,3,8,00,00,00).getTime());
>>>>>>> da3af90e5fd8b2d8cedd4209f67da21ad8bf8906
        final CategoryAxis yAxis = new CategoryAxis();
        
        List<String> tasknames = new ArrayList<>();
        
       final GanttChartView<Date,String> chart = new GanttChartView<Date,String>(xAxis,yAxis);
        xAxis.setLabel("Date");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setTickLabelGap(3);
<<<<<<< HEAD
        xAxis.setTickLabelRotation(90);

=======
        //xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(dates)));
        xAxis.setTickLabelRotation(90);
 //       xAxis.setLowerBound(DateAxis);
>>>>>>> da3af90e5fd8b2d8cedd4209f67da21ad8bf8906
        xAxis.setSide(Side.TOP);
        
        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        
        yAxis.setCategories(FXCollections.<String>observableArrayList(tasknames));

        chart.setTitle("Study Planner");
        chart.setLegendVisible(false);
        chart.setBlockHeight( 25); //sets depth of block
<<<<<<< HEAD

        float x = 4.2f;

        ArrayList<XYChart.Series> allstuff = new ArrayList<XYChart.Series>();
        
        for (Task t : a.getTasks())
        {
            double time = (t.getEnd().getTime() - t.getStart().getTime())/3600000;
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(t.getStart(), t.getName(), new ExtraData(time*x,"status-red")));
            chart.getData().add(series);
        }
=======
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
>>>>>>> da3af90e5fd8b2d8cedd4209f67da21ad8bf8906

        chart.getStylesheets().add(getClass().getResource("GanttChartView.css").toExternalForm());


        Scene scene  = new Scene(chart,800,600);
        
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    
    @Override public void start(Stage stage) {
      
       
    }

    public static void main(String[] args) {
        launch(args);
    }
}