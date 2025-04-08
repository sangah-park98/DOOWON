package egovframework.dw.cmmn.service;

/**
 * @Class Name : SaveFtaUserVO.java
 * @Description : SaveFtaUserVO Class
 * @Modification Information
 * @
 * @  수정일       수정자              수정내용
 * @ ---------     ---------   -------------------------------
 * @ 2020.01.15   심창무              최초생성
 *
 * @author 심창무
 * @since 2020.01.15
 * @version 1.0
 * @see
 *
 *  Copyright (C) by MOPAS All right reserved.
 */
public class SaveMemberUpateVO {

	/*검색 구분*/
	private String searchTp;
	private String CdTp;
	private String MnTp;

	/*사용자정보*/
	private String memberId;
	private String memberName;
	private String memberPwd;
    private String memberEmail;
    private String memberTel;
    private String alarmEmail;
	private String alarmSMS;
    private String alarmKakao;
    private String recvYn;
    private String apprYn;
    private String grpCd;
    
	private String shinhanManer;
    private String delYn;
   	private String regDt;
   	private String regId;
   	private String regIp;
   	private String edtDt;
   	private String edtId;
   	
   	/*user_cmpny_info*/
   	private String mangerYn;
    private String compName;
    private String compRegNo;
    private String agreeYn;
    private String manger;
    
    
    /*cmpny_info*/
    private String compCeo;
    private String compZip;
    private String compAddr1;
    private String compAddr2;
    private String mangerEmail;
    
    /*cmpny_branch_info*/
    private String branchCd;
    private String cusPrgCd;
    
    
    public String getApprYn() {
		return apprYn;
	}
	public void setApprYn(String apprYn) {
		this.apprYn = apprYn;
	}
    
    public String getSearchTp() {
		return searchTp;
	}
	public void setSearchTp(String searchTp) {
		this.searchTp = searchTp;
	}
	public String getCdTp() {
		return CdTp;
	}
	public void setCdTp(String cdTp) {
		CdTp = cdTp;
	}
	public String getMemberId() {
		return memberId;
	}
	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	public String getMemberName() {
		return memberName;
	}
	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	public String getMemberEmail() {
		return memberEmail;
	}
	public void setMemberEmail(String memberEmail) {
		this.memberEmail = memberEmail;
	}
	public String getMemberTel() {
		return memberTel;
	}
	public void setMemberTel(String memberTel) {
		this.memberTel = memberTel;
	}
	public String getAlarmEmail() {
		return alarmEmail;
	}
	public void setAlarmEmail(String alarmEmail) {
		this.alarmEmail = alarmEmail;
	}
	public String getAlarmSMS() {
		return alarmSMS;
	}
	public void setAlarmSMS(String alarmSMS) {
		this.alarmSMS = alarmSMS;
	}
	public String getAlarmKakao() {
		return alarmKakao;
	}
	public void setAlarmKakao(String alarmKakao) {
		this.alarmKakao = alarmKakao;
	}
	public String getRecvYn() {
		return recvYn;
	}
	public void setRecvYn(String recvYn) {
		this.recvYn = recvYn;
	}
	public String getGrpCd() {
		return grpCd;
	}
	public void setGrpCd(String grpCd) {
		this.grpCd = grpCd;
	}
	public String getShinhanManer() {
		return shinhanManer;
	}
	public void setShinhanManer(String shinhanManer) {
		this.shinhanManer = shinhanManer;
	}
	public String getDelYn() {
		return delYn;
	}
	public void setDelYn(String delYn) {
		this.delYn = delYn;
	}
	public String getRegDt() {
		return regDt;
	}
	public void setRegDt(String regDt) {
		this.regDt = regDt;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	public String getRegIp() {
		return regIp;
	}
	public void setRegIp(String regIp) {
		this.regIp = regIp;
	}
	public String getEdtDt() {
		return edtDt;
	}
	public void setEdtDt(String edtDt) {
		this.edtDt = edtDt;
	}
	public String getEdtId() {
		return edtId;
	}
	public void setEdtId(String edtId) {
		this.edtId = edtId;
	}
	public String getMangerYn() {
		return mangerYn;
	}
	public void setMangerYn(String mangerYn) {
		this.mangerYn = mangerYn;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public String getCompRegNo() {
		return compRegNo;
	}
	public void setCompRegNo(String compRegNo) {
		this.compRegNo = compRegNo;
	}
	public String getAgreeYn() {
		return agreeYn;
	}
	public void setAgreeYn(String agreeYn) {
		this.agreeYn = agreeYn;
	}
	public String getMemberPwd() {
		return memberPwd;
	}
	public void setMemberPwd(String memberPwd) {
		this.memberPwd = memberPwd;
	}
	public String getMnTp() {
		return MnTp;
	}
	public void setMnTp(String mnTp) {
		MnTp = mnTp;
	}
	public String getManger() {
		return manger;
	}
	public void setManger(String manger) {
		this.manger = manger;
	}
	public String getCompCeo() {
		return compCeo;
	}
	public void setCompCeo(String compCeo) {
		this.compCeo = compCeo;
	}
	public String getCompZip() {
		return compZip;
	}
	public void setCompZip(String compZip) {
		this.compZip = compZip;
	}
	public String getCompAddr1() {
		return compAddr1;
	}
	public void setCompAddr1(String compAddr1) {
		this.compAddr1 = compAddr1;
	}
	public String getCompAddr2() {
		return compAddr2;
	}
	public void setCompAddr2(String compAddr2) {
		this.compAddr2 = compAddr2;
	}
	public String getMangerEmail() {
		return mangerEmail;
	}
	public void setMangerEmail(String mangerEmail) {
		this.mangerEmail = mangerEmail;
	}
	public String getBranchCd() {
		return branchCd;
	}
	public void setBranchCd(String branchCd) {
		this.branchCd = branchCd;
	}
	public String getCusPrgCd() {
		return cusPrgCd;
	}
	public void setCusPrgCd(String cusPrgCd) {
		this.cusPrgCd = cusPrgCd;
	}
}