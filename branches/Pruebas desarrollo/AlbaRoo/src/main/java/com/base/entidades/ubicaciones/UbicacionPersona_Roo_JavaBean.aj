// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.ubicaciones;

import com.base.entidades.personas.Persona;
import com.base.entidades.ubicaciones.UbicacionPersona;

privileged aspect UbicacionPersona_Roo_JavaBean {
    
    public Persona UbicacionPersona.getPersona() {
        return this.persona;
    }
    
    public void UbicacionPersona.setPersona(Persona persona) {
        this.persona = persona;
    }
    
}