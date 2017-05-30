/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studyplanner;

import java.time.LocalDate;
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
import studyplanner.GanttChartView.ChartRectangle;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.StackPane;

import java.util.Date;
import java.util.*;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Side;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class GanttChartApplicationView extends Application {

    Button prev = new Button("Previous Week");
    Button next = new Button("Next Week");
    Scene scene;
    AnchorPane global;
    //Scene scene = initData(selectedAssignment, , );
    LocalDate today = LocalDate.now().atStartOfDay().toLocalDate();
    LocalDate afterAWeek = LocalDate.now().plusDays(6).atStartOfDay().toLocalDate();  
    
 
    public Scene getScene(){
        return this.scene;
    }
    
    
    private void doPrevious(Assignment selectedAssignment,Stage stage) {
        //temp = LocalDate.now().minusDays(6);
        today = today.minusDays(6).atStartOfDay().toLocalDate();
        afterAWeek = today.plusDays(6).atStartOfDay().toLocalDate();
        initData(selectedAssignment, java.sql.Date.valueOf(today), java.sql.Date.valueOf(afterAWeek));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    private void doNext(Assignment selectedAssignment,Stage stage) {
        //temp = LocalDate.now().minusDays(6);
        today = today.plusDays(6).atStartOfDay().toLocalDate();
        afterAWeek = today.plusDays(6).atStartOfDay().toLocalDate();
        initData(selectedAssignment, java.sql.Date.valueOf(today), java.sql.Date.valueOf(afterAWeek));
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }
    public void setPrevious(Assignment selectedAssignment, Stage stage){
        prev.setOnAction(e->doPrevious(selectedAssignment,stage));
        prev.setLayoutX(25);
        prev.setLayoutY(575);
    }
    
    public void firstInit(Assignment selectedAssignment,Stage stage)
    {
        initData(selectedAssignment, java.sql.Date.valueOf(today), java.sql.Date.valueOf(afterAWeek));
    }
    
    public void setNext(Assignment selectedAssignment,Stage stage){
        next.setOnAction(e->doNext(selectedAssignment,stage));
        next.setLayoutX(500);
        next.setLayoutY(575);
    }

    public void initData(Assignment a, Date firstDateToShow, Date lastDateToShow)
    {
        global = new AnchorPane();
        //Stage stage = new Stage();
        
        // stage.setTitle("Gantt Chart");
     
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
        final CategoryAxis yAxis = new CategoryAxis();
        
        final GanttChartView<Date,String> chart = new GanttChartView<Date,String>(xAxis,yAxis);
        xAxis.setLabel("Date");
        xAxis.setTickLabelFill(Color.CHOCOLATE);
        xAxis.setTickLabelGap(3);

        xAxis.setTickLabelRotation(90);


        //xAxis.setCategories(FXCollections.<String>observableArrayList(Arrays.asList(dates)));
        xAxis.setTickLabelRotation(90);
 //       xAxis.setLowerBound(DateAxis);

        xAxis.setSide(Side.TOP);
        
        yAxis.setLabel("");
        yAxis.setTickLabelFill(Color.CHOCOLATE);
        yAxis.setTickLabelGap(10);
        
        //yAxis.setCategories(FXCollections.<String>observableArrayList(tasknames));

        chart.setTitle(a.getName());
        chart.setLegendVisible(false);
        chart.setBlockHeight( 25); //sets depth of block

        double x = 3.0;
        
        for (Task t : a.getTasks())
        {
            double time = (t.getEnd().getTime() - t.getStart().getTime())/3600000;
            XYChart.Series series = new XYChart.Series();
            series.getData().add(new XYChart.Data(t.getStart(), t.getName(), new ChartRectangle(time*x,"status-red")));
            chart.getData().add(series);
        }
        
        chart.getStylesheets().add(getClass().getResource("GanttChartView.css").toExternalForm());
        chart.setLayoutX(50);
        chart.setLayoutY(50);
        chart.setScaleX(1.2);
        chart.setScaleY(1.2);
        
        global.getChildren().addAll(chart,prev, next);
        scene = new Scene(global, 650, 650);
    }


   // @Override public void start(Stage stage) {
      
       
   // }

    //public static void main(String[] args) {
        //launch(args);
    //}

    @Override
    public void start(Stage primaryStage) throws Exception {

    }

    
}