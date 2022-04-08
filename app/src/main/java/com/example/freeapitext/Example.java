package com.example.freeapitext;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
        "chainId",
        "price",
        "estimatedPriceImpact",
        "value",
        "gasPrice",
        "gas",
        "estimatedGas",
        "protocolFee",
        "minimumProtocolFee",
        "buyTokenAddress",
        "buyAmount",
        "sellTokenAddress",
        "sellAmount",
        "sources",
        "allowanceTarget",
        "sellTokenToEthRate",
        "buyTokenToEthRate"
})
public class Example {

    @JsonProperty("chainId")
    private Integer chainId;
    @JsonProperty("price")
    private String price;
    @JsonProperty("estimatedPriceImpact")
    private String estimatedPriceImpact;
    @JsonProperty("value")
    private String value;
    @JsonProperty("gasPrice")
    private String gasPrice;
    @JsonProperty("gas")
    private String gas;
    @JsonProperty("estimatedGas")
    private String estimatedGas;
    @JsonProperty("protocolFee")
    private String protocolFee;
    @JsonProperty("minimumProtocolFee")
    private String minimumProtocolFee;
    @JsonProperty("buyTokenAddress")
    private String buyTokenAddress;
    @JsonProperty("buyAmount")
    private String buyAmount;
    @JsonProperty("sellTokenAddress")
    private String sellTokenAddress;
    @JsonProperty("sellAmount")
    private String sellAmount;
    @JsonProperty("sources")
    private List<Source> sources = null;
    @JsonProperty("allowanceTarget")
    private String allowanceTarget;
    @JsonProperty("sellTokenToEthRate")
    private String sellTokenToEthRate;
    @JsonProperty("buyTokenToEthRate")
    private String buyTokenToEthRate;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("chainId")
    public Integer getChainId() {
        return chainId;
    }

    @JsonProperty("chainId")
    public void setChainId(Integer chainId) {
        this.chainId = chainId;
    }

    @JsonProperty("price")
    public String getPrice() {
        return price;
    }

    @JsonProperty("price")
    public void setPrice(String price) {
        this.price = price;
    }

    @JsonProperty("estimatedPriceImpact")
    public String getEstimatedPriceImpact() {
        return estimatedPriceImpact;
    }

    @JsonProperty("estimatedPriceImpact")
    public void setEstimatedPriceImpact(String estimatedPriceImpact) {
        this.estimatedPriceImpact = estimatedPriceImpact;
    }

    @JsonProperty("value")
    public String getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(String value) {
        this.value = value;
    }

    @JsonProperty("gasPrice")
    public String getGasPrice() {
        return gasPrice;
    }

    @JsonProperty("gasPrice")
    public void setGasPrice(String gasPrice) {
        this.gasPrice = gasPrice;
    }

    @JsonProperty("gas")
    public String getGas() {
        return gas;
    }

    @JsonProperty("gas")
    public void setGas(String gas) {
        this.gas = gas;
    }

    @JsonProperty("estimatedGas")
    public String getEstimatedGas() {
        return estimatedGas;
    }

    @JsonProperty("estimatedGas")
    public void setEstimatedGas(String estimatedGas) {
        this.estimatedGas = estimatedGas;
    }

    @JsonProperty("protocolFee")
    public String getProtocolFee() {
        return protocolFee;
    }

    @JsonProperty("protocolFee")
    public void setProtocolFee(String protocolFee) {
        this.protocolFee = protocolFee;
    }

    @JsonProperty("minimumProtocolFee")
    public String getMinimumProtocolFee() {
        return minimumProtocolFee;
    }

    @JsonProperty("minimumProtocolFee")
    public void setMinimumProtocolFee(String minimumProtocolFee) {
        this.minimumProtocolFee = minimumProtocolFee;
    }

    @JsonProperty("buyTokenAddress")
    public String getBuyTokenAddress() {
        return buyTokenAddress;
    }

    @JsonProperty("buyTokenAddress")
    public void setBuyTokenAddress(String buyTokenAddress) {
        this.buyTokenAddress = buyTokenAddress;
    }

    @JsonProperty("buyAmount")
    public String getBuyAmount() {
        return buyAmount;
    }

    @JsonProperty("buyAmount")
    public void setBuyAmount(String buyAmount) {
        this.buyAmount = buyAmount;
    }

    @JsonProperty("sellTokenAddress")
    public String getSellTokenAddress() {
        return sellTokenAddress;
    }

    @JsonProperty("sellTokenAddress")
    public void setSellTokenAddress(String sellTokenAddress) {
        this.sellTokenAddress = sellTokenAddress;
    }

    @JsonProperty("sellAmount")
    public String getSellAmount() {
        return sellAmount;
    }

    @JsonProperty("sellAmount")
    public void setSellAmount(String sellAmount) {
        this.sellAmount = sellAmount;
    }

    @JsonProperty("sources")
    public List<Source> getSources() {
        return sources;
    }

    @JsonProperty("sources")
    public void setSources(List<Source> sources) {
        this.sources = sources;
    }

    @JsonProperty("allowanceTarget")
    public String getAllowanceTarget() {
        return allowanceTarget;
    }

    @JsonProperty("allowanceTarget")
    public void setAllowanceTarget(String allowanceTarget) {
        this.allowanceTarget = allowanceTarget;
    }

    @JsonProperty("sellTokenToEthRate")
    public String getSellTokenToEthRate() {
        return sellTokenToEthRate;
    }

    @JsonProperty("sellTokenToEthRate")
    public void setSellTokenToEthRate(String sellTokenToEthRate) {
        this.sellTokenToEthRate = sellTokenToEthRate;
    }

    @JsonProperty("buyTokenToEthRate")
    public String getBuyTokenToEthRate() {
        return buyTokenToEthRate;
    }

    @JsonProperty("buyTokenToEthRate")
    public void setBuyTokenToEthRate(String buyTokenToEthRate) {
        this.buyTokenToEthRate = buyTokenToEthRate;
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