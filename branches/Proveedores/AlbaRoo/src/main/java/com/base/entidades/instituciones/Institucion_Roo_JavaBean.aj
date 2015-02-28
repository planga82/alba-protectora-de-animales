// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package com.base.entidades.instituciones;

import com.base.entidades.animales.Animal;
import com.base.entidades.instituciones.Institucion;
import com.base.entidades.instituciones.TipoInstitucion;
import com.base.entidades.ubicaciones.UbicacionInstitucion;
import java.sql.Date;
import java.util.Set;

privileged aspect Institucion_Roo_JavaBean {
    
    public String Institucion.getNombre() {
        return this.nombre;
    }
    
    public void Institucion.setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String Institucion.getNIF() {
        return this.NIF;
    }
    
    public void Institucion.setNIF(String NIF) {
        this.NIF = NIF;
    }
    
    public String Institucion.getDireccion() {
        return this.direccion;
    }
    
    public void Institucion.setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String Institucion.getPersonaContacto() {
        return this.personaContacto;
    }
    
    public void Institucion.setPersonaContacto(String personaContacto) {
        this.personaContacto = personaContacto;
    }
    
    public String Institucion.getTelefonoContacto() {
        return this.telefonoContacto;
    }
    
    public void Institucion.setTelefonoContacto(String telefonoContacto) {
        this.telefonoContacto = telefonoContacto;
    }
    
    public String Institucion.getEmailContacto() {
        return this.emailContacto;
    }
    
    public void Institucion.setEmailContacto(String emailContacto) {
        this.emailContacto = emailContacto;
    }
    
    public String Institucion.getEstado() {
        return this.estado;
    }
    
    public void Institucion.setEstado(String estado) {
        this.estado = estado;
    }
    
    public String Institucion.getMotivoBaja() {
        return this.motivoBaja;
    }
    
    public void Institucion.setMotivoBaja(String motivoBaja) {
        this.motivoBaja = motivoBaja;
    }
    
    public Date Institucion.getFechaBaja() {
        return this.fechaBaja;
    }
    
    public void Institucion.setFechaBaja(Date fechaBaja) {
        this.fechaBaja = fechaBaja;
    }
    
    public Set<UbicacionInstitucion> Institucion.getUbicaciones() {
        return this.ubicaciones;
    }
    
    public void Institucion.setUbicaciones(Set<UbicacionInstitucion> ubicaciones) {
        this.ubicaciones = ubicaciones;
    }
    
    public Set<Animal> Institucion.getAnimalesPatrocinados() {
        return this.animalesPatrocinados;
    }
    
    public void Institucion.setAnimalesPatrocinados(Set<Animal> animalesPatrocinados) {
        this.animalesPatrocinados = animalesPatrocinados;
    }
    
    public String Institucion.getPaginaWeb() {
        return this.paginaWeb;
    }
    
    public void Institucion.setPaginaWeb(String paginaWeb) {
        this.paginaWeb = paginaWeb;
    }
    
    public String Institucion.getCuentaCargo() {
        return this.cuentaCargo;
    }
    
    public void Institucion.setCuentaCargo(String cuentaCargo) {
        this.cuentaCargo = cuentaCargo;
    }
    
    public String Institucion.getNombreDepartamento1() {
        return this.nombreDepartamento1;
    }
    
    public void Institucion.setNombreDepartamento1(String nombreDepartamento1) {
        this.nombreDepartamento1 = nombreDepartamento1;
    }
    
    public String Institucion.getPersonaContactoDepartamento1() {
        return this.personaContactoDepartamento1;
    }
    
    public void Institucion.setPersonaContactoDepartamento1(String personaContactoDepartamento1) {
        this.personaContactoDepartamento1 = personaContactoDepartamento1;
    }
    
    public String Institucion.getEmailDepartamento1() {
        return this.emailDepartamento1;
    }
    
    public void Institucion.setEmailDepartamento1(String emailDepartamento1) {
        this.emailDepartamento1 = emailDepartamento1;
    }
    
    public String Institucion.getTelefonoDepartamento1() {
        return this.telefonoDepartamento1;
    }
    
    public void Institucion.setTelefonoDepartamento1(String telefonoDepartamento1) {
        this.telefonoDepartamento1 = telefonoDepartamento1;
    }
    
    public String Institucion.getNombreDepartamento2() {
        return this.nombreDepartamento2;
    }
    
    public void Institucion.setNombreDepartamento2(String nombreDepartamento2) {
        this.nombreDepartamento2 = nombreDepartamento2;
    }
    
    public String Institucion.getPersonaContactoDepartamento2() {
        return this.personaContactoDepartamento2;
    }
    
    public void Institucion.setPersonaContactoDepartamento2(String personaContactoDepartamento2) {
        this.personaContactoDepartamento2 = personaContactoDepartamento2;
    }
    
    public String Institucion.getEmailDepartamento2() {
        return this.emailDepartamento2;
    }
    
    public void Institucion.setEmailDepartamento2(String emailDepartamento2) {
        this.emailDepartamento2 = emailDepartamento2;
    }
    
    public String Institucion.getTelefonoDepartamento2() {
        return this.telefonoDepartamento2;
    }
    
    public void Institucion.setTelefonoDepartamento2(String telefonoDepartamento2) {
        this.telefonoDepartamento2 = telefonoDepartamento2;
    }
    
    public String Institucion.getNombreDepartamento3() {
        return this.nombreDepartamento3;
    }
    
    public void Institucion.setNombreDepartamento3(String nombreDepartamento3) {
        this.nombreDepartamento3 = nombreDepartamento3;
    }
    
    public String Institucion.getPersonaContactoDepartamento3() {
        return this.personaContactoDepartamento3;
    }
    
    public void Institucion.setPersonaContactoDepartamento3(String personaContactoDepartamento3) {
        this.personaContactoDepartamento3 = personaContactoDepartamento3;
    }
    
    public String Institucion.getEmailDepartamento3() {
        return this.emailDepartamento3;
    }
    
    public void Institucion.setEmailDepartamento3(String emailDepartamento3) {
        this.emailDepartamento3 = emailDepartamento3;
    }
    
    public String Institucion.getTelefonoDepartamento3() {
        return this.telefonoDepartamento3;
    }
    
    public void Institucion.setTelefonoDepartamento3(String telefonoDepartamento3) {
        this.telefonoDepartamento3 = telefonoDepartamento3;
    }
    
    public TipoInstitucion Institucion.getTipo() {
        return this.tipo;
    }
    
    public void Institucion.setTipo(TipoInstitucion tipo) {
        this.tipo = tipo;
    }
    
}
