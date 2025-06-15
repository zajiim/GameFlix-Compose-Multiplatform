package org.neon.gameflix

import android.app.Application
import org.neon.gameflix.di.initKoin

class BaseApplication: Application() {
    override fun onCreate() {
        super.onCreate()
        initKoin()
    }
}