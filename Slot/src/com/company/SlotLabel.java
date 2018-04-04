package com.company;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import java.util.Random;
import javafx.util.Duration;

public class SlotLabel extends Label {
    // アニメーションを行うためのTimeLineオブジェクト
    private Timeline timer;
    // スロットが回っている状態かを管理するフィールド
    private boolean isSlotStarted;

    SlotLabel(String text){
        super(text);
        isSlotStarted = false;
        // この下にthis.~という形で数字の見た目・揃える位置を記載しましょう
        this.setPrefSize(100,100);
        this.setAlignment(Pos.CENTER);
        this.setBorder(new Border(new BorderStroke(Color.BLACK,
                BorderStrokeStyle.SOLID, new CornerRadii(5), BorderWidths.DEFAULT)));
    }

    public void setSlotStarted(){
        // この中に各数字のスロットが回り始めた時の処理を記載しましょう
        if (isSlotStarted) {
            return;
        }
        // スロットが回っているのでisSlotStartedをtrueに変える
        isSlotStarted = true;

        Random rand = new Random();

        timer = new Timeline(new KeyFrame(Duration.millis(100), event -> {
            int randomNumber = rand.nextInt(9) + 1;
            this.setText(String.valueOf(randomNumber));
        }));

        // アニメーションをスタート
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

    }

    public void stopSlot() {
            // この中に各数字のスロットが止まった時の処理を記載しましょう

            if (isSlotStarted) {
                timer.stop();
                isSlotStarted = false;
            }

        }
    }