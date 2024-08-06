package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.CommentToPostOrReplyToComment;
import com.nextdoor.models.Event;
import com.nextdoor.models.FSF;
import com.nextdoor.models.Post;
import com.nextdoor.share.NextDoorAPICreate;
import com.nextdoor.share.NextDoorAPIRequest;
import com.nextdoor.share.NextDoorAPIRequestNode;
import com.nextdoor.util.NextDoorUtil;

import java.io.UnsupportedEncodingException;
import java.util.Collection;
import java.util.Collections;

import static com.nextdoor.constants.DefaultURLS.DEFAULT_FULL_EXTERNAL_API_URL;

public class NextDoorAPIPosts extends NextDoorAPIRequestNode {
    public NextDoorAPIPosts() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIPosts(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public NextDoorAPIDefaultPost createDefaultPost() {
        return new NextDoorAPIDefaultPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIAgencyPost createAgencyPost() {
        return new NextDoorAPIAgencyPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIEventPost createEventPost() {
        return new NextDoorAPIEventPost(this.getNextDoorAPIAuth());
    }

    public NextDoorAPIFSFPost createFSFPost() {
        return new NextDoorAPIFSFPost(this.getNextDoorAPIAuth());
    }

    public static class NextDoorAPIDefaultPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        public NextDoorAPIDefaultPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPIDefaultPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIDefaultPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPIDefaultPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to post");
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPIDefaultPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to post");

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPIDefaultPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPIDefaultPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPIDefaultPost setSmartLinkUrl(String smartLinkUrl) {
            this.setParamInternal("smartlink_url", smartLinkUrl);

            return this;
        }

        public NextDoorAPIDefaultPost setSecureProfileID(String secureProfileID) {
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
                throw new PostCreationException("Cannot create default post because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "post/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }
    }

    public static class NextDoorAPIAgencyPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        public NextDoorAPIAgencyPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPIAgencyPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIAgencyPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPIAgencyPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to post");
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPIAgencyPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to post");

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPIAgencyPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPIAgencyPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPIAgencyPost setRadius(String radius) {
            this.setParamInternal("radius", radius);

            return this;
        }

        public NextDoorAPIAgencyPost setGroupIDs(Collection<Integer> groupIDs) {
            if (groupIDs == null) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to post");

                return this;
            }

            this.setParamInternal("group_ids", groupIDs);

            return this;
        }

        public NextDoorAPIAgencyPost setSmartLinkUrl(String smartLinkUrl) {
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
                throw new PostCreationException("Cannot agency default post because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "post/create";
        }

        @Override
        protected void validateRequiredParams() {
            NextDoorUtil.ensureStringNotNull(this.getParamInternal("body_text"), "body_text");
        }
    }

    public static class NextDoorAPIEventPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        private static final String EVENT_NAME = "event";

        public NextDoorAPIEventPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPIEventPost setEvent(Event event) {
            this.setParamInternal(EVENT_NAME, event);

            return this;
        }

        public NextDoorAPIEventPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIEventPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPIEventPost setMediaAttachments(String mediaAttachment) {
            if (mediaAttachment == null || mediaAttachment.isEmpty()) {
                this.getNextDoorAPIAuth().log("Cannot attach attachment to post");
                return this;
            }

            return setMediaAttachments(Collections.singleton(mediaAttachment));
        }

        public NextDoorAPIEventPost setMediaAttachments(Collection<String> mediaAttachments) {
            if (mediaAttachments == null || mediaAttachments.size() > 10) {
                this.getNextDoorAPIAuth().log("Cannot attach attachments to post");

                return this;
            }

            this.setParamInternal("media_attachments", mediaAttachments);
            return this;
        }

        public NextDoorAPIEventPost setLatitude(float latitude) {
            this.setParamInternal("lat", latitude);

            return this;
        }

        public NextDoorAPIEventPost setLongitude(float longitude) {
            this.setParamInternal("lon", longitude);

            return this;
        }

        public NextDoorAPIEventPost setRadius(String radius) {
            this.setParamInternal("radius", radius);

            return this;
        }

        public NextDoorAPIEventPost setSmartLinkUrl(String smartLinkUrl) {
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
                throw new PostCreationException("Cannot agency default post because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "post/" + EVENT_NAME + "/";
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

    public static class NextDoorAPIFSFPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        private static final String FSF_NAME = "fsf";

        public NextDoorAPIFSFPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        public NextDoorAPIFSFPost setFSF(FSF fsf) {
            this.setParamInternal(FSF_NAME, fsf);

            return this;
        }

        public NextDoorAPIFSFPost setBodyText(String bodyText) {
            this.setParamInternal("body_text", bodyText);

            return this;
        }

        public NextDoorAPIFSFPost setHashtag(String hashtag) {
            this.setParamInternal("hashtag", hashtag.trim());

            return this;
        }

        public NextDoorAPIFSFPost setSmartLinkUrl(String smartLinkUrl) {
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
                throw new PostCreationException("Cannot agency default post because of: " + e.getLocalizedMessage());
            }
        }

        @Override
        protected String getPath() {
            return DEFAULT_FULL_EXTERNAL_API_URL + "post/" + FSF_NAME + "/";
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
                throw new RuntimeException("Cannot attach attachments to post, because there are more than 10 images");
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
                throw new CommentToAPostOrReplyToACommentExcepton("Cannot reply to a comment or create comment to post, because of: " + e.getLocalizedMessage());
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
