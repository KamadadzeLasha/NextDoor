package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CityTargeting extends NextDoorModel implements Serializable {
    @JsonProperty("city_targeting")
    private List<CityTarget> cityTargeting;

    @JsonProperty("page_info")
    private Pagination pagination;

    public CityTargeting() {

    }

    public CityTargeting(List<CityTarget> cityTargeting, Pagination pagination) {
        this.cityTargeting = cityTargeting;
        this.pagination = pagination;
    }

    public List<CityTarget> getCityTargeting() {
        return cityTargeting;
    }

    public void setCityTargeting(List<CityTarget> cityTargeting) {
        this.cityTargeting = cityTargeting;
    }

    public Pagination getPageInfo() {
        return pagination;
    }

    public void setPageInfo(Pagination pagination) {
        this.pagination = pagination;
    }

    @Override
    public String toString() {
        return "CityTargeting{" +
                "cityTargeting=" + cityTargeting +
                ", pagination=" + pagination +
                '}';
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class CityTarget implements Serializable {
        @JsonProperty("cursor")
        private String cursor;

        @JsonProperty("data")
        private CityData data;

        public CityTarget() {

        }

        public CityTarget(String cursor, CityData data) {
            this.cursor = cursor;
            this.data = data;
        }

        public String getCursor() {
            return cursor;
        }

        public void setCursor(String cursor) {
            this.cursor = cursor;
        }

        public CityData getData() {
            return data;
        }

        public void setData(CityData data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return "CityTarget{" +
                    "cursor='" + cursor + '\'' +
                    ", data=" + data +
                    '}';
        }

        @JsonIgnoreProperties(ignoreUnknown = true)
        public static class CityData implements Serializable {
            @JsonProperty("id")
            private String id;

            @JsonProperty("name")
            private String name;

            public CityData() {

            }

            public CityData(String id, String name) {
                this.id = id;
                this.name = name;
            }

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            @Override
            public String toString() {
                return "CityData{" +
                        "id='" + id + '\'' +
                        ", name='" + name + '\'' +
                        '}';
            }
        }
    }

    @JsonIgnoreProperties(ignoreUnknown = true)
    public static class Pagination implements Serializable {
        @JsonProperty("end_cursor")
        private String endCursor;

        @JsonProperty("page_size")
        private int pageSize;

        public Pagination() {

        }

        public Pagination(String endCursor, int pageSize) {
            this.endCursor = endCursor;
            this.pageSize = pageSize;
        }

        public String getEndCursor() {
            return endCursor;
        }

        public void setEndCursor(String endCursor) {
            this.endCursor = endCursor;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        @Override
        public String toString() {
            return "Pagination{" +
                    "endCursor='" + endCursor + '\'' +
                    ", pageSize=" + pageSize +
                    '}';
        }
    }
}