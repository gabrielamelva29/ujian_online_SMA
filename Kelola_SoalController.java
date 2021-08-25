/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import api.Api;
import api.RetrofitClient;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.prefs.Preferences;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import model.Pengguna;
import model.Soal;
import okhttp3.ResponseBody;
import response.PenggunaResponse;
import response.SoalResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class Kelola_SoalController implements Initializable {
    
     @FXML
    private Label lbOut;

    @FXML
    private Label lbExit;

    @FXML
    private Button btnDashboard;

    @FXML
    private Button btnAkun;

    @FXML
    private Button btnKriteria;

    @FXML
    private Button btnKuis;

    @FXML
    private TableView<Soal> tableSoal;

    @FXML
    private TableColumn<Soal, Integer> col_id;

    @FXML
    private TableColumn<Soal, String> col_kodeKuis;

    @FXML
    private TableColumn<Soal, String> col_kodeTipe;

    @FXML
    private TableColumn<Soal, String> col_Soal;

    @FXML
    private TableColumn<Soal, String> col_bobotSoal;

    @FXML
    private TableColumn<Soal, String> col_levelSoal;

    @FXML
    private TextField tf_kodeKuis;

    @FXML
    private TextField tf_kodeTipe;

    @FXML
    private TextField tf_soal;

    @FXML
    private TextField tf_bobotSoal;

    @FXML
    private TextField tf_levelSoal;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;

      ObservableList<Soal> observableList=FXCollections.observableArrayList();
    
    
    @FXML
    void onClickAkunPengguna(ActionEvent event) throws IOException {
        FXMLLoader pindah2=new FXMLLoader(getClass().getResource("/tampilan/Kelola_Pengguna.fxml"));
        Parent root=pindah2.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickDashboard(ActionEvent event) throws IOException {
        FXMLLoader pindah1=new FXMLLoader(getClass().getResource("/tampilan/DashboardAdministrator.fxml"));
        Parent root=pindah1.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickKuis(ActionEvent event) throws IOException {

        FXMLLoader pindah4=new FXMLLoader(getClass().getResource("/tampilan/Kelola_Kuis.fxml"));
        Parent root=pindah4.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }
    
        @FXML
    void onClickAbout(ActionEvent event) throws IOException {
        FXMLLoader ganti=new FXMLLoader(getClass().getResource("/tampilan/About.fxml"));
        Parent root=ganti.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void onClickSoal(ActionEvent event) throws IOException {
        FXMLLoader pindah3=new FXMLLoader(getClass().getResource("/tampilan/Kelola_Soal.fxml"));
        Parent root=pindah3.load();
        Stage stage=(Stage)((Node)event.getSource()).getScene().getWindow();
        Scene scene=new Scene(root);    
        stage.setScene(scene);
        stage.show();
    }    
    
    @FXML
    void menuExitClick(MouseEvent event) throws IOException {
        lbExit.setBackground(new Background(new BackgroundFill(Color.valueOf("#29B6F6"), CornerRadii.EMPTY, Insets.EMPTY)));
        Alert alert1=new Alert(Alert.AlertType.CONFIRMATION);
        alert1.setTitle("Select");
        alert1.setHeaderText("Apakah anda hendak keluar dari aplikasi ini?");
        Optional<ButtonType> option = alert1.showAndWait();
        
            if (option.get() == ButtonType.OK) {
                      System.exit(0);;
             } 
            else if (option.get() == ButtonType.CANCEL) {
                   FXMLLoader ganti9=new FXMLLoader(getClass().getResource("/tampilan/DashboardAdministrator.fxml"));
                   Parent utama9=ganti9.load();
                   Stage stage9=(Stage)((Node)event.getSource()).getScene().getWindow();
                   Scene scene9=new Scene(utama9);
                   stage9.setScene(scene9);
                   stage9.show();
      } 

    }

    @FXML
    void menuOutClick(MouseEvent event) throws IOException {
         lbOut.setBackground(new Background(new BackgroundFill(Color.valueOf("#48D1CC"), CornerRadii.EMPTY, Insets.EMPTY)));
        
        Alert alert=new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Select");
        alert.setHeaderText("Apakah anda yakin ingin logout?");
        Optional<ButtonType> option = alert.showAndWait();
        
     if (option.get() == ButtonType.OK) {
            FXMLLoader ganti5=new FXMLLoader(getClass().getResource("/tampilan/login.fxml"));
           Parent utama5=ganti5.load();
            Stage stage5=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene5=new Scene(utama5);
            stage5.setScene(scene5);
            stage5.show();
      } else if (option.get() == ButtonType.CANCEL) {
            FXMLLoader ganti8=new FXMLLoader(getClass().getResource("/tampilan/DashboardAdministrator.fxml"));
            Parent utama8=ganti8.load();
            Stage stage8=(Stage)((Node)event.getSource()).getScene().getWindow();
            Scene scene8=new Scene(utama8);
            stage8.setScene(scene8);
            stage8.show();
      } 
    }

    public void tampilSoal(){
        Api api=RetrofitClient.getRetrofit().create(Api.class);
        
        Call<SoalResponse> call=api.allSoal();
        call.enqueue(new Callback<SoalResponse>(){
            @Override
            public void onResponse(Call<SoalResponse> call, Response<SoalResponse> response) {
                if(response.isSuccessful()){
                    int size=response.body().getSoal().size();
                    List<Soal> listSoal=response.body().getSoal();
                    
                    for(int i=0; i<size; i++){
                      
                        observableList.add(new Soal(listSoal.get(i).getId(), listSoal.get(i).getKode_kuis(), listSoal.get(i).getKode_tipe(), listSoal.get(i).getSoal(), listSoal.get(i).getBobot_soal(), listSoal.get(i).getLevel_soal()));
                        
                    }
                    
                    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    col_kodeKuis.setCellValueFactory(new PropertyValueFactory<>("kode_kuis"));
                    col_kodeTipe.setCellValueFactory(new PropertyValueFactory<>("kode_tipe"));
                    col_Soal.setCellValueFactory(new PropertyValueFactory<>("soal"));
                    col_bobotSoal.setCellValueFactory(new PropertyValueFactory<>("bobot_soal"));
                    col_levelSoal.setCellValueFactory(new PropertyValueFactory<>("level_soal"));
                   
                    tableSoal.setItems(observableList);
                }
                else{
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<SoalResponse> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }

    @FXML
    void onClickButtonReset(ActionEvent event) {
        tf_kodeKuis.setText("");
        tf_kodeTipe.setText("");
        tf_soal.setText("");
        tf_bobotSoal.setText("");
        tf_levelSoal.setText("");

    }

    @FXML
    void onClickButtonTambah(ActionEvent event) {
        Preferences preferences=Preferences.userRoot();
        
        String kodeKuis=tf_kodeKuis.getText().toString();
        String kodeTipe=tf_kodeTipe.getText().toString();
        String soal=tf_soal.getText().toString();
        String bobotSoal=tf_bobotSoal.getText().toString();
        String levelSoal=tf_levelSoal.getText().toString();
        
        Api api=RetrofitClient.getRetrofit().create(Api.class);
        api.createSoal(kodeKuis, kodeTipe, soal, bobotSoal, levelSoal).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Platform.runLater(() -> {   
                    try{
                        FXMLLoader pindahSoal = new FXMLLoader(getClass().getResource("/tampilan/Kelola_Soal.fxml"));
                        Parent parents = pindahSoal.load();
                        Scene scene = new Scene(parents);
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.centerOnScreen();
                        stage.show();
                    }
                    catch(Exception e){
                        e.printStackTrace();
                    }
                    });
                }
                else{
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        
        

    }

    @FXML
    void onClickButtonUpdate(ActionEvent event) {
        if(tableSoal.getSelectionModel().getSelectedItem()!=null){
           Soal listSoal = tableSoal.getSelectionModel().getSelectedItem();
            
            Preferences preferences = Preferences.userRoot(); 
            preferences.putInt("id",listSoal.getId());
            preferences.put("kode_kuis",listSoal.getKode_kuis());
            preferences.put("kode_tipe",listSoal.getKode_tipe());
            preferences.put("soal",listSoal.getSoal());
            preferences.put("bobot_soal",listSoal.getBobot_soal());
            preferences.put("level_soal",listSoal.getLevel_soal());
            
            try{
                FXMLLoader pinda11 = new FXMLLoader(getClass().getResource("/tampilan/Edit_Soal.fxml"));
                Parent parent1 = pinda11.load();

                Scene scene = new Scene(parent1);
                Stage myStage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
                myStage1.setScene(scene);
                myStage1.centerOnScreen();
                myStage1.show();
            }catch(Exception e){
                e.printStackTrace();
            }
            
         
        }
      
    }
           
    @FXML
    void onClickButtonDelete(ActionEvent event) {
            if(tableSoal.getSelectionModel().getSelectedItem()!= null){
            Soal preferences = tableSoal.getSelectionModel().getSelectedItem();
            System.out.println(preferences.getKode_kuis());
            Api api = RetrofitClient.getRetrofit().create(Api.class);
            
            api.deleteSoal(preferences.getId()).enqueue(new Callback<ResponseBody>(){
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                            Platform.runLater(() -> {
                                try{
                                    FXMLLoader pinda = new FXMLLoader(getClass().getResource("/tampilan/Kelola_Soal.fxml"));
                                    Parent parent1 = pinda.load();

                                    Scene x = new Scene(parent1);
                                    Stage myStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    myStage.setScene(x);
                                    myStage.centerOnScreen();
                                    myStage.show();
                                }catch(Exception e){
                                    e.printStackTrace();
                                }
                            });
                    }
                    else{
                        System.out.println(response.message());               
                    }
                }

                @Override
                public void onFailure(Call<ResponseBody> call, Throwable throwable) {
                    System.out.println("Error: "+ throwable.getMessage());
                }
            });
        }
    }

 
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
       Preferences soalPreferences = Preferences.userRoot();
        String soal= soalPreferences.get("email",null);
        tampilSoal();
    }    
    
}
