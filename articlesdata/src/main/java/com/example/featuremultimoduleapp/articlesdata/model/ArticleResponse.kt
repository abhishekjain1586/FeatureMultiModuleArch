package com.example.featuremultimoduleapp.articlesdata.model

data class ArticleResponse(
    val id: Int,
    val title: String,
    val description: String?,
    val published_timestamp: String,
    val comments_count: Int,
    val public_reactions_count: Int,
    val positive_reactions_count: Int,
    val cover_image: String?,
    val reading_time_minutes: String,
    val tag_list: List<String>?,
    val user: User?,
    val organization: Organization?
)
