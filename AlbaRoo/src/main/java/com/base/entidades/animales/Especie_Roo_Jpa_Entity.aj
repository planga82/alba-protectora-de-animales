// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.animales;

import com.base.entidades.animales.Especie;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

privileged aspect Especie_Roo_Jpa_Entity {
    
    declare @type: Especie: @Entity;
    
    @Version
    @Column(name = "version")
    private Integer Especie.version;
    
    public Integer Especie.getVersion() {
        return this.version;
    }
    
    public void Especie.setVersion(Integer version) {
        this.version = version;
    }
    
}
