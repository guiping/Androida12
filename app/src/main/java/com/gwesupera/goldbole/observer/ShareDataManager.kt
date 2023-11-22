package com.gwesupera.goldbole.observer

object ShareDataManager {
    private val shareDataList: ArrayList<ObserverCallback> = ArrayList()
    fun setShareDataCallback(observerCallback: ObserverCallback) {
        if (!shareDataList.contains(observerCallback))
            shareDataList.add(observerCallback)
    }

      fun updateCallback(avatarId: Int) {
        for (value in shareDataList) {
            value.onCallback(avatarId)
        }
    }
}