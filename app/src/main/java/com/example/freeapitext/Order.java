package com.example.freeapitext;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "makerToken",
        "takerToken",
        "makerAmount",
        "takerAmount",
        "fillData",
        "source",
        "sourcePathId",
        "type"
})
public class Order {

    @JsonProperty("makerToken")
    private String makerToken;
    @JsonProperty("takerToken")
    private String takerToken;
    @JsonProperty("makerAmount")
    private String makerAmount;
    @JsonProperty("takerAmount")
    private String takerAmount;
    @JsonProperty("fillData")
    private FillData fillData;
    @JsonProperty("source")
    private String source;
    @JsonProperty("sourcePathId")
    private String sourcePathId;
    @JsonProperty("type")
    private Integer type;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("makerToken")
    public String getMakerToken() {
        return makerToken;
    }

    @JsonProperty("makerToken")
    public void setMakerToken(String makerToken) {
        this.makerToken = makerToken;
    }

    @JsonProperty("takerToken")
    public String getTakerToken() {
        return takerToken;
    }

    @JsonProperty("takerToken")
    public void setTakerToken(String takerToken) {
        this.takerToken = takerToken;
    }

    @JsonProperty("makerAmount")
    public String getMakerAmount() {
        return makerAmount;
    }

    @JsonProperty("makerAmount")
    public void setMakerAmount(String makerAmount) {
        this.makerAmount = makerAmount;
    }

    @JsonProperty("takerAmount")
    public String getTakerAmount() {
        return takerAmount;
    }

    @JsonProperty("takerAmount")
    public void setTakerAmount(String takerAmount) {
        this.takerAmount = takerAmount;
    }

    @JsonProperty("fillData")
    public FillData getFillData() {
        return fillData;
    }

    @JsonProperty("fillData")
    public void setFillData(FillData fillData) {
        this.fillData = fillData;
    }

    @JsonProperty("source")
    public String getSource() {
        return source;
    }

    @JsonProperty("source")
    public void setSource(String source) {
        this.source = source;
    }

    @JsonProperty("sourcePathId")
    public String getSourcePathId() {
        return sourcePathId;
    }

    @JsonProperty("sourcePathId")
    public void setSourcePathId(String sourcePathId) {
        this.sourcePathId = sourcePathId;
    }

    @JsonProperty("type")
    public Integer getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(Integer type) {
        this.type = type;
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