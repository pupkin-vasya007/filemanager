package ru.mygeekprojects;



import javafx.beans.property.SimpleObjectProperty;

import javafx.beans.property.SimpleStringProperty;

import javafx.event.ActionEvent;

import javafx.event.EventHandler;

import javafx.fxml.FXML;

import javafx.fxml.Initializable;

import javafx.scene.control.*;

import javafx.scene.input.MouseEvent;



import java.io.IOException;

import java.net.URL;

import java.nio.file.FileSystems;

import java.nio.file.Files;

import java.nio.file.Path;

import java.nio.file.Paths;

import java.time.format.DateTimeFormatter;

import java.util.ResourceBundle;

import java.util.stream.Collectors;



public class PanelController implements Initializable {



    @FXML
    
        public ComboBox<String> disksBox;
        
            public TextField pathField;
            
            
            
            
            
                @FXML
                
                    TableView<FileInfo> filesTable;
                    
                    
                    
                        @Override
                        
                            public void initialize(URL location, ResourceBundle resources) {
                            
                                    TableColumn<FileInfo, String> fileTypeColumn = new TableColumn<>();
                                    
                                            fileTypeColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getType().getName()));
                                            
                                                    fileTypeColumn.setPrefWidth(24);
                                                    
                                                    
                                                    
                                                            TableColumn<FileInfo, String> fileNameColumn = new TableColumn<>("Name");
                                                            
                                                                    fileNameColumn.setCellValueFactory(param -> new SimpleStringProperty(param.getValue().getFileName()));
                                                                    
                                                                            fileNameColumn.setPrefWidth(240);
                                                                            
                                                                            
                                                                            
                                                                                    TableColumn<FileInfo, Long> fileSizeColumn = new TableColumn<>("Size");
                                                                                    
                                                                                            fileSizeColumn.setCellValueFactory(param -> new SimpleObjectProperty<>(param.getValue().getSize()));
                                                                                            
                                                                                                    fileSizeColumn.setPrefWidth(120);
                                                                                                    
                                                                                                    
                                                                                                    
                                                                                                            fileSizeColumn.setCellFactory(column -> {
                                                                                                            
                                                                                                                        return new TableCell<FileInfo, Long>() {
                                                                                                                        
                                                                                                                                        @Override
                                                                                                                                        
                                                                                                                                                        protected void updateItem(Long item, boolean empty) {
                                                                                                                                                        
                                                                                                                                                                            super.updateItem(item, empty);
                                                                                                                                                                            
                                                                                                                                                                                                if (item == null || empty) {
                                                                                                                                                                                                
                                                                                                                                                                                                                        setText(null);
                                                                                                                                                                                                                        
                                                                                                                                                                                                                                                setStyle("");
                                                                                                                                                                                                                                                
                                                                                                                                                                                                                                                                    } else {
                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                
