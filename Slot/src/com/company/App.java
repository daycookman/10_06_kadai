package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.util.ArrayList;
import java.util.Random;

public class App extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception{
//        Label SlotLabel = new Label("1");

//        表示する数字の配列
        String[] number_array = {"1", "2", "3", "4", "5", "6", "7", "8", "9"};

        ArrayList<SlotLabel> label_array = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            label_array.add(new SlotLabel());
        }

        //数字を表示するHBoxを作成
        HBox numBox = new HBox(20d);
        numBox.setPadding(new Insets(10,10,10,10));
        numBox.setAlignment(Pos.CENTER);

        numBox.getChildren().addAll(label_array);

        //ボタンの作成
        Button start_button = new Button("START");
        start_button.setPrefSize(100,50);
        Button stop_button = new Button("STOP");
        stop_button.setPrefSize(100,50);

        //STARTボタンを押した時の処理
        start_button.setOnAction(event -> {
            Random rand =new Random();
            Timeline timer = new Timeline(new KeyFrame(Duration.millis(50), e ->{
                int randomNumber = rand.nextInt(number_array.length);
                //うまくいかない箇所
                start_button.setText(number_array[randomNumber]);
            }));

            timer.setCycleCount(Timeline.INDEFINITE);
            timer.play();

            //STOPボタンを押した時の処理
            stop_button.setOnAction(e -> {
                timer.stop();
            });
        });



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


            //ボタンを表示するHBoxの作成
        HBox hBox = new HBox(20);
        hBox.setAlignment(Pos.CENTER);
        hBox.getChildren().add(start_button);
        hBox.getChildren().add(stop_button);

        //borderPaneに追加
        BorderPane borderPane = new BorderPane();
        borderPane.setPadding(new Insets(30,10,10,10));
        borderPane.setTop(numBox);
        borderPane.setCenter(hBox);

        Scene scene = new Scene(borderPane,400,200);
        stage.setScene(scene);
        stage.show();

    }
}