package com.example.testtaskvrg.View.mapper

import com.example.testtaskvrg.View.model.DisplayablePost
import com.example.testtaskvrg.model.PostReddit
import javax.inject.Inject
import io.reactivex.functions.Function


class DisplayablePostMapper @Inject constructor(private val dateMapper: Function<Long, String>) : Function<PostReddit, DisplayablePost> {

    override fun apply(postReddit: PostReddit): DisplayablePost {
        return DisplayablePost(
            id = postReddit.id,
            author = postReddit.author,
            title = postReddit.title,
            contentHtml = htmlMaper.apply(postReddit.selftext_html),
            subredditName = postReddit.subreddit_name_prefixed,
            commentsCount = postReddit.num_comments,
            score = postReddit.score,
            created = dateMapper.apply(postReddit.created),
            thumbnail = postReddit.thumbnail,
            url = postReddit.url
        )
    }
}