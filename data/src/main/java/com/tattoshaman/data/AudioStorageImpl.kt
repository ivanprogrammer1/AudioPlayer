package com.tattoshaman.data

import android.content.ContentResolver
import android.content.ContentUris
import android.net.Uri
import android.provider.MediaStore
import android.util.Log
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
                arrayOf(
                    MediaStore.Audio.Media._ID,
                    MediaStore.Audio.Media.TITLE,
                    MediaStore.Audio.Media.DURATION
                ),
                null,
                null,
                null
            )?.use { cursor ->
                val list = arrayListOf<AudioEntity>()
                while (cursor.moveToNext()) {
                    val id = cursor.getLong(0)
                    val name = cursor.getString(1)
                    val duration = cursor.getLong(2)
                    val uri =
                        ContentUris.withAppendedId(MediaStore.Audio.Media.EXTERNAL_CONTENT_URI, id)


                    list.add(
                        AudioEntity(
                            id,
                            uri,
                            duration,
                            name
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