package com.example.freeapitext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "tokenAddressPath",
        "router"
})
public class FillData {

    @JsonProperty("tokenAddressPath")
    private List<String> tokenAddressPath = null;
    @JsonProperty("router")
    private String router;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("tokenAddressPath")
    public List<String> getTokenAddressPath() {
        return tokenAddressPath;
    }

    @JsonProperty("tokenAddressPath")
    public void setTokenAddressPath(List<String> tokenAddressPath) {
        this.tokenAddressPath = tokenAddressPath;
    }

    @JsonProperty("router")
    public String getRouter() {
        return router;
    }

    @JsonProperty("router")
    public void setRouter(String router) {
        this.router = router;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}