/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testprintmanager;

/**
 *
 * @author Администратор
 */


import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

public class Controller {
private ObservableList<Pojo> FilesData = FXCollections.observableArrayList();
private ArrayList<String> PrintNames = new ArrayList();
private ArrayList<String> PrintType = new ArrayList();
private ArrayList<String> PrintSize = new ArrayList();
private ArrayList<Integer> PrintTime = new ArrayList();
public int Priority = 1;
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem AddFile;

    @FXML
    private MenuItem RemoveFile;

    @FXML
    private MenuItem StopPrint;

    @FXML
    private MenuItem PrintStat;

    @FXML
    private MenuItem StatisticAlert;

    @FXML
    private TableView<Pojo> PrintTable;

    @FXML
    private TableColumn<Pojo, String> ColumnName;

    @FXML
    private TableColumn<Pojo, String> ColumnType;

    @FXML
    private TableColumn<Pojo, String> ColumnSize;

    @FXML
    private TableColumn<Pojo, String> ColumnTime;

    @FXML
    private TableColumn<Pojo, String> ColumnPriority;

    @FXML
    void Pressed(ActionEvent event) {

    }

    @FXML
    void initialize() {
        ColumnName.setCellValueFactory(cell -> cell.getValue().Propertypc11());
        ColumnType.setCellValueFactory(cell -> cell.getValue().Propertypc12());
        ColumnSize.setCellValueFactory(cell -> cell.getValue().Propertypc13());
        ColumnTime.setCellValueFactory(cell -> cell.getValue().Propertypc14());
        ColumnPriority.setCellValueFactory(cell -> cell.getValue().Propertypc15());
        

AddFile.setOnAction(event ->{ //удаление данных в полях, номер читателя, дата1, дата2
//Stage stage = (Stage) PrintTable.getScene().getWindow();
    FileChooser fileChooser = new FileChooser();
    fileChooser.setTitle("Open Resource File");
    fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("txt", "*.txt"),
         new ExtensionFilter("doc", "*.doc"),
         new ExtensionFilter("jpg", "*.jpg"),
         new ExtensionFilter("png", "*.png"),
         new ExtensionFilter("xls", "*.xls")
         );
 
    File file = fileChooser.showOpenDialog(AddFile.getParentPopup().getScene().getWindow());
    PrintNames.add(file.getName());
    String TypeString =getFileExtension(file);
    PrintType.add(TypeString);
    PrintSize.add(getFileSize(TypeString));
    PrintTime.add(getFileTime(TypeString));
    FilesData.add(new Pojo(PrintNames.get(PrintNames.size()-1),PrintType.get(PrintType.size()-1),PrintSize.get(PrintSize.size()-1),String.valueOf(PrintTime.get(PrintTime.size()-1)),String.valueOf(Priority)));        
    //FilesData.set(0, new Pojo(PrintNames.get(PrintNames.size()-1),PrintType.get(PrintType.size()-1),PrintSize.get(PrintSize.size()-1),String.valueOf(PrintTime.get(PrintTime.size()-1)),String.valueOf(Priority+10)));    
    PrintTable.setItems(FilesData);     
        //ColumnPriority.setCellValueFactory(new PropertyValueFactory<>("level"));
    Priority++;
    //System.out.print(FilesData.size());
    
    }); 

RemoveFile.setOnAction(event ->{
    int selectedIndex = PrintTable.getSelectionModel().getSelectedIndex();
    PrintTable.getItems().remove(selectedIndex);
    PrintNames.remove(selectedIndex);
    PrintType.remove(selectedIndex);
    PrintSize.remove(selectedIndex);
    PrintTime.remove(selectedIndex);
    System.out.println(selectedIndex);
    FilesData.remove(PrintTable.getSelectionModel().selectedItemProperty().get().getpc15());
    System.out.println(FilesData.get(0).getpc14());
    //PrintTable.setItems(FilesData); 
    /*
    for(int i=selectedIndex;i<=Priority;i++){
        System.out.println(i);
        FilesData.set(i, new Pojo(PrintNames.get(i),PrintType.get(i),PrintSize.get(i),String.valueOf(PrintTime.get(i)),String.valueOf(i)));    
    }
    */
    
    });

StopPrint.setOnAction(event ->{
    System.out.println("Main thread started...");
        new Printer("Printer").start();
        System.out.println("Main thread finished...");
}); 
PrintStat.setOnAction(event ->{ 
});
StatisticAlert.setOnAction(event ->{ 
}); 
}
    
    private  String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
        return fileName.substring(fileName.lastIndexOf(".")+1);
        // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";}

    private String getFileSize(String TypeString) {
  switch(TypeString)
      {
        case "txt":
            return"A4";
        case "doc":
            return"A4"; 
        case "jpg":
            return"A5";
        case "png":
            return"A5";
        case "xls":
            return"A3"; 
      }
    return null;
     }

    private int getFileTime(String TypeString) {
switch(TypeString)
      {
        case "txt":
            return 10;
        case "doc":
            return 10; 
        case "jpg":
            return 20;
        case "png":
            return 20;
        case "xls":
            return 30; 
      }
    return 0;    }
    
    public static void infoBox(String infoMessage, String titleBar) // процедура окна с ошибками
    {
        JOptionPane.showMessageDialog(null, infoMessage, "Сообщение " + titleBar, JOptionPane.INFORMATION_MESSAGE);
    }
}

