package com.example.moreyl.maze;

import android.content.Context;
import android.graphics.Canvas;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by moreyl on 28.02.2018.
 */

public class GameManager extends GestureDetector.SimpleOnGestureListener {
    private List<Drawable> drawables = new ArrayList<>();
    private View view; // требуется ссылка на view
    private Player player;

    public GameManager() {
        //инициализируем в конструкторе
        player = new Player();
        drawables.add(player); // добавим в этот список наш объект Player
        drawables.add(new Maze());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int diffX = 0, diffY = 0;
        diffX = Math.round(e2.getX() - e1.getX());
        diffY = Math.round(e2.getY() - e1.getY());
        player.move(diffX, diffY);
        view.invalidate();
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    public void drow (Canvas canvas) { // список игрового мира которые могут быть отрисованы
        for (Drawable drawableItem: //перебераем все объекты для отрисовки
             drawables) {
            drawableItem.drow(canvas); // для каждого drawable вызовем метод drow()
        }



    }

    public void setView(View view) {
        this.view = view;
    }
}