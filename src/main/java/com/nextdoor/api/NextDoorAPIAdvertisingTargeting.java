package com.nextdoor.api;

import com.mashape.unirest.http.HttpMethod;
import com.nextdoor.auth.NextDoorAPIAuth;
import com.nextdoor.constants.DefaultURLS;
import com.nextdoor.exception.APIRequestException;
import com.nextdoor.models.*;
import com.nextdoor.share.core.NextDoorAPIRequest;
import com.nextdoor.share.core.NextDoorAPIRequestNode;
import com.nextdoor.share.interfaces.NextDoorAPIExecute;

public class NextDoorAPIAdvertisingTargeting extends NextDoorAPIRequestNode {
    public static final String TARGETING_PREFIX = "targeting/";

    public NextDoorAPIAdvertisingTargeting() {
        super(NextDoorAPIAuth.defaultNextDoorAPIAuth());
    }

    public NextDoorAPIAdvertisingTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
        super(nextDoorAPIAuth);
    }

    public static class NextDoorAPIGeoStateList extends NextDoorAPIRequest<StateTargeting> implements NextDoorAPIExecute<StateTargeting> {
        public NextDoorAPIGeoStateList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(StateTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/state/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public StateTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new StateTargetingNotFoundException("Cannot search targeting with state because of: " + e.getLocalizedMessage());
            }
        }

        public static class StateTargetingNotFoundException extends APIRequestException {
            public StateTargetingNotFoundException() {
            }

            public StateTargetingNotFoundException(String s) {
                super(s);
            }

            public StateTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public StateTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public StateTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIGeoCityList extends NextDoorAPIRequest<CityTargeting> implements NextDoorAPIExecute<CityTargeting> {
        public NextDoorAPIGeoCityList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(CityTargeting.class, nextDoorAPIAuth);
        }

        @Override
        protected String getPath() {
            return "";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public CityTargeting execute() throws APIRequestException {
            return null;
        }
    }

    public static class NextDoorAPIGeoDMAList extends NextDoorAPIRequest<DMATargeting> implements NextDoorAPIExecute<DMATargeting> {
        public NextDoorAPIGeoDMAList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(DMATargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "geo/dma/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public DMATargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new DMATargetingNotFoundException("Cannot search targeting with DMA because of: " + e.getLocalizedMessage());
            }
        }

        public static class DMATargetingNotFoundException extends APIRequestException {
            public DMATargetingNotFoundException() {
            }

            public DMATargetingNotFoundException(String s) {
                super(s);
            }

            public DMATargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public DMATargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public DMATargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemographicsGenderTargeting extends NextDoorAPIRequest<GenderTargeting> implements NextDoorAPIExecute<GenderTargeting> {
        public NextDoorAPIDemographicsGenderTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(GenderTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/gender/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public GenderTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new GenderTargetingNotFoundException("Cannot search targeting with gender because of: " + e.getLocalizedMessage());
            }
        }

        public static class GenderTargetingNotFoundException extends APIRequestException {
            public GenderTargetingNotFoundException() {
            }

            public GenderTargetingNotFoundException(String s) {
                super(s);
            }

            public GenderTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public GenderTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public GenderTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemographicsAgeTargeting extends NextDoorAPIRequest<AgeTargeting> implements NextDoorAPIExecute<AgeTargeting> {
        public NextDoorAPIDemographicsAgeTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(AgeTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/age/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public AgeTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new AgeTargetingNotFoundException("Cannot search targeting with gender because of: " + e.getLocalizedMessage());
            }
        }

        public static class AgeTargetingNotFoundException extends APIRequestException {
            public AgeTargetingNotFoundException() {
            }

            public AgeTargetingNotFoundException(String s) {
                super(s);
            }

            public AgeTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public AgeTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public AgeTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemoraphicsHomeownershipTargeting extends NextDoorAPIRequest<HomeownershipTargeting> implements NextDoorAPIExecute<HomeownershipTargeting> {
        public NextDoorAPIDemoraphicsHomeownershipTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(HomeownershipTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/homeownership/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public HomeownershipTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new HomeownershipTargetingNotFoundException("Cannot search targeting with home ownership because of: " + e.getLocalizedMessage());
            }
        }

        public static class HomeownershipTargetingNotFoundException extends APIRequestException {
            public HomeownershipTargetingNotFoundException() {
            }

            public HomeownershipTargetingNotFoundException(String s) {
                super(s);
            }

            public HomeownershipTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public HomeownershipTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public HomeownershipTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDemographicIncomeTargeting extends NextDoorAPIRequest<IncomeTargeting> implements NextDoorAPIExecute<IncomeTargeting> {
        public NextDoorAPIDemographicIncomeTargeting(NextDoorAPIAuth nextDoorAPIAuth) {
            super(IncomeTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "demographics/income/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public IncomeTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new IcnomeTargetingNotFoundException("Cannot search targeting with income because of: " + e.getLocalizedMessage());
            }
        }

        public static class IcnomeTargetingNotFoundException extends APIRequestException {
            public IcnomeTargetingNotFoundException() {
            }

            public IcnomeTargetingNotFoundException(String s) {
                super(s);
            }

            public IcnomeTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public IcnomeTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public IcnomeTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIInterestTargetingList extends NextDoorAPIRequest<InterestTargeting> implements NextDoorAPIExecute<InterestTargeting> {
        public NextDoorAPIInterestTargetingList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(InterestTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "targeting/interest/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public InterestTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new InterestTargetingNotFoundException("Cannot search targeting with interest because of: " + e.getLocalizedMessage());
            }
        }

        public static class InterestTargetingNotFoundException extends APIRequestException {
            public InterestTargetingNotFoundException() {
            }

            public InterestTargetingNotFoundException(String s) {
                super(s);
            }

            public InterestTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public InterestTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public InterestTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }

    public static class NextDoorAPIDeviceList extends NextDoorAPIRequest<DeviceTargeting> implements NextDoorAPIExecute<DeviceTargeting> {
        public NextDoorAPIDeviceList(NextDoorAPIAuth nextDoorAPIAuth) {
            super(DeviceTargeting.class, nextDoorAPIAuth);

            this.addHeader(this.getNextDoorAPIAuth().getTokenHeader());
        }

        @Override
        protected String getPath() {
            return DefaultURLS.DEFAULT_FULL_ADS_API_URL + TARGETING_PREFIX + "device/list";
        }

        @Override
        protected void validateRequiredParams() {

        }

        @Override
        public DeviceTargeting execute() throws APIRequestException {
            try {
                return sendHttpRequest(HttpMethod.GET);
            } catch (APIRequestException e) {
                throw new DeviceTargetingNotFoundException("Cannot search Device targeting, because of: " + e.getLocalizedMessage());
            }
        }

        public static class DeviceTargetingNotFoundException extends APIRequestException {
            public DeviceTargetingNotFoundException() {
            }

            public DeviceTargetingNotFoundException(String s) {
                super(s);
            }

            public DeviceTargetingNotFoundException(String s, Throwable throwable) {
                super(s, throwable);
            }

            public DeviceTargetingNotFoundException(Throwable throwable) {
                super(throwable);
            }

            public DeviceTargetingNotFoundException(String s, Throwable throwable, boolean b, boolean b1) {
                super(s, throwable, b, b1);
            }
        }
    }
}
