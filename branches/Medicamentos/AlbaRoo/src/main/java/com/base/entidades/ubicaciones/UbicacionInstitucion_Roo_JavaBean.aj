// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.ubicaciones;

import com.base.entidades.instituciones.Institucion;
import com.base.entidades.ubicaciones.UbicacionInstitucion;

privileged aspect UbicacionInstitucion_Roo_JavaBean {
    
    public Institucion UbicacionInstitucion.getInstitucion() {
        return this.institucion;
    }
    
    public void UbicacionInstitucion.setInstitucion(Institucion institucion) {
        this.institucion = institucion;
    }
    
}