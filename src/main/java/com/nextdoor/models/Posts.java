package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.api.NextDoorAPIPosts;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.share.NextDoorAPIRequestNode;
import com.nextdoor.util.NextDoorUtil;

import java.io.Serializable;
import java.util.List;

public class Posts extends NextDoorModel implements Serializable {

    @JsonProperty("posts")
    private List<ExistedPost> posts;

    @JsonProperty("posts_length")
    private int postsLength;

    public Posts() {
    }

    public Posts(List<ExistedPost> posts, int postsLength) {
        this.posts = posts;
        this.postsLength = postsLength;
    }

    public List<ExistedPost> getPosts() {
        return posts;
    }

    public void setPosts(List<ExistedPost> posts) {
        this.posts = posts;
    }

    public int getPostsLength() {
        return postsLength;
    }

    public void setPostsLength(int postsLength) {
        this.postsLength = postsLength;
    }

    @Override
    public String toString() {
        return "Posts{" +
                "posts=" + posts +
                ", postsLength=" + postsLength +
                '}';
    }

    public static class ExistedPost extends NextDoorAPIRequestNode implements Serializable {
        @JsonProperty("author_id")
        private long authorId;

        @JsonProperty("body")
        private String body;

        @JsonProperty("comments")
        private List<Comment> comments;

        @JsonProperty("creation_date_epoch_seconds")
        private long creationDateEpochSeconds;

        @JsonProperty("embed_url")
        private String embedUrl;

        @JsonProperty("id")
        private String id;

        @JsonProperty("reactions")
        private List<Reaction> reactions;

        @JsonProperty("url")
        private String url;

        @JsonProperty("media")
        private List<Media> media;

        @JsonProperty("title")
        private String title;

        public ExistedPost() {
        }

        public ExistedPost(long authorId, String body, List<Comment> comments, long creationDateEpochSeconds, String embedUrl, String id, List<Reaction> reactions, String url, List<Media> media, String title) {
            this.authorId = authorId;
            this.body = body;
            this.comments = comments;
            this.creationDateEpochSeconds = creationDateEpochSeconds;
            this.embedUrl = embedUrl;
            this.id = id;
            this.reactions = reactions;
            this.url = url;
            this.media = media;
            this.title = title;
        }

        public long getAuthorId() {
            return authorId;
        }

