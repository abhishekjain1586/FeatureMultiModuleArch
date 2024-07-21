package com.example.featuremultimoduleapp.articlesdata.mapper

import com.example.featuremultimoduleapp.articlesdata.model.ArticleResponse
import com.example.featuremultimoduleapp.articlesdomain.model.Article
import com.example.featuremultimoduleapp.articlesdomain.model.Organization
import com.example.featuremultimoduleapp.articlesdomain.model.User
import javax.inject.Inject
import com.example.featuremultimoduleapp.articlesdata.model.Organization as OrganizationDto
import com.example.featuremultimoduleapp.articlesdata.model.User as UserDto

class ArticlesMapper @Inject constructor() {

    fun mapToDomainModel(articlesResponse: List<ArticleResponse>?): List<Article>? {
        return articlesResponse?.map {
            Article(
                id = it.id,
                title = it.title,
                description = it.description,
                published_timestamp = it.published_timestamp,
                comments_count = it.comments_count,
                public_reactions_count = it.public_reactions_count,
                positive_reactions_count = it.positive_reactions_count,
                cover_image = it.cover_image,
                reading_time_minutes = it.reading_time_minutes,
                tag_list = it.tag_list,
                user = getUser(it.user),
                organization = getOrganization(it.organization)
            )
        }
    }

    private fun getUser(userDto: UserDto?): User? {
        return userDto?.let {
            User(
                name = it.name,
                username = it.username,
                user_id = it.user_id,
                profile_image = it.profile_image,
                profile_image_90 = it.profile_image_90
            )
        }
    }

    private fun getOrganization(organizationDto: OrganizationDto?): Organization? {
        return organizationDto?.let {
            Organization(
                name = it.name,
                username = it.username,
                profile_image = it.profile_image,
                profile_image_90 = it.profile_image_90
            )
        }
    }
}