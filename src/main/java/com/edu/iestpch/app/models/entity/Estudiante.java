package com.edu.iestpch.app.models.entity;

import java.io.Serializable;

import javax.persistence.*;


@Entity
@Table(name="estudiantes")
public class Estudiante implements Serializable{
	 	
		private static final long serialVersionUID = 1L;
		
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		private long id;
		
		private String codigo;
		private String dni;
		private String nombres;
		private String apellidos;
		private String especialidad;
		private String sexo;
		private Integer edad;
		
		@ManyToOne(fetch=FetchType.LAZY)
		private Carrera carrera;
		
		public long getId() {
			return id;
		}
		public void setId(long id) {
			this.id = id;
		}
		public String getCodigo() {
			return codigo;
		}
		public void setCodigo(String codigo) {
			this.codigo = codigo;
		}
		
		public String getDni() {
			return dni;
		}
		public void setDni(String dni) {
			this.dni = dni;
		}
		public String getNombres() {
			return nombres;
		}
		public void setNombres(String nombres) {
			this.nombres = nombres;
		}
		public String getApellidos() {
			return apellidos;
		}
		public void setApellidos(String apellidos) {
			this.apellidos = apellidos;
		}
		public String getEspecialidad() {
			return especialidad;
		}
		public void setEspecialidad(String especialidad) {
			this.especialidad = especialidad;
		}
		public String getSexo() {
			return sexo;
		}
		public void setSexo(String sexo) {
			this.sexo = sexo;
		}		
		public Integer getEdad() {
			return edad;
		}
		public void setEdad(Integer edad) {
			this.edad = edad;
		}
		public Carrera getCarrera() {
			return carrera;
		}
		public void setCarrera(Carrera carrera) {
			this.carrera = carrera;
		}
		
		

}
