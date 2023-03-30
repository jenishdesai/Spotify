package com.shubham.space.data.remote

import com.google.firebase.firestore.FirebaseFirestore
import com.plcoding.spotifycloneyt.data.entities.Song
import com.plcoding.spotifycloneyt.others.constants.SONG_COLLECTION
import kotlinx.coroutines.tasks.await

class MusicDataBase {
    private  val firestore = FirebaseFirestore.getInstance()
    private val SongCollection = firestore.collection(SONG_COLLECTION)
    suspend fun getAllSong() : List<Song>{
        return try {
            SongCollection.get().await().toObjects(Song::class.java)
        }catch (e : Exception){
            emptyList()
        }
    }
}