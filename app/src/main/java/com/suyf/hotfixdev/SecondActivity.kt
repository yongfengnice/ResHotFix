package com.suyf.hotfixdev

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.suyf.hotfixdev.plugin.PluginMgr

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val pluginResource = PluginMgr.pluginResource(PluginMgr.hotFix1)
        val layoutId = pluginResource?.getIdentifier("activity_second", "layout", PluginMgr.hotFix1) ?: 0
        val contentView = layoutInflater.inflate(pluginResource?.getXml(layoutId), null)
        setContentView(contentView)
    }
}