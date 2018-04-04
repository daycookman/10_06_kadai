package com.company;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javafx.scene.Scene;

import java.util.ArrayList;
import java.util.Collections;


public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        primaryStage.setTitle("Slot Machine");

//        表示する数字の配列
//        String[] number_array = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        //数字を表示するHBoxを作成
        HBox slot_box = new HBox(20d);
        slot_box.setAlignment(Pos.CENTER);

        ArrayList<SlotLabel> label_array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            label_array.add(new SlotLabel("1"));
        }

        slot_box.getChildren().addAll(label_array);

        //写経部分
        //ボタンの作成
        HBox buttonBox = new HBox(10d);
        buttonBox.setAlignment(Pos.CENTER);
        Button startButton = new Button("START");
        Button stopButton = new Button("STOP");
        buttonBox.getChildren().add(startButton);
        buttonBox.getChildren().add(stopButton);
        startButton.setPrefSize(100,50);
        stopButton.setPrefSize(100,50);

        VBox all_box = new VBox(20d);
        all_box.setAlignment(Pos.CENTER);
        all_box.getChildren().add(slot_box);
        all_box.getChildren().add(buttonBox);

        // StartボタンのAction設定
        startButton.setOnAction(event -> {
            for (int i = 0; i < label_array.size(); i++) {
                label_array.get(i).setSlotStarted();
            }
        });

        // StopボタンのAction設定
        stopButton.setOnAction(event -> {
            for(int i = 0; i < label_array.size() ;i++){
                label_array.get(i).stopSlot();
            }

            ArrayList<String> res = new ArrayList<>();
            for(int i = 0; i < label_array.size() ;i++){
                res.add(label_array.get(i).getText());
            }

            if (Collections.frequency(res, res.get(0)) == res.size()) {
                // 新しいウインドウを生成
                Stage newStage = new Stage();

                // モーダルウインドウに設定
                newStage.initModality(Modality.APPLICATION_MODAL);
                // オーナーを設定
                newStage.initOwner(primaryStage);

                // 新しいウインドウ内に配置するコンテンツを生成
                HBox hbox = new HBox();
                Label label = new Label("Congratulations！");
                label.setFont(new Font(20d));
                hbox.getChildren().add(label);

                newStage.setScene(new Scene(hbox));

                // 新しいウインドウを表示
                newStage.show();

            }
        });


          //自分で書いたコード
//        //STARTボタンを押した時の処理
//        start_button.setOnAction(event -> {
//            Random rand =new Random();
//            Timeline timer = new Timeline(new KeyFrame(Duration.millis(50), e ->{
//                int randomNumber = rand.nextInt(number_array.length);
//                //うまくいかない箇所
//                start_button.setText(number_array[randomNumber]);
//            }));
//
//            timer.setCycleCount(Timeline.INDEFINITE);
//            timer.play();
//
//            //STOPボタンを押した時の処理
//            stop_button.setOnAction(e -> {
//                timer.stop();
//            });
//        });



        //数字がそろった時の処理
//        そのヒント
//        check_button.setOnAction(event -> {
//            if(my_name.getText().equals("Vega")) {
//                //新しいウィンドウを作成
//                Stage newStage = new Stage();
//
//                //モーダルウィンドウに設定
//                newStage.initModality(Modality.APPLICATION_MODAL);
//                //オーナーの設定
//                newStage.initOwner(stage);
//
//                //新しいウィンドウ内に配置するコンテンツを生成
//                HBox hBox = new HBox();
//                Label label = new Label("こと座のベガ");
//                hBox.getChildren().add(label);
//                hBox.setAlignment(Pos.CENTER);
//
//                newStage.setScene(new Scene(hBox));
//
//                newStage.show();
//            }
//        });

//            //ボタンを表示するHBoxの作成
//        HBox hBox = new HBox(20);
//        hBox.setAlignment(Pos.CENTER);
//        hBox.getChildren().add(start_button);
//        hBox.getChildren().add(stop_button);
//
//        //borderPaneに追加
//        BorderPane borderPane = new BorderPane();
//        borderPane.setPadding(new Insets(30,10,10,10));
//        borderPane.setTop(numBox);
//        borderPane.setCenter(hBox);

        Scene scene = new Scene(all_box,400,200);
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}