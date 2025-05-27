package com.example.wog;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.util.AttributeSet;

import androidx.appcompat.widget.AppCompatImageView;

public class InwardBottomImageView extends AppCompatImageView {

    private Path clipPath = new Path();
    private float curveDepth = 80f; // глубина вогнутости в пикселях

    public InwardBottomImageView(Context context) {
        super(context);
        init();
    }

    public InwardBottomImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public InwardBottomImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        setWillNotDraw(false); // чтобы onDraw вызывался
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        clipPath.reset();

        // Начинаем с левого верхнего угла
        clipPath.moveTo(0, 0);

        // Идём вниз до точки перед вогнутостью
        clipPath.lineTo(0, h - curveDepth);

        // Рисуем квадратичную кривую — вогнутую дугу вверх
        clipPath.quadTo(w / 2f, h + curveDepth, w, h - curveDepth);

        // Поднимаемся к правому верхнему углу
        clipPath.lineTo(w, 0);

        // Замыкаем путь
        clipPath.close();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        // Обрезаем холст по пути (вогнутая форма)
        canvas.clipPath(clipPath);

        // Рисуем картинку
        super.onDraw(canvas);
    }

    // Метод для изменения глубины вогнутости из кода (если нужно)
    public void setCurveDepth(float depth) {
        this.curveDepth = depth;
        invalidate();
    }
}

