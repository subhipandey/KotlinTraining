package com.subhipandey.android.datadrop.model

import android.database.Cursor
import android.database.CursorWrapper
import com.google.android.gms.maps.model.LatLng
import com.subhipandey.android.datadrop.model.DropDbSchema.DropTable

class DropCursorWrapper(cursor: Cursor) : CursorWrapper(cursor){
    fun getDrop(): Drop {
        val id = getString(getColumnIndex(DropTable.Columns.ID))
        val latitude = getDouble(getColumnIndex(DropTable.Columns.LATITUDE))
        val longitude = getDouble(getColumnIndex(DropTable.Columns.LONGITUDE))
        val dropMessage = getString(getColumnIndex(DropTable.Columns.DROP_MESSAGE))
        val markerColor = getInt(getColumnIndex(DropTable.Columns.MARKER_COLOR))
        return Drop(LatLng(latitude,longitude), dropMessage, id, markerColor)
    }

}