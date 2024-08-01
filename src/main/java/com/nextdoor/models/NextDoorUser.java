package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.nextdoor.api.response.NextDoorAPIRequestNode;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

public class NextDoorUser extends NextDoorAPIRequestNode implements Serializable {
    @JsonProperty("user")
    private User currentUser;

    @JsonProperty("profile")
    private Profile currentProfile;

    public NextDoorUser() {

    }

    public NextDoorUser(User currentUser, Profile currentProfile) {
        this.currentUser = currentUser;
        this.currentProfile = currentProfile;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public Profile getCurrentProfile() {
        return currentProfile;
    }

    public void setCurrentProfile(Profile currentProfile) {
        this.currentProfile = currentProfile;
    }

    public static class Profile implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String profileName;

        @JsonProperty("associated_user_ids")
        private List<String> associatedUserIds;

        @JsonProperty("payment_profile_id")
        private String paymentProfileId;

        @JsonProperty("is_ad_agency")
        private boolean isAdAgency;

        public Profile() {

        }

        public Profile(String id, String profileName, List<String> associatedUserIds, String paymentProfileId, boolean isAdAgency) {
            this.id = id;
            this.profileName = profileName;
            this.associatedUserIds = associatedUserIds;
            this.paymentProfileId = paymentProfileId;
            this.isAdAgency = isAdAgency;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getProfileName() {
            return profileName;
        }

        public void setProfileName(String profileName) {
            this.profileName = profileName;
        }

        public List<String> getAssociatedUserIds() {
            return associatedUserIds;
        }

        public void setAssociatedUserIds(List<String> associatedUserIds) {
            this.associatedUserIds = associatedUserIds;
        }

        public String getPaymentProfileId() {
            return paymentProfileId;
        }

        public void setPaymentProfileId(String paymentProfileId) {
            this.paymentProfileId = paymentProfileId;
        }

        public boolean isAdAgency() {
            return isAdAgency;
        }

        public void setAdAgency(boolean adAgency) {
            isAdAgency = adAgency;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            Profile profile = (Profile) object;
            return Objects.equals(id, profile.id) && Objects.equals(profileName, profile.profileName) && Objects.equals(associatedUserIds, profile.associatedUserIds) && Objects.equals(paymentProfileId, profile.paymentProfileId) && Objects.equals(isAdAgency, profile.isAdAgency);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, profileName, associatedUserIds, paymentProfileId, isAdAgency);
        }

        @Override
        public String toString() {
            return "Profile{" +
                    "id='" + id + '\'' +
                    ", profileName='" + profileName + '\'' +
                    ", associatedUserIds=" + associatedUserIds +
                    ", paymentProfileId='" + paymentProfileId + '\'' +
                    ", isAdAgency='" + isAdAgency + '\'' +
                    '}';
        }
    }

    public static class User implements Serializable {
        @JsonProperty("id")
        private String id;

        @JsonProperty("name")
        private String userName;

        @JsonProperty("email")
        private String email;

        @JsonProperty("email_confirmed")
        private boolean emailConfirmed;

        @JsonProperty("advertisers_with_access")
        private List<AdvertisersWithAccess> advertisersWithAccess;

        public User() {

        }

        public User(String id, String userName, String email, boolean emailConfirmed, List<AdvertisersWithAccess> advertisersWithAccess) {
            this.id = id;
            this.userName = userName;
            this.email = email;
            this.emailConfirmed = emailConfirmed;
            this.advertisersWithAccess = advertisersWithAccess;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public boolean isEmailConfirmed() {
            return emailConfirmed;
        }

        public void setEmailConfirmed(boolean emailConfirmed) {
            this.emailConfirmed = emailConfirmed;
        }

        public List<AdvertisersWithAccess> getAdvertisersWithAccess() {
            return advertisersWithAccess;
        }

        public void setAdvertisersWithAccess(List<AdvertisersWithAccess> advertisersWithAccess) {
            this.advertisersWithAccess = advertisersWithAccess;
        }

        @Override
        public boolean equals(Object object) {
            if (this == object) return true;
            if (object == null || getClass() != object.getClass()) return false;
            User user = (User) object;
            return emailConfirmed == user.emailConfirmed && Objects.equals(id, user.id) && Objects.equals(userName, user.userName) && Objects.equals(email, user.email) && Objects.equals(advertisersWithAccess, user.advertisersWithAccess);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, userName, email, emailConfirmed, advertisersWithAccess);
        }

        @Override
        public String toString() {
            return "User{" +
                    "id='" + id + '\'' +
                    ", userName='" + userName + '\'' +
                    ", email='" + email + '\'' +
                    ", emailConfirmed=" + emailConfirmed +
                    ", advertisersWithAccess=" + advertisersWithAccess +
                    '}';
        }

        public static class AdvertisersWithAccess implements Serializable {
            @JsonProperty("advertiser_id")
            private String advertiserId;

            @JsonProperty("role")
            private String role;

            public AdvertisersWithAccess() {

            }

            public AdvertisersWithAccess(String advertiserId, String role) {
                this.advertiserId = advertiserId;
                this.role = role;
            }

            public String getAdvertiserId() {
                return advertiserId;
            }

            public void setAdvertiserId(String advertiserId) {
                this.advertiserId = advertiserId;
            }

            public String getRole() {
                return role;
            }

            public void setRole(String role) {
                this.role = role;
            }

            @Override
            public boolean equals(Object object) {
                if (this == object) return true;
                if (object == null || getClass() != object.getClass()) return false;
                AdvertisersWithAccess that = (AdvertisersWithAccess) object;
                return Objects.equals(advertiserId, that.advertiserId) && Objects.equals(role, that.role);
            }

            @Override
            public int hashCode() {
                return Objects.hash(advertiserId, role);
            }

            @Override
            public String toString() {
                return "AdvertisersWithAccess{" +
                        "advertiserId='" + advertiserId + '\'' +
                        ", role='" + role + '\'' +
                        '}';
            }
        }
    }
}
