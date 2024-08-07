package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.share.*;
import com.nextdoor.util.NextDoorUtil;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL;

public class NextDoorAPIPosts extends NextDoorAPIRequestNode {
    private static final String POST_PREFIX = "post";

    public NextDoorAPIPosts() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPosts(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPICreateDefaultPost createDefaultPost() {
        return new NextDoorAPICreateDefaultPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICreateAgencyPost createAgencyPost() {
        return new NextDoorAPICreateAgencyPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICreateEventPost createEventPost() {
        return new NextDoorAPICreateEventPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICreateFSFPost createFSFPost() {
        return new NextDoorAPICreateFSFPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPICommentToPostOrReplyToComment commentToPostOrReplyToComment() {
        return new NextDoorAPICommentToPostOrReplyToComment(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIGetAllPosts getAllPosts() {
        return new NextDoorAPIGetAllPosts(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPIGetAllPosts extends NextDoorAPIRequest<Posts> implements NextDoorAPIGet<Posts> {
        public NextDoorAPIGetAllPosts(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Posts.class, nextDoorAPIAuth);
        }

        public NextDoorAPIGetAllPosts setSecureProfileID(String secureProfileID) {
            this.addHeader("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public Posts get() throws APIRequestException {
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new PostException("Cannot get all posts, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {

        }
    }

    public static class NextDoorAPICreateDefaultPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        public NextDoorAPICreateDefaultPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateDefaultPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateDefaultPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateDefaultPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to " + POST_PREFIX);
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPICreateDefaultPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPICreateDefaultPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPICreateDefaultPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPICreateDefaultPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        public NextDoorAPICreateDefaultPost setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public Post create() throws APIRequestException {
            validateRequiredParams();

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new PostCreationException("Cannot create default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }
    }

    public static class NextDoorAPICreateAgencyPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        public NextDoorAPICreateAgencyPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateAgencyPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateAgencyPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateAgencyPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to " + POST_PREFIX);
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPICreateAgencyPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPICreateAgencyPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPICreateAgencyPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPICreateAgencyPost setRadius(String radius) {
            this.setParamInternal("radius", radius);

            return this;
        }

        public NextDoorAPICreateAgencyPost setGroupIDs(Collection<Integer> groupIDs) {
            if (groupIDs == null) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("group_ids", groupIDs);

            return this;
        }

        public NextDoorAPICreateAgencyPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        @Override
        public Post create() throws APIRequestException {
            validateRequiredParams();

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new PostCreationException("Cannot agency default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }
    }

    public static class NextDoorAPICreateEventPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        private static final String EVENT_NAME = "event";

        public NextDoorAPICreateEventPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateEventPost setEvent(Event event) {
            this.setParamInternal(EVENT_NAME, event);

            return this;
        }

        public NextDoorAPICreateEventPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateEventPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateEventPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to " + POST_PREFIX);
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPICreateEventPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to " + POST_PREFIX);

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPICreateEventPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPICreateEventPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPICreateEventPost setRadius(String radius) {
            this.setParamInternal("radius", radius);

            return this;
        }

        public NextDoorAPICreateEventPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        @Override
        public Post create() throws APIRequestException {
            validateRequiredParams();

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
            try {
                return sendHttpRequest(HttpMethod.POST, getPath() + "?" + EVENT_NAME + "=" + ((Event) this.getParamInternal(EVENT_NAME)).toUrlEncodedString());
            } catch (APIRequestException | IllegalAccessException | UnsupportedEncodingException e) {
                throw new PostCreationException("Cannot agency default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/" + EVENT_NAME + "/";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
            Event event = (Event) this.getParamInternal(EVENT_NAME);
            NextDoorUtil.ensureObjectNotNull(event, EVENT_NAME);

            NextDoorUtil.ensureStringNotNull(event.getTitle(), EVENT_NAME + ".title");
            NextDoorUtil.ensureStringNotNull(event.getDescription(), EVENT_NAME + ".description");
            NextDoorUtil.ensureObjectNotNull(event.getStartTime(), EVENT_NAME + ".startTime");
        }
    }

    public static class NextDoorAPICreateFSFPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        private static final String FSF_NAME = "fsf";

        public NextDoorAPICreateFSFPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPICreateFSFPost setFSF(FSF fsf) {
            this.setParamInternal(FSF_NAME, fsf);

            return this;
        }

        public NextDoorAPICreateFSFPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICreateFSFPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPICreateFSFPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        @Override
        public Post create() throws APIRequestException {
            validateRequiredParams();

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
            try {
                return sendHttpRequest(HttpMethod.POST, getPath() + "?" + FSF_NAME + "=" + ((FSF) this.getParamInternal(FSF_NAME)).toUrlEncodedString());
            } catch (APIRequestException | IllegalAccessException | UnsupportedEncodingException e) {
                throw new PostCreationException("Cannot agency default " + POST_PREFIX + " because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX + "/" + FSF_NAME + "/";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
            FSF fsf = (FSF) this.getParamInternal(FSF_NAME);
            NextDoorUtil.ensureObjectNotNull(fsf, FSF_NAME);

            NextDoorUtil.ensureStringNotNull(fsf.getTitle(), FSF_NAME + ".title");
            NextDoorUtil.ensureStringNotNull(fsf.getDescription(), FSF_NAME + ".description");
            NextDoorUtil.ensureStringNotNull(fsf.getPrice(), FSF_NAME + ".price");
            NextDoorUtil.ensureStringNotNull(fsf.getCategory(), FSF_NAME + ".category");

            Collection<String> imageAttachments = fsf.getImageAttachments();
            NextDoorUtil.ensureObjectNotNull(imageAttachments, FSF_NAME + ".image_attachments");
            if (imageAttachments.size() > 10) {
                throw new RuntimeException("Cannot attach attachments to " + POST_PREFIX + ", because there are more than 10 images");
            }
        }
    }

    public static class NextDoorAPICommentToPostOrReplyToComment extends NextDoorAPIRequest<CommentToPostOrReplyToComment> implements NextDoorAPICreate<CommentToPostOrReplyToComment> {
        public NextDoorAPICommentToPostOrReplyToComment(NextDoorAPIAuth nextDoorAPIAuth) {
            super(CommentToPostOrReplyToComment.class, nextDoorAPIAuth);
        }

        public NextDoorAPICommentToPostOrReplyToComment setPostOrCommentID(String postOrCommentID) {
            this.setParamInternal("id", postOrCommentID);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setMediaAttachments(Collection<String> mediaAttachments) {
            this.setParamInternal("media_attachments", mediaAttachments);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setParentCommentID(String parentCommentID) {
            this.setParamInternal("parent_comment_id", parentCommentID);

            return this;
        }

        public NextDoorAPICommentToPostOrReplyToComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public CommentToPostOrReplyToComment create() throws APIRequestException {
            validateRequiredParams();
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
            try {
                return sendHttpRequest(HttpMethod.POST);
            } catch (APIRequestException e) {
                throw new CommentToAPostOrReplyToACommentExcepton("Cannot reply to a comment or create comment to " + POST_PREFIX + ", because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "comment/";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("id"), "id");
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }

        public static class CommentToAPostOrReplyToACommentExcepton extends APIRequestException {
            public CommentToAPostOrReplyToACommentExcepton() {
            }

            public CommentToAPostOrReplyToACommentExcepton(String s) {
                super(s);
            }

            public CommentToAPostOrReplyToACommentExcepton(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CommentToAPostOrReplyToACommentExcepton(Throwable throwable) {
                super(throwable);
            }

            public CommentToAPostOrReplyToACommentExcepton(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIEditPost extends NextDoorAPIRequest<Post> implements NextDoorAPIEdit<Post> {
        public NextDoorAPIEditPost(Posts.ExistedPost existedPost) {
            super(Post.class, existedPost.getNextDoorAPIAuth());

            NextDoorUtil.ensureObjectNotNull(existedPost, "existedPost");
            String postId = existedPost.getId();
            NextDoorUtil.ensureStringNotNull(postId, "postId");
            this.setParamInternal("id", postId);
        }

        public NextDoorAPIEditPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIEditPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPIEditPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPIEditPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPIEditPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        public NextDoorAPIEditPost setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public Post edit() throws APIRequestException {
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.POST, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new PostEditException("Cannot get all posts, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {

        }

        public static class PostEditException extends APIRequestException {
            public PostEditException() {
            }

            public PostEditException(String s) {
                super(s);
            }

            public PostEditException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public PostEditException(Throwable throwable) {
                super(throwable);
            }

            public PostEditException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIEditComment extends NextDoorAPIRequest<EditedComment> implements NextDoorAPIEdit<EditedComment> {
        public NextDoorAPIEditComment() {
            super(EditedComment.class, NextDoorAPIAuth.defaultNextDoorAPIAuth());
        }

        public NextDoorAPIEditComment(Posts.Comment comment) {
            super(EditedComment.class, comment.getNextDoorAPIAuth());

            this.setParamInternal("id", comment.getId());
        }

        public NextDoorAPIEditComment setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIEditComment setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public EditedComment edit() throws APIRequestException {
            validateRequiredParams();
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.PUT, ConversionType.JSON);
            } catch (APIRequestException e) {
                throw new CommentEditException("Cannot edit comment, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "comment/";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }

        public static class CommentEditException extends APIRequestException {
            public CommentEditException() {
            }

            public CommentEditException(String s) {
                super(s);
            }

            public CommentEditException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public CommentEditException(Throwable throwable) {
                super(throwable);
            }

            public CommentEditException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDeletePost extends NextDoorAPIRequest<DeletedModel> implements NextDoorAPIDelete<DeletedModel> {
        private Posts.ExistedPost existedPost;

        public NextDoorAPIDeletePost() {
            super(DeletedModel.class, NextDoorAPIAuth.defaultNextDoorAPIAuth());
        }

        public NextDoorAPIDeletePost(Posts.ExistedPost existedPost) {
            super(DeletedModel.class, existedPost.getNextDoorAPIAuth());
            this.existedPost = existedPost;
        }

        public NextDoorAPIDeletePost setSecureProfileID(String secureProfileID) {
            this.setParamInternal("secure_profile_id", secureProfileID);

            return this;
        }

        @Override
        public DeletedModel delete() throws APIRequestException {
            validateRequiredParams();
            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());

            try {
                return sendHttpRequest(HttpMethod.DELETE, getPath() + "?id=" + this.existedPost.getId());
            } catch (APIRequestException e) {
                throw new PostDeleteException("Cannot delete post, because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + POST_PREFIX;
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("secure_profile_id"), "secure_profile_id");
        }

        public static class PostDeleteException extends APIRequestException {
            public PostDeleteException() {
            }

            public PostDeleteException(String s) {
                super(s);
            }

            public PostDeleteException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public PostDeleteException(Throwable throwable) {
                super(throwable);
            }

            public PostDeleteException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class PostException extends APIRequestException {
        public PostException() {
        }

        public PostException(String s) {
            super(s);
        }

        public PostException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public PostException(Throwable throwable) {
            super(throwable);
        }

        public PostException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }

    public static class PostCreationException extends APIRequestException {
        public PostCreationException() {
        }

        public PostCreationException(String s) {
            super(s);
        }

        public PostCreationException(String s, Throwable throwable) {
            super(s, throwable);
        }

        public PostCreationException(Throwable throwable) {
            super(throwable);
        }

        public PostCreationException(String s, Throwable throwable, boolean b, boolean b1) {
            super(s, throwable, b, b1);
        }
    }
}
