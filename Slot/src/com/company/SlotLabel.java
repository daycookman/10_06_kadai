package com.company;

import javafx.animation.Timeline;
import javafx.scene.control.Label;

public class SlotLabel extends Label {
    // アニメーションを行うためのTimeLineオブジェクト
//    private Timeline timer;
    // スロットが回っている状態かを管理するフィールド
//    private boolean isSlotStarted;

    SlotLabel(){
        //この下にthis.~という形で数字の見た目・揃える位置を記載しましょう
        super();
        this.setText("1");
        this.setPrefSize(50,50);

    }

    public void setSlotStarted(){
        // この中に各数字のスロットが回り始めた時の処理を記載しましょう
    }

    public void stopSlot() {
        // この中に各数字のスロットが止まった時の処理を記載しましょう
    }

}