package com.eureka.player;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlayerDAO {

    @Id @GeneratedValue
    private Integer id;

    private String name;

    private Integer playerPoints;

    private String titleInTribe;

}
