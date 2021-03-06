/**
 * 
 */
package com.paperpad.mybox.models;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("com.googlecode.jsonschema2pojo")
@JsonPropertyOrder({ "token_id", "mail", "prenom", "nom", "adresse",
		"complement_adresse", "code_postale", "ville", "pays", "tel_fixe",
		"tel_mobile" })
public class UserAccount {
	
	// id is generated by the database and set on the object automagically
	@DatabaseField(generatedId = true)
	int id;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("token_id")
	private String token_id;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("mail")
	private String mail;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("prenom")
	private String prenom;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("nom")
	private String nom;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("adresse")
	private String adresse;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("complement_adresse")
	private String complement_adresse;
	
	@DatabaseField(canBeNull = true)
	@JsonProperty("code_postale")
	private Integer code_postale;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("ville")
	private String ville;
	
	@DatabaseField(canBeNull = true)
	@JsonProperty("pays")
	private Integer pays;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("tel_fixe")
	private String tel_fixe;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonProperty("tel_mobile")
	private String tel_mobile;
	
	@DatabaseField(canBeNull = true, dataType = DataType.STRING)
	@JsonIgnore
	private String civilite;
	
	
	public String getCivilite() {
		return civilite;
	}

	public void setCivilite(String civilite) {
		this.civilite = civilite;
	}

	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("token_id")
	public String getToken_id() {
		return token_id;
	}

	@JsonProperty("token_id")
	public void setToken_id(String token_id) {
		this.token_id = token_id;
	}

	@JsonProperty("mail")
	public String getMail() {
		return mail;
	}

	@JsonProperty("mail")
	public void setMail(String mail) {
		this.mail = mail;
	}

	@JsonProperty("prenom")
	public String getPrenom() {
		return prenom;
	}

	@JsonProperty("prenom")
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	@JsonProperty("nom")
	public String getNom() {
		return nom;
	}

	@JsonProperty("nom")
	public void setNom(String nom) {
		this.nom = nom;
	}

	@JsonProperty("adresse")
	public String getAdresse() {
		return adresse;
	}

	@JsonProperty("adresse")
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	@JsonProperty("complement_adresse")
	public String getComplement_adresse() {
		return complement_adresse;
	}

	@JsonProperty("complement_adresse")
	public void setComplement_adresse(String complement_adresse) {
		this.complement_adresse = complement_adresse;
	}

	@JsonProperty("code_postale")
	public Integer getCode_postale() {
		return code_postale;
	}

	@JsonProperty("code_postale")
	public void setCode_postale(Integer code_postale) {
		this.code_postale = code_postale;
	}

	@JsonProperty("ville")
	public String getVille() {
		return ville;
	}

	@JsonProperty("ville")
	public void setVille(String ville) {
		this.ville = ville;
	}

	@JsonProperty("pays")
	public Integer getPays() {
		return pays;
	}

	@JsonProperty("pays")
	public void setPays(Integer pays) {
		this.pays = pays;
	}

	@JsonProperty("tel_fixe")
	public String getTel_fixe() {
		return tel_fixe;
	}

	@JsonProperty("tel_fixe")
	public void setTel_fixe(String tel_fixe) {
		this.tel_fixe = tel_fixe;
	}

	@JsonProperty("tel_mobile")
	public String getTel_mobile() {
		return tel_mobile;
	}

	@JsonProperty("tel_mobile")
	public void setTel_mobile(String tel_mobile) {
		this.tel_mobile = tel_mobile;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperties(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public UserAccount(String mail, String prenom, String nom, String adresse,
			String complement_adresse, Integer code_postale, String ville,
			Integer pays, String tel_fixe, String tel_mobile, String civilite) {
		super();
		this.mail = mail;
		this.prenom = prenom;
		this.nom = nom;
		this.adresse = adresse;
		this.complement_adresse = complement_adresse;
		this.code_postale = code_postale;
		this.ville = ville;
		this.pays = pays;
		this.tel_fixe = tel_fixe;
		this.tel_mobile = tel_mobile;
		this.civilite = civilite;
	}

	public UserAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

}
