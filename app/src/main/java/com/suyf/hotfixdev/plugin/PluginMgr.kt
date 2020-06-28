package com.suyf.hotfixdev.plugin

import android.app.Application
import android.content.Context
import android.content.res.AssetManager
import android.content.res.Resources
import android.util.Log
import dalvik.system.DexClassLoader
import java.io.File

object PluginMgr {
    private val TAG = "LogUtils"

    val hotFix1 = "com.suyf.hotfix_1"

    private lateinit var mainContext: Context
    private val resourceMap: MutableMap<String, Resources> = mutableMapOf()

    fun init(appContext: Application) {
        mainContext = appContext
    }

    fun addAssetPath(dexPath: String, packName: String) {
        if (resourceMap.containsKey(packName)) {
            return
        }
        val mainResources = mainContext.resources
        Log.d(TAG, "dexPath:$dexPath,exist:${File(dexPath).exists()}")
        val pluginAssetManager = AssetManager::class.java.newInstance()
        val addAssetPathMethod = AssetManager::class.java.getDeclaredMethod("addAssetPath", String::class.java)
        addAssetPathMethod.isAccessible = true
        addAssetPathMethod.invoke(pluginAssetManager, dexPath)
        val pluginResources = Resources(pluginAssetManager, mainResources.displayMetrics, mainResources.configuration)
        resourceMap[packName] = pluginResources
    }

    fun pluginResource(packName: String): Resources? {
        return resourceMap[packName]
    }

}