package utils

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.view.animation.Transformation
import androidx.annotation.FloatRange

class AlphaTransform (@FloatRange(from =0.0, to = 1.0) alpha: Float) : com.squareup.picasso.Transformation {
    private val alpha: Int = (alpha * 255 ).toInt()
    override fun key(): String {

        return "alphaTransform: $alpha"
    }

    override fun transform(source: Bitmap): Bitmap {
        val height = source.height
        val width = source.width
        val alphaBitmap = Bitmap.createBitmap(width, height, source.config)

        val canvas = Canvas(alphaBitmap)
        canvas.drawARGB(0,0,0,0)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)

        paint.alpha = alpha

        canvas.drawBitmap(source,0f, 0f, paint)

        if(alphaBitmap != source) {
            source.recycle()
        }

        return alphaBitmap

    }
}