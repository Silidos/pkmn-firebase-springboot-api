package com.firebase.pkmn.demo.entity;

import lombok.Data;

@Data
public class Pokemon {

    private String ability;
    private String abilityDescription;
    private int attack;
    private int defense;
    private String description;
    private int hp;
    private String name;
    private int specialAttack;
    private int specialDefense;
    private int speed;
    private String type;
    private String weaknesses;

}