/*
//Stage stage = (Stage) PrintTable.getScene().getWindow();
FileChooser fileChooser = new FileChooser();
 fileChooser.setTitle("Open Resource File");
 fileChooser.getExtensionFilters().addAll(
         new ExtensionFilter("txt", "*.txt"),
         new ExtensionFilter("doc", "*.doc"),
         new ExtensionFilter("jpg", "*.jpg"),
         new ExtensionFilter("png", "*.png"),
         new ExtensionFilter("xls", "*.xls")
         );
File file = fileChooser.showOpenDialog(AddFile.getParentPopup().getScene().getWindow());
PrintNames.add(file.getName());
String TypeString =getFileExtension(file);
PrintType.add(TypeString);
PrintSize.add(getFileSize(TypeString));
PrintTime.add(getFileTime(TypeString));
FilesData.add(new Pojo(PrintNames.get(PrintNames.size()-1),PrintType.get(PrintType.size()-1),PrintSize.get(PrintSize.size()-1),String.valueOf(PrintTime.get(PrintTime.size()-1)),String.valueOf(Priority)));
                PrintTable.setItems(FilesData);
Priority++;

 ColumnName.setCellValueFactory(cell -> cell.getValue().Propertypc11());
        ColumnType.setCellValueFactory(cell -> cell.getValue().Propertypc12());
        ColumnSize.setCellValueFactory(cell -> cell.getValue().Propertypc13());
        ColumnTime.setCellValueFactory(cell -> cell.getValue().Propertypc14());
        ColumnPriority.setCellValueFactory(cell -> cell.getValue().Propertypc15());
        

 AddFile.setOnAction(event ->{ //удаление данных в полях, номер читателя, дата1, дата2
       System.out.print("123");
});
    }

    private  String getFileExtension(File file) {
        String fileName = file.getName();
        // если в имени файла есть точка и она не является первым символом в названии файла
        if(fileName.lastIndexOf(".") != -1 && fileName.lastIndexOf(".") != 0)
        // то вырезаем все знаки после последней точки в названии файла, то есть ХХХХХ.txt -> txt
        return fileName.substring(fileName.lastIndexOf(".")+1);
        // в противном случае возвращаем заглушку, то есть расширение не найдено
        else return "";}

    private String getFileSize(String TypeString) {
  switch(TypeString)
      {
        case "txt":
            return"A4";
        case "doc":
            return"A4"; 
        case "jpg":
            return"A5";
        case "png":
            return"A5";
        case "xls":
            return"A3"; 
      }
    return null;
     }

    private int getFileTime(String TypeString) {
switch(TypeString)
      {
        case "txt":
            return 10;
        case "doc":
            return 10; 
        case "jpg":
            return 20;
        case "png":
            return 20;
        case "xls":
            return 30; 
      }
    return 0;    }

private ObservableList<Pojo> FilesData = FXCollections.observableArrayList();
private ArrayList<String> PrintNames = new ArrayList();
private ArrayList<String> PrintType = new ArrayList();
private ArrayList<String> PrintSize = new ArrayList();
private ArrayList<Integer> PrintTime = new ArrayList();
public int Priority = 1;
*/
//long startTime = System.currentTimeMillis();
//long endTime = System.currentTimeMillis();
//System.out.println("Total execution time: " + (endTime-startTime) + "ms"); 
//stage.hide();

