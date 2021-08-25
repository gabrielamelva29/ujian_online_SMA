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
import model.Kuis;
import okhttp3.ResponseBody;
import response.KuisResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * FXML Controller class
 *
 * @author gabri
 */
public class Kelola_KuisController implements Initializable {
    
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
    private TableView<Kuis> tableKuis;

    @FXML
    private TableColumn<Kuis, Integer> col_id;

    @FXML
    private TableColumn<Kuis, String> col_kodeKuis;

    @FXML
    private TableColumn<Kuis, String> col_namaKuis;

    @FXML
    private TableColumn<Kuis, String> col_matakuliah;

    @FXML
    private TableColumn<Kuis, String> col_infoKuis;

    @FXML
    private TableColumn<Kuis, String> col_durasi;

    @FXML
    private TextField tf_kodeKuis;

    @FXML
    private TextField tf_namaKuis;

    @FXML
    private TextField tf_matakuliah;

    @FXML
    private TextField tf_infoKuis;

    @FXML
    private TextField tf_durasi;

    @FXML
    private Button btnTambah;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnReset;
    
    
     ObservableList<Kuis> observableList=FXCollections.observableArrayList();
    
    
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
    void onClickSoal(ActionEvent event) throws IOException {
        FXMLLoader pindah3=new FXMLLoader(getClass().getResource("/tampilan/Kelola_Soal.fxml"));
        Parent root=pindah3.load();
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

    public void tampilKuis(){
        Api api=RetrofitClient.getRetrofit().create(Api.class);
        
        Call<KuisResponse> call=api.allKuis();
        call.enqueue(new Callback<KuisResponse>(){
            @Override
            public void onResponse(Call<KuisResponse> call, Response<KuisResponse> response) {
                if(response.isSuccessful()){
                    int size=response.body().getKuis().size();
                    List<Kuis> listKuis=response.body().getKuis();
                    
                    for(int i=0; i<size; i++){
                      
                        observableList.add(new Kuis(listKuis.get(i).getId(), listKuis.get(i).getKode_kuis(), listKuis.get(i).getNama_kuis(), listKuis.get(i).getMatakuliah(), listKuis.get(i).getInfo_kuis(), listKuis.get(i).getDurasi()));
                           
                    }
                    
                    col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
                    col_kodeKuis.setCellValueFactory(new PropertyValueFactory<>("kode_kuis"));
                    col_namaKuis.setCellValueFactory(new PropertyValueFactory<>("nama_kuis"));
                    col_matakuliah.setCellValueFactory(new PropertyValueFactory<>("matakuliah"));
                    col_infoKuis.setCellValueFactory(new PropertyValueFactory<>("info_kuis"));
                    col_durasi.setCellValueFactory(new PropertyValueFactory<>("durasi"));
                   
                    tableKuis.setItems(observableList);
                }
                else{
                    System.out.println(response.message());
                }
            }

            @Override
            public void onFailure(Call<KuisResponse> call, Throwable thrwbl) {
                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
            
        });
    }

    @FXML
    void onClickButtonReset(ActionEvent event) {
        tf_kodeKuis.setText("");
        tf_namaKuis.setText("");
        tf_matakuliah.setText("");
        tf_infoKuis.setText("");
        tf_durasi.setText("");

    }

    @FXML
    void onClickButtonTambah(ActionEvent event) {
        Preferences preferences=Preferences.userRoot();
        
        String kodeKuis=tf_kodeKuis.getText().toString();
        String namaKuis=tf_namaKuis.getText().toString();
        String matakuliah=tf_matakuliah.getText().toString();
        String infoKuis=tf_infoKuis.getText().toString();
        String durasi=tf_durasi.getText().toString();
        
        Api api=RetrofitClient.getRetrofit().create(Api.class);
        api.createKuis(kodeKuis, namaKuis, matakuliah, infoKuis, durasi).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if(response.isSuccessful()){
                    Platform.runLater(() -> {   
                    try{
                        FXMLLoader pindaKuis = new FXMLLoader(getClass().getResource("/tampilan/Kelola_Kuis.fxml"));
                        Parent parents = pindaKuis.load();
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
        if(tableKuis.getSelectionModel().getSelectedItem()!=null){
           Kuis listKuis = tableKuis.getSelectionModel().getSelectedItem();
            
            Preferences preferences = Preferences.userRoot(); 
            preferences.putInt("id",listKuis.getId());
            preferences.put("kode_kuis",listKuis.getKode_kuis());
            preferences.put("nama_kuis",listKuis.getNama_kuis());
            preferences.put("matakuliah",listKuis.getMatakuliah());
            preferences.put("info_kuis",listKuis.getInfo_kuis());
            preferences.put("durasi",listKuis.getDurasi());
            
            try{
                FXMLLoader pindahEditKuis = new FXMLLoader(getClass().getResource("/tampilan/Edit_Kuis.fxml"));
                Parent parent1 = pindahEditKuis.load();

                Scene scene = new Scene(parent1);
                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                stage.setScene(scene);
                stage.centerOnScreen();
                stage.show();
            }catch(Exception e){
                e.printStackTrace();
            }
            
         
        }
      
    }
           
    @FXML
    void onClickButtonDelete(ActionEvent event) {
            if(tableKuis.getSelectionModel().getSelectedItem()!= null){
            Kuis preferences = tableKuis.getSelectionModel().getSelectedItem();
            System.out.println(preferences.getKode_kuis());
            Api api = RetrofitClient.getRetrofit().create(Api.class);
            
            api.deleteKuis(preferences.getId()).enqueue(new Callback<ResponseBody>(){
                @Override
                public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                    if(response.isSuccessful()){
                            Platform.runLater(() -> {
                                try{
                                    FXMLLoader pindahKuis = new FXMLLoader(getClass().getResource("/tampilan/Kelola_Kuis.fxml"));
                                    Parent parent1 = pindahKuis.load();

                                    Scene scene = new Scene(parent1);
                                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                                    stage.setScene(scene);
                                    stage.centerOnScreen();
                                    stage.show();
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
        Preferences kuisPreferences = Preferences.userRoot();
        String kuis = kuisPreferences.get("email",null);
        tampilKuis();
    }    
    
}
