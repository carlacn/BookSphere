package com.carlacampo.booksphere.bbdd

import android.provider.BaseColumns

object BookDBScheme : BaseColumns {
    const val TABLE_NAME ="books"
    const val COLUMN_NAME ="title"
    const val COLUMN_AUTHOR ="author"
    const val COLUMN_PUBLICATION_YEAR ="publicationYear"
    const val COLUMN_EDITORIAL ="editorial"
    const val COLUMN_PAGES ="pages"

    const val SQL_CREATE_ENTRIES = """
        CREATE TABLE ${BookDBScheme.TABLE_NAME}(
            ${BookDBScheme.COLUMN_NAME} TEXT PRIMARY KEY,
            ${BookDBScheme.COLUMN_AUTHOR} TEXT,
            ${BookDBScheme.COLUMN_PUBLICATION_YEAR} INT,
            ${BookDBScheme.COLUMN_EDITORIAL} TEXT,
            ${BookDBScheme.COLUMN_PAGES} INT
        )
    """

    private const val SQL_DELETE_ENTRIES = "DROP TABLE IF EXISTS ${BookDBScheme.TABLE_NAME}"

}