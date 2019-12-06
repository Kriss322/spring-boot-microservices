package com.eureka.common.village;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResourceProduction implements Serializable {
    private Integer clayProdPerHour;
    private Integer woodProdPerHour;
    private Integer ironProdPerHour;

    public void addClay(Integer clayValue){
        this.clayProdPerHour += clayValue;
    }

    public void addWood(Integer woodValue){
        this.woodProdPerHour += woodValue;
    }

    public void addIron(Integer ironValue){
        this.ironProdPerHour += ironValue;
    }
}