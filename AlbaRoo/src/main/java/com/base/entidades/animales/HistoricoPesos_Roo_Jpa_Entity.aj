// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.animales;

import com.base.entidades.animales.HistoricoPesos;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Version;

privileged aspect HistoricoPesos_Roo_Jpa_Entity {
    
    declare @type: HistoricoPesos: @Entity;
    
    @Version
    @Column(name = "version")
    private Integer HistoricoPesos.version;
    
    public Integer HistoricoPesos.getVersion() {
        return this.version;
    }
    
    public void HistoricoPesos.setVersion(Integer version) {
        this.version = version;
    }
    
}