        public void setAuthorId(long authorId) {
            this.authorId = authorId;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public List<Comment> getComments() {
            return comments;
        }

        public void setComments(List<Comment> comments) {
            this.comments = comments;
        }

        public long getCreationDateEpochSeconds() {
            return creationDateEpochSeconds;
        }

        public void setCreationDateEpochSeconds(long creationDateEpochSeconds) {
            this.creationDateEpochSeconds = creationDateEpochSeconds;
        }

        public String getEmbedUrl() {
            return embedUrl;
        }

        public void setEmbedUrl(String embedUrl) {
            this.embedUrl = embedUrl;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public List<Reaction> getReactions() {
            return reactions;
        }

        public void setReactions(List<Reaction> reactions) {
            this.reactions = reactions;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<Media> getMedia() {
            return media;
        }

        public void setMedia(List<Media> media) {
            this.media = media;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        @Override
        public String toString() {
            return "ExistedPost{" +
                    "authorId=" + authorId +
                    ", body='" + body + '\'' +
                    ", comments=" + comments +
                    ", creationDateEpochSeconds=" + creationDateEpochSeconds +
                    ", embedUrl='" + embedUrl + '\'' +
                    ", id='" + id + '\'' +
                    ", reactions=" + reactions +
                    ", url='" + url + '\'' +
                    ", media=" + media +
                    ", title='" + title + '\'' +
                    '}';
        }

        public NextDoorAPIPosts.NextDoorAPIEditPost editPost() {
            return new NextDoorAPIPosts.NextDoorAPIEditPost(this);
        }

        public NextDoorAPIPosts.NextDoorAPIDeletePost deletePost() {
            return new NextDoorAPIPosts.NextDoorAPIDeletePost(this);
        }
    }

    public static class Comment extends NextDoorAPIRequestNode implements Serializable {
        @JsonProperty("id")
        private long id;

        @JsonProperty("body")
        private String body;

        @JsonProperty("creation_date_epoch_seconds")
        private long creationDateEpochSeconds;

        @JsonProperty("parent_comment_id")
        private long parentCommentId;

        public Comment() {
        }

        public Comment(long id, String body, long creationDateEpochSeconds, long parentCommentId) {
            this.id = id;
            this.body = body;
            this.creationDateEpochSeconds = creationDateEpochSeconds;
            this.parentCommentId = parentCommentId;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public long getCreationDateEpochSeconds() {
            return creationDateEpochSeconds;
        }

        public void setCreationDateEpochSeconds(long creationDateEpochSeconds) {
            this.creationDateEpochSeconds = creationDateEpochSeconds;
        }

        public long getParentCommentId() {
            return parentCommentId;
        }

        public void setParentCommentId(long parentCommentId) {
            this.parentCommentId = parentCommentId;
        }

        @Override
        public String toString() {
            return "Comment{" +
                    "id=" + id +
                    ", body='" + body + '\'' +
                    ", creationDateEpochSeconds=" + creationDateEpochSeconds +
                    ", parentCommentId=" + parentCommentId +
                    '}';
        }

        public static NextDoorAPIPosts.NextDoorAPIEditComment editComment(String commentId, NextDoorAPIAuth nextDoorAPIAuth) {
            NextDoorUtil.ensureStringNotNull(commentId, "commentId");

            Comment comment = new Comment();
            comment.setId(Long.parseLong(commentId));
            comment.setNextDoorAPIAuth(nextDoorAPIAuth);
            return new NextDoorAPIPosts.NextDoorAPIEditComment(comment);
        }
    }

    public static class Reaction implements Serializable {
        @JsonProperty("id")
        private long id;

        @JsonProperty("post_id")
        private long postId;

        @JsonProperty("comment_id")
        private long commentId;

        @JsonProperty("type")
        private int type;

        public Reaction() {
        }

        public Reaction(long id, long postId, long commentId, int type) {
            this.id = id;
            this.postId = postId;
            this.commentId = commentId;
            this.type = type;
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public long getPostId() {
            return postId;
        }

        public void setPostId(long postId) {
            this.postId = postId;
        }

        public long getCommentId() {
            return commentId;
        }

        public void setCommentId(long commentId) {
            this.commentId = commentId;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Reaction{" +
                    "id=" + id +
                    ", postId=" + postId +
                    ", commentId=" + commentId +
                    ", type=" + type +
                    '}';
        }
    }

    public static class Media implements Serializable {
        @JsonProperty("is_photo")
        private boolean isPhoto;

        @JsonProperty("is_video")
        private boolean isVideo;

        @JsonProperty("url")
        private String url;

        @JsonProperty("width")
        private int width;

        @JsonProperty("height")
        private int height;

        public Media() {
        }

        public Media(boolean isPhoto, boolean isVideo, String url, int width, int height) {
            this.isPhoto = isPhoto;
            this.isVideo = isVideo;
            this.url = url;
            this.width = width;
            this.height = height;
        }

        public boolean isPhoto() {
            return isPhoto;
        }

        public void setPhoto(boolean isPhoto) {
            this.isPhoto = isPhoto;
        }

        public boolean isVideo() {
            return isVideo;
        }

        public void setVideo(boolean isVideo) {
            this.isVideo = isVideo;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        @Override
        public String toString() {
            return "Media{" +
                    "isPhoto=" + isPhoto +
                    ", isVideo=" + isVideo +
                    ", url='" + url + '\'' +
                    ", width=" + width +
                    ", height=" + height +
                    '}';
        }
    }
}