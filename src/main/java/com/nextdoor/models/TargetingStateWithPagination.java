package com.nextdoor.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TargetingStateWithPagination extends NextDoorModel implements Serializable {

}
