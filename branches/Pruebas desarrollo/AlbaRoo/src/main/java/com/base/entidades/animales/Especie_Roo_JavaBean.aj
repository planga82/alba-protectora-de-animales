// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.animales;

import com.base.entidades.animales.Animal;
import com.base.entidades.animales.Especie;
import java.util.Set;

privileged aspect Especie_Roo_JavaBean {
    
    public String Especie.getNombre() {
        return this.nombre;
    }
    
    public void Especie.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public Set<Animal> Especie.getAnimales() {
        return this.animales;
    }
    
    public void Especie.setAnimales(Set<Animal> animales) {
        this.animales = animales;
    }
    
}