package com.jomhack.lendme.components

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.support.v7.widget.AppCompatEditText
import android.util.AttributeSet
import com.jomhack.lendme.R
import com.jomhack.lendme.logger.JomHackLog


/**
 * Created by Al on 06/10/2018 for JomHack
 */

class JomEditText : AppCompatEditText {

    private var mFont: String = "R"
    private var mPath: String = "fonts/Montserrat-"
    private var mType: String = ".ttf"

    constructor(context: Context) : super(context)


    constructor(context: Context, attrs: AttributeSet?) : super(context, attrs) {
        setValues(attrs)
        init()
    }

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    private fun init() {
        setFont(mFont)
        setNewTypeFace()
    }

    fun setFont(font: String) {
        mFont = font
    }

    private fun setNewTypeFace() {
        val font = Typeface.createFromAsset(context.assets, mPath + mFont + mType)
        setTypeface(font, Typeface.NORMAL)
    }

    @SuppressLint("CustomViewStyleable")
    private fun setValues(attrs: AttributeSet?) {
        val attr = context.obtainStyledAttributes(attrs, R.styleable.JomView)
        try {
            val n = attr.indexCount
            for (i in 0 until n) {
                val attribute = attr.getIndex(i)
                when (attribute) {
                    R.styleable.JomView_JomFont -> mFont = attr.getString(attribute)
                    else -> JomHackLog.d("Unknown attribute for " + javaClass.toString() + ": " + attribute)
                }
            }
        } finally {
            attr.recycle()
        }
    }

}