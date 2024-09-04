package com.nextdoor.models.search;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.models.NextDoorModel;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public class SearchPosts extends NextDoorModel implements Serializable {
    @JsonProperty("posts")
    private List<Post> posts;

    @JsonProperty("posts_length")
    private int postsLength;

    public SearchPosts() {

    }

    public SearchPosts(List<Post> posts, int postsLength) {
        this.posts = posts;
        this.postsLength = postsLength;
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
        return "SearchPosts{" +
                "posts=" + posts +
                ", postsLength=" + postsLength +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Post implements Serializable {
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

        @JsonProperty("latitude")
        private double latitude;

        @JsonProperty("like_count")
        private int likeCount;

        @JsonProperty("longitude")
        private double longitude;

        @JsonProperty("url")
        private String url;

        @JsonProperty("media")
        private List<String> media;

        @JsonProperty("media_focal_area")
        private List<Object> mediaFocalArea;

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

        @JsonProperty("scores")
        private List<Object> scores;

        @JsonProperty("title")
        private String title;

        @JsonProperty("user_entered_subject")
        private boolean userEnteredSubject;

        @JsonProperty("video_preview_url")
        private String videoPreviewUrl;

        public Post() {

        }

        public Post(Author author, String body, String category, List<String> comments, boolean commentClosed, int commentCount, long creationDateEpochSeconds, int downvoteCount, String embedUrl, boolean hasGeoTag, String id, double latitude, int likeCount, double longitude, String url, List<String> media, List<Object> mediaFocalArea, String publicPostUrl, Map<String, Integer> reactionTypes, int reportCount, String scope, int score, List<Object> scores, String title, boolean userEnteredSubject, String videoPreviewUrl) {
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
            this.latitude = latitude;
            this.likeCount = likeCount;
            this.longitude = longitude;
            this.url = url;
            this.media = media;
            this.mediaFocalArea = mediaFocalArea;
            this.publicPostUrl = publicPostUrl;
            this.reactionTypes = reactionTypes;
            this.reportCount = reportCount;
            this.scope = scope;
            this.score = score;
            this.scores = scores;
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

        public double getLatitude() {
            return latitude;
        }

        public void setLatitude(double latitude) {
            this.latitude = latitude;
        }

        public int getLikeCount() {
            return likeCount;
        }

        public void setLikeCount(int likeCount) {
            this.likeCount = likeCount;
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

        public List<Object> getMediaFocalArea() {
            return mediaFocalArea;
        }

        public void setMediaFocalArea(List<Object> mediaFocalArea) {
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

        public List<Object> getScores() {
            return scores;
        }

        public void setScores(List<Object> scores) {
            this.scores = scores;
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
                    ", latitude=" + latitude +
                    ", likeCount=" + likeCount +
                    ", longitude=" + longitude +
                    ", url='" + url + '\'' +
                    ", media=" + media +
                    ", mediaFocalArea=" + mediaFocalArea +
                    ", publicPostUrl='" + publicPostUrl + '\'' +
                    ", reactionTypes=" + reactionTypes +
                    ", reportCount=" + reportCount +
                    ", scope='" + scope + '\'' +
                    ", score=" + score +
                    ", scores=" + scores +
                    ", title='" + title + '\'' +
                    ", userEnteredSubject=" + userEnteredSubject +
                    ", videoPreviewUrl='" + videoPreviewUrl + '\'' +
                    '}';
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Author implements Serializable {
        @JsonProperty("name")
        private String name;

        @JsonProperty("type")
        private String type;

        @JsonProperty("neighborhood_name")
        private String neighborhoodName;

        @JsonProperty("neighborhood_url")
        private String neighborhoodUrl;

        @JsonProperty("city_url")
        private String cityUrl;

        @JsonProperty("agency_info")
        private Object agencyInfo;

        public Author() {

        }

        public Author(String name, String type, String neighborhoodName, String neighborhoodUrl, String cityUrl, Object agencyInfo) {
            this.name = name;
            this.type = type;
            this.neighborhoodName = neighborhoodName;
            this.neighborhoodUrl = neighborhoodUrl;
            this.cityUrl = cityUrl;
            this.agencyInfo = agencyInfo;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public String getNeighborhoodName() {
            return neighborhoodName;
        }

        public void setNeighborhoodName(String neighborhoodName) {
            this.neighborhoodName = neighborhoodName;
        }

        public String getNeighborhoodUrl() {
            return neighborhoodUrl;
        }

        public void setNeighborhoodUrl(String neighborhoodUrl) {
            this.neighborhoodUrl = neighborhoodUrl;
        }

        public String getCityUrl() {
            return cityUrl;
        }

        public void setCityUrl(String cityUrl) {
            this.cityUrl = cityUrl;
        }

        public Object getAgencyInfo() {
            return agencyInfo;
        }

        public void setAgencyInfo(Object agencyInfo) {
            this.agencyInfo = agencyInfo;
        }

        @Override
        public String toString() {
            return "Author{" +
                    "name='" + name + '\'' +
                    ", type='" + type + '\'' +
                    ", neighborhoodName='" + neighborhoodName + '\'' +
                    ", neighborhoodUrl='" + neighborhoodUrl + '\'' +
                    ", cityUrl='" + cityUrl + '\'' +
                    ", agencyInfo=" + agencyInfo +
                    '}';
        }
    }
}
