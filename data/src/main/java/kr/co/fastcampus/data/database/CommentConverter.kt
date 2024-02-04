package kr.co.fastcampus.data.database

import androidx.room.TypeConverter
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kr.co.fastcampus.data.model.comment.CommentDTO

/**
 * @author soohwan.ok
 */
class CommentConverter {

    @TypeConverter
    fun fromCommentListToJson(commentList: List<CommentDTO>):String{
        return Json.encodeToString(commentList)
    }

    @TypeConverter
    fun fromJsonToCommentList(json:String):List<CommentDTO>{
        return Json.decodeFromString(json)
    }

    @TypeConverter
    fun fromCommentToJson(comment:CommentDTO):String{
        return Json.encodeToString(comment)
    }

    @TypeConverter
    fun fromJsonToComment(json:String):CommentDTO{
        return Json.decodeFromString(json)
    }
}