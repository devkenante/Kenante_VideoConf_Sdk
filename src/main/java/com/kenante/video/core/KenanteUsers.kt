package com.kenante.video.core

import android.util.SparseArray
import androidx.core.util.set
import com.kenante.video.enums.KenanteAudioCodec
import com.kenante.video.enums.KenanteBitrate
import com.kenante.video.enums.KenanteVideoCodec

object KenanteUsers {

    private val users = SparseArray<User>()
    internal val liveUsers = mutableListOf<Int>()

    fun setUserCallParameters(
        id: Int,
        audioCodec: KenanteAudioCodec,
        videoCodec: KenanteVideoCodec,
        bitrate: KenanteBitrate
    ) {
        users[id] = User(audioCodec, videoCodec, bitrate)
    }

    fun getUser(id: Int) : User?{
        return users[id]
    }

    fun setUsersContainer(user: Int) {
        users[user] = User(KenanteAudioCodec.opus, KenanteVideoCodec.vp8, KenanteBitrate.low)
    }

}

data class User(
    var audioCodec: KenanteAudioCodec = KenanteAudioCodec.opus,
    var videoCodec: KenanteVideoCodec = KenanteVideoCodec.vp8,
    var bitrate: KenanteBitrate = KenanteBitrate.low
)