package com.cibertec.proyectomoviles.common

import android.graphics.Bitmap
import android.util.Base64
import java.io.ByteArrayOutputStream

class Util {

    companion object{

        fun converterBase64(imageBitmap: Bitmap): String {

            val bytesArrayOutputStream = ByteArrayOutputStream()
            imageBitmap?.compress(Bitmap.CompressFormat.JPEG, 80, bytesArrayOutputStream)
            val bytes = bytesArrayOutputStream.toByteArray()
            return Base64.encodeToString(bytes, Base64.DEFAULT)
        }
    }
}