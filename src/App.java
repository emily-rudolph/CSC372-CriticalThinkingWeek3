import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.io.IOException;
import java.io.PrintWriter;

import java.util.Random;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Scene;

//Init Class
public class App extends Application {

    //Declare class vars
    private Button getTime; 
    private Button saveTime; 
    private Button changeColor; 
    private Button exitB; 

    private TextField dateText; 

    private LocalDateTime now; 
    
    @Override //Override and def what happens when the program starts
    public void start(Stage applicationStage) { 

        //Create GridPanes and Menu 
        GridPane rootGridPane = new GridPane(); 
        GridPane textGridPane = new GridPane(); 

        Menu menu = new Menu("Menu"); 

        //Format RootPain
        rootGridPane.setPadding(new Insets(5, 5, 5, 5)); 
        rootGridPane.setHgap(5);
        rootGridPane.setVgap(5); 
        rootGridPane.setStyle("-fx-background-color: #ccffcc;");

        //Format TextPain
        textGridPane.setPadding(new Insets(5, 5, 5, 5)); 
        textGridPane.setHgap(5);
        textGridPane.setVgap(5);

        //Create Buttons
        getTime = new Button("Get The Time"); 
        saveTime = new Button("Save The Time"); 
        changeColor = new Button("Change Color"); 
        exitB = new Button ("Exit"); 

        //Action on getTime Button Click
        getTime.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) { 

                //Get the Date and Time and display it on the textGridPane
                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");  
                now = LocalDateTime.now();

                dateText = new TextField(dtf.format(now));
                dateText.setEditable(false); 

                textGridPane.add(dateText, 15, 15);

            }
        });

        //Action on saveTime Button Click
        saveTime.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) { 
                //If not date has been retrieved, warn user and continue 
                if (dateText == null) { 
                    Alert alert = new Alert(AlertType.INFORMATION, "You must get a date before you can save it!.");
                    alert.showAndWait();
                } else { 
                    try {
                        //Write current date displayed by program to file
                        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

                        PrintWriter out = new PrintWriter("TimeDateOutput.txt");
                        out.println("The Current Saved Time Is: "); 
                        out.println(dtf.format(now));
                        out.close(); 
                    } 
                    catch(IOException e) { 
                        //Catch and possible error, warn user, and continue. 
                        Alert alert = new Alert(AlertType.ERROR, "Something Went Wrong! Your File Can Not Be Saved.");
                        alert.showAndWait();
                    }
                    
                }

            }
        });

        //Action on changeColor Button Click 
        changeColor.setOnAction(new EventHandler<ActionEvent>() {
            
            @Override
            public void handle(ActionEvent event) {
                //Pick a random color from a list of shades of green and set that color 
                String[] colors = { "#99ff99", "#006666", "#339966", "#00cc99", "#00ff99", "#66ff99", "#33cc33", "#00cc00", "#339933", "#006600", "#009933", "#009900", "#336600", "#99ff33"}; 
                Random rand = new Random();
                int random = rand.nextInt(colors.length - 1); 
            
                rootGridPane.setStyle(String.format("-fx-background-color: %s;", colors[random]));

            }
        });

        //Action on exitB Button Click 
        exitB.setOnAction(new EventHandler<ActionEvent>() {
        
            @Override
            public void handle(ActionEvent event) { 
                //Close Program 
                applicationStage.close(); 
            }
        });

        //Make buttons into menu items 
        CustomMenuItem m1 = new CustomMenuItem(getTime);
        CustomMenuItem m2 = new CustomMenuItem(saveTime);
        CustomMenuItem m3 = new CustomMenuItem(changeColor);
        CustomMenuItem m4 = new CustomMenuItem(exitB);

        //Add menu items to menu
        menu.getItems().add(m1);
        menu.getItems().add(m2);
        menu.getItems().add(m3);
        menu.getItems().add(m4);
  
        //Make a Menu Bar and add the Menu 
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().add(menu);

        //Make a box to hold the menubar 
        HBox hbox = new HBox(menuBar); 

        //Make a scene with the rootGridPane. Then finally add the other containers. 
        Scene scene = new Scene(rootGridPane, 300, 300); 
        rootGridPane.getChildren().addAll(textGridPane, hbox); 

        //Add scene to stage and add label to the state. Show stage. 
        applicationStage.setScene(scene);    
        applicationStage.setTitle("Get Time and Date Application");
        applicationStage.show();  

    }

        public static void main(String args[]) {
            //Launch Program 
            launch(args); 
        }
    
    }

