package com.fram.farmserv.Activities.BaseActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

abstract class BaseActivity : AppCompatActivity() {
    abstract fun setcontent_View(): Int
    abstract fun setOnClickListener()
    abstract fun Initialize_id()
    abstract fun initializedControl()
}