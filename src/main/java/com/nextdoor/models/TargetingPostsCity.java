package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TargetingPostsCity extends NextDoorModel implements Serializable {
    @JsonProperty("city")
    private String city;

    @JsonProperty("state")
    private String state;

    @JsonProperty("country")
    private String country;

    @JsonProperty("city_post_count")
    private int cityPostCount;

    @JsonProperty("updated_at_epoch_seconds")
    private long updatedAtEpochSeconds;

    @JsonProperty("posts")
    private List<Post> posts;

    @JsonProperty("posts_length")
    private int postsLength;

    public TargetingPostsCity() {

    }

    public TargetingPostsCity(String city, String state, String country, int cityPostCount, long updatedAtEpochSeconds, List<Post> posts, int postsLength) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.cityPostCount = cityPostCount;
        this.updatedAtEpochSeconds = updatedAtEpochSeconds;
        this.posts = posts;
        this.postsLength = postsLength;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getCityPostCount() {
        return cityPostCount;
    }

    public void setCityPostCount(int cityPostCount) {
        this.cityPostCount = cityPostCount;
    }

    public long getUpdatedAtEpochSeconds() {
        return updatedAtEpochSeconds;
    }

    public void setUpdatedAtEpochSeconds(long updatedAtEpochSeconds) {
        this.updatedAtEpochSeconds = updatedAtEpochSeconds;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
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
        return "TargetingPostsCity{" +
                "city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", cityPostCount=" + cityPostCount +
                ", updatedAtEpochSeconds=" + updatedAtEpochSeconds +
                ", posts=" + posts +
                ", postsLength=" + postsLength +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Post {
        @JsonProperty("author")
        private Author author;

        @JsonProperty("body")
        private String body;

        @JsonProperty("category")
        private String category;

        @JsonProperty("comments")
        private List<String> comments;

        @JsonProperty("comment_closed")
        private boolean commentClosed;

        @JsonProperty("comment_count")
        private int commentCount;

        @JsonProperty("creation_date_epoch_seconds")
        private long creationDateEpochSeconds;

        @JsonProperty("downvote_count")
        private int downvoteCount;

        @JsonProperty("embed_url")
        private String embedUrl;

        @JsonProperty("has_geo_tag")
        private boolean hasGeoTag;

        @JsonProperty("id")
        private String id;

        @JsonProperty("in_popular_posts_curation")
        private boolean inPopularPostsCuration;

        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("longitude")
        private double longitude;

        @JsonProperty("url")
        private String url;

        @JsonProperty("media")
        private List<String> media;

        @JsonProperty("media_focal_area")
        private List<String> mediaFocalArea;

        @JsonProperty("public_post_url")
        private String publicPostUrl;

        @JsonProperty("reaction_types")
        private Map<String, Integer> reactionTypes;

        @JsonProperty("report_count")
        private int reportCount;

        @JsonProperty("scope")
        private String scope;

        @JsonProperty("score")
        private int score;

        @JsonProperty("title")
        private String title;

        @JsonProperty("user_entered_subject")
        private boolean userEnteredSubject;

        @JsonProperty("video_preview_url")
        private String videoPreviewUrl;

        public Post() {

        }

        public Post(Author author, String body, String category, List<String> comments, boolean commentClosed, int commentCount, long creationDateEpochSeconds, int downvoteCount, String embedUrl, boolean hasGeoTag, String id, boolean inPopularPostsCuration, double latitude, double longitude, String url, List<String> media, List<String> mediaFocalArea, String publicPostUrl, Map<String, Integer> reactionTypes, int reportCount, String scope, int score, String title, boolean userEnteredSubject, String videoPreviewUrl) {
            this.author = author;
            this.body = body;
            this.category = category;
            this.comments = comments;
            this.commentClosed = commentClosed;
            this.commentCount = commentCount;
            this.creationDateEpochSeconds = creationDateEpochSeconds;
            this.downvoteCount = downvoteCount;
            this.embedUrl = embedUrl;
            this.hasGeoTag = hasGeoTag;
            this.id = id;
            this.inPopularPostsCuration = inPopularPostsCuration;
            this.latitude = latitude;
            this.longitude = longitude;
            this.url = url;
            this.media = media;
            this.mediaFocalArea = mediaFocalArea;
            this.publicPostUrl = publicPostUrl;
            this.reactionTypes = reactionTypes;
            this.reportCount = reportCount;
            this.scope = scope;
            this.score = score;
            this.title = title;
            this.userEnteredSubject = userEnteredSubject;
            this.videoPreviewUrl = videoPreviewUrl;
        }

        public Author getAuthor() {
            return author;
        }

        public void setAuthor(Author author) {
            this.author = author;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public List<String> getComments() {
            return comments;
        }

        public void setComments(List<String> comments) {
            this.comments = comments;
        }

        public boolean isCommentClosed() {
            return commentClosed;
        }

        public void setCommentClosed(boolean commentClosed) {
            this.commentClosed = commentClosed;
        }

        public int getCommentCount() {
            return commentCount;
        }

        public void setCommentCount(int commentCount) {
            this.commentCount = commentCount;
        }

        public long getCreationDateEpochSeconds() {
            return creationDateEpochSeconds;
        }

        public void setCreationDateEpochSeconds(long creationDateEpochSeconds) {
            this.creationDateEpochSeconds = creationDateEpochSeconds;
        }

        public int getDownvoteCount() {
            return downvoteCount;
        }

        public void setDownvoteCount(int downvoteCount) {
            this.downvoteCount = downvoteCount;
        }

        public String getEmbedUrl() {
            return embedUrl;
        }

        public void setEmbedUrl(String embedUrl) {
            this.embedUrl = embedUrl;
        }

        public boolean isHasGeoTag() {
            return hasGeoTag;
        }

        public void setHasGeoTag(boolean hasGeoTag) {
            this.hasGeoTag = hasGeoTag;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public boolean isInPopularPostsCuration() {
            return inPopularPostsCuration;
        }

        public void setInPopularPostsCuration(boolean inPopularPostsCuration) {
            this.inPopularPostsCuration = inPopularPostsCuration;
        }

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public double getLongitude() {
            return longitude;
        }

        public void setLongitude(double longitude) {
            this.longitude = longitude;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public List<String> getMedia() {
            return media;
        }

        public void setMedia(List<String> media) {
            this.media = media;
        }

        public List<String> getMediaFocalArea() {
            return mediaFocalArea;
        }

        public void setMediaFocalArea(List<String> mediaFocalArea) {
            this.mediaFocalArea = mediaFocalArea;
        }

        public String getPublicPostUrl() {
            return publicPostUrl;
        }

        public void setPublicPostUrl(String publicPostUrl) {
            this.publicPostUrl = publicPostUrl;
        }

        public Map<String, Integer> getReactionTypes() {
            return reactionTypes;
        }

        public void setReactionTypes(Map<String, Integer> reactionTypes) {
            this.reactionTypes = reactionTypes;
        }

        public int getReportCount() {
            return reportCount;
        }

        public void setReportCount(int reportCount) {
            this.reportCount = reportCount;
        }

        public String getScope() {
            return scope;
        }

        public void setScope(String scope) {
            this.scope = scope;
        }

        public int getScore() {
            return score;
        }

        public void setScore(int score) {
            this.score = score;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public boolean isUserEnteredSubject() {
            return userEnteredSubject;
        }

        public void setUserEnteredSubject(boolean userEnteredSubject) {
            this.userEnteredSubject = userEnteredSubject;
        }

        public String getVideoPreviewUrl() {
            return videoPreviewUrl;
        }

        public void setVideoPreviewUrl(String videoPreviewUrl) {
            this.videoPreviewUrl = videoPreviewUrl;
        }

        @Override
        public String toString() {
            return "Post{" +
                    "author=" + author +
                    ", body='" + body + '\'' +
                    ", category='" + category + '\'' +
                    ", comments=" + comments +
                    ", commentClosed=" + commentClosed +
                    ", commentCount=" + commentCount +
                    ", creationDateEpochSeconds=" + creationDateEpochSeconds +
                    ", downvoteCount=" + downvoteCount +
                    ", embedUrl='" + embedUrl + '\'' +
                    ", hasGeoTag=" + hasGeoTag +
                    ", id='" + id + '\'' +
                    ", inPopularPostsCuration=" + inPopularPostsCuration +
                    ", latitude=" + latitude +
                    ", longitude=" + longitude +
                    ", url='" + url + '\'' +
                    ", media=" + media +
                    ", mediaFocalArea=" + mediaFocalArea +
                    ", publicPostUrl='" + publicPostUrl + '\'' +
                    ", reactionTypes=" + reactionTypes +
                    ", reportCount=" + reportCount +
                    ", scope='" + scope + '\'' +
                    ", score=" + score +
                    ", title='" + title + '\'' +
                    ", userEnteredSubject=" + userEnteredSubject +
                    ", videoPreviewUrl='" + videoPreviewUrl + '\'' +
                    '}';
        }
    }
}