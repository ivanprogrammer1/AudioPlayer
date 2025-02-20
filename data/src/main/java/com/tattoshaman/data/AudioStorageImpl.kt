package com.tattoshaman.data

import android.content.ContentResolver
import android.net.Uri
import android.provider.MediaStore
import com.tattoshaman.data.entities.AudioEntity
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

class AudioStorageImpl(
    private val contentResolver: ContentResolver
) : AudioStorage {
    override suspend fun getList(): List<AudioEntity> {
        return suspendCoroutine { continuation ->
            contentResolver.query(
                MediaStore.Audio.Media.EXTERNAL_CONTENT_URI,
                null,
                null,
                null,
                null
            )?.use { cursor ->
                val list = arrayListOf<AudioEntity>()
                while (cursor.moveToNext()) {
                    list.add(
                        AudioEntity(
                            1, Uri.EMPTY, "Пустое имя"
                        )
                    )
                }
                continuation.resume(list)
            } ?: run {
                continuation.resumeWithException(Exception("Not contains cursor"))
            }
        }
    }
}