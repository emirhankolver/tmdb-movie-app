package com.emirhankolver.tmdbapp.utils

import java.text.SimpleDateFormat
import java.util.Locale

object DateUtils {

    fun formatToLocalDate(dateString: String?): String {
        return try {
            // Parse the input date string
            val inputFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val date = inputFormat.parse(dateString!!) // Converts to a Date object

            // Format the date into a local format
            val outputFormat =
                SimpleDateFormat.getDateInstance(SimpleDateFormat.DATE_FIELD, Locale.getDefault())
            return outputFormat.format(date!!)
        } catch (t: Throwable) {
            "-"
        }
    }
}