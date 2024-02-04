package kr.co.fastcampus.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import kr.co.fastcampus.data.model.BoardDTO

/**
 * @author soohwan.ok
 */
@Database(
    entities = [BoardDTO::class, RemoteKey::class],
    version = 1
)
@TypeConverters(CommentConverter::class)
abstract class BoardDatabase : RoomDatabase(){
    abstract fun boardDao():BoardDao

    abstract fun remoteKeyDao():RemoteKeyDao

}
