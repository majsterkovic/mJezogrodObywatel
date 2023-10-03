package pl.mjezogrodobywatel

import android.graphics.Bitmap
import android.graphics.Color
import com.google.zxing.BarcodeFormat
import com.google.zxing.oned.Code128Writer
import com.google.zxing.qrcode.QRCodeWriter

class CodeGenerators {

    public fun getQrCodeBitmap(text: String, size: Int): Bitmap {
        val bits = QRCodeWriter().encode(text, BarcodeFormat.QR_CODE, size, size)
        return Bitmap.createBitmap(size, size, Bitmap.Config.RGB_565).also {
            for (x in 0 until size) {
                for (y in 0 until size) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }

    public fun getBarCode128Bitmap(text: String, height: Int, width: Int): Bitmap {
        val bits = Code128Writer().encode(text, BarcodeFormat.CODE_128, width, height)
        return Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888).also {
            for (y in 0 until height) {
                for (x in 0 until width) {
                    it.setPixel(x, y, if (bits[x, y]) Color.BLACK else Color.WHITE)
                }
            }
        }
    }
}