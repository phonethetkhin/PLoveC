package com.ptk.pnclovecounter.repository

import android.app.Application
import javax.inject.Inject


class HomeRepository @Inject constructor(
    private val context: Application,
) {

    //=======================================DB functions=========================================//

//    suspend fun insertAllSourcesDB(sources: List<SourceEntity>) =
//        sourceDao.insertAllSources(sources)

}
