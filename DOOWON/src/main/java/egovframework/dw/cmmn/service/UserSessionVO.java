package egovframework.dw.cmmn.service;

import java.util.List;

public class UserSessionVO {

	private static final long serialVersionUID = 1L;

	private String cmpnyCd;
	private String id;
	private String lang;
	private String ip;
	private String manerYn;
	private String usrNm;
	private String corpNo;
	private String vndrId;
	private String adminYn;
	private String grpCd;
	private List<String> cmpnyCds;
	private List<String> corpNos;

	public String getCmpnyCd() {
		return cmpnyCd;
	}
	public void setCmpnyCd(String cmpnyCd) {
		this.cmpnyCd = cmpnyCd;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getManerYn() {
		return manerYn;
	}
	public void setManerYn(String manerYn) {
		this.manerYn = manerYn;
	}
	public String getUsrNm() {
		return usrNm;
	}
	public void setUsrNm(String usrNm) {
		this.usrNm = usrNm;
	}
	public String getAdminYn() {
		return adminYn;
	}
	public void setAdminYn(String adminYn) {
		this.adminYn = adminYn;
	}
	public String getGrpCd() {
		return grpCd;
	}
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	public String getCorpNo() {
		return corpNo;
	}
	public void setCorpNo(String corpNo) {
		this.corpNo = corpNo;
	}
	public String getVndrId() {
		return vndrId;
	}
	public void setVndrId(String vndrId) {
		this.vndrId = vndrId;
	}
	public List<String> getCmpnyCds() {
		return cmpnyCds;
	}
	public void setCmpnyCds(List<String> cmpnyCds) {
		this.cmpnyCds = cmpnyCds;
	}
	public List<String> getCorpNos() {
		return corpNos;
	}
	public void setCorpNos(List<String> corpNos) {
		this.corpNos = corpNos;
	}
}