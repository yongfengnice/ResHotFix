package com.suyf.hotfixdev

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.suyf.hotfixdev.plugin.PluginMgr
import java.io.FileOutputStream

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val dexPath = getExternalFilesDir(null)?.absolutePath + "/hotfix_1-debug.apk"

        assets.open("hotfix_1-debug.apk").copyTo(FileOutputStream(dexPath))

        PluginMgr.init(application)
        PluginMgr.addAssetPath(dexPath, PluginMgr.hotFix1)

        val pluginResource = PluginMgr.pluginResource(PluginMgr.hotFix1)
        val layoutId = pluginResource?.getIdentifier("activity_main", "layout", PluginMgr.hotFix1) ?: 0
        val contentView = layoutInflater.inflate(pluginResource?.getXml(layoutId), null)
        setContentView(contentView)

        val btn111 = pluginResource?.getIdentifier("btn_111", "id", PluginMgr.hotFix1) ?: 0
        contentView.findViewById<View>(btn111)?.setOnClickListener {
            startActivity(Intent(this, SecondActivity::class.java))
        }
    }
}