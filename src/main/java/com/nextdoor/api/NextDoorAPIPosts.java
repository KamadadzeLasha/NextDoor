package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.Post;
import com.nextdoor.share.NextDoorAPICreate;
import com.nextdoor.share.NextDoorAPIRequest;
import com.nextdoor.share.NextDoorAPIRequestNode;
import com.nextdoor.util.NextDoorUtil;

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

        public NextDoorAPIDefaultPost setSecureProfileId(String secureProfileId) {
            this.setParamInternal("secure_profile_id", secureProfileId);

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

        @Override
        public Post create() throws APIRequestException {
            return null;
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }
    }

    public static class NextDoorAPIEventPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        public NextDoorAPIEventPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        @Override
        public Post create() throws APIRequestException {
            return null;
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }
    }

    public static class NextDoorAPIFSFPost extends NextDoorAPIRequest<Post> implements NextDoorAPICreate<Post> {
        public NextDoorAPIFSFPost(NextDoorAPIAuth nextDoorAPIAuth) {
            super(Post.class, nextDoorAPIAuth);
        }

        @Override
        public Post create() throws APIRequestException {
            return null;
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

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
