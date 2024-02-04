package kr.co.fastcampus.data.database

import androidx.paging.PagingSource
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kr.co.fastcampus.data.model.BoardDTO

/**
 * @author soohwan.ok
 */
@Dao
interface BoardDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(boards:List<BoardDTO>)

    @Query("DELETE FROM boarddto")
    fun deleteAll()

    @Query("SELECT * FROM boarddto ORDER BY id DESC")
    fun getAll():PagingSource<Int, BoardDTO>
}