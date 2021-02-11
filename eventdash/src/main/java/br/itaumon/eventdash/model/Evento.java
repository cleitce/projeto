package br.itaumon.eventdash.model;

import java.time.LocalDate;
/* import java.util.Date; */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/* import javax.persistence.Temporal;
import javax.persistence.TemporalType; */

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="itmn_evento")
public class Evento {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_seq")
	private int num_seq;
	
	@Column(name="data_evt")
	//@Temporal(TemporalType.DATE)
	//private Date data_evt;
	private LocalDate data_evt;

/*     @Column(name="id_alarme")
	private int id_alarme;

    @Column(name="id_equip")
	private int id_equip; */
	
	
	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Alarme alarme;

	@JsonIgnoreProperties("eventos")
	@ManyToOne
	private Equipamento equipamento;
	
	public int getNum_seq() {
		return num_seq;
	}

	public void setNum_seq(int numseq) {
		this.num_seq = numseq;
	}

	public LocalDate getData_evt() {
		return data_evt;
	}

	public void setData_evt(LocalDate data) {
		this.data_evt = data;
	}

	
/* 	public int getId_alarme() {
		return id_alarme;
	}

	public void setId_alarme(int id_alarme) {
		this.id_alarme = id_alarme;
	}

	public int getId_equip() {
		return id_equip;
	}

	public void setId_equip(int id_equip) {
		this.id_equip = id_equip;
	}  */   
	

	public Equipamento getEquipamento() {
		return equipamento;
	}

	public void setEquipamento(Equipamento equipamento) {
		this.equipamento = equipamento;
	}

	public Alarme getAlarme() {
		return alarme;
	}

	public void setAlarme(Alarme alarme) {
		this.alarme = alarme;
	}

	public Evento(int numseq, LocalDate data, Alarme alarme, Equipamento equipamento) {
    //public Evento(int numseq, LocalDate data, int alarme, int equipamento) {    
		super();
		this.num_seq = numseq;
		this.data_evt = data;
        this.alarme = alarme;
        this.equipamento = equipamento;
	}

	public Evento() {
		super();
	}

}
