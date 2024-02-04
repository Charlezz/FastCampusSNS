package kr.co.fastcampus.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author soohwan.ok
 */
@Entity("remote_key")
class RemoteKey(
    @PrimaryKey val nextPage: Int
)