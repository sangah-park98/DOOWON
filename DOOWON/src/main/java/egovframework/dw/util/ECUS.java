package egovframework.dw.util;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Root")
public class ECUS {
    private String App;
    private String Date;
    
    @XmlElement(name = "DToKhaiMDIDs")
    private DToKhaiMDIDs dToKhaiMDIDs;

    @XmlElement(name = "DHangMDDKs")
    private DHangMDDKs dHangMDDKs;
    
//    @XmlElement(name = "DMSG_OUT_REPs")
//    private DMSG_OUT_REPs dMSG_OUT_REPs;
    
	public DHangMDDKs getdHangMDDKs() {
		return dHangMDDKs;
	}
	public void setdHangMDDKs(DHangMDDKs dHangMDDKs) {
		this.dHangMDDKs = dHangMDDKs;
	}
	
	@XmlElement(name = "App")
	public String getApp() {
		return App;
	}
	public void setApp(String app) {
		App = app;
	}
	@XmlElement(name = "Date")
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	
	public DToKhaiMDIDs getdToKhaiMDIDs() {
		return dToKhaiMDIDs;
	}
	
	public void setdToKhaiMDIDs(DToKhaiMDIDs dToKhaiMDIDs) {
		this.dToKhaiMDIDs = dToKhaiMDIDs;
	} 
	
	@XmlRootElement(name = "DToKhaiMDIDs")
	public static class DToKhaiMDIDs {
				
		private DToKhaiMD dToKhaiMD;
		
		@XmlElement(name = "DToKhaiMD")
		public DToKhaiMD getdToKhaiMD() {
			return dToKhaiMD;
		}

		public void setdToKhaiMD(DToKhaiMD dToKhaiMD) {
			this.dToKhaiMD = dToKhaiMD;
		}
		
		@XmlRootElement(name = "DToKhaiMD")
		public static class DToKhaiMD {
			private DToKhaiMD_Data data;
			
			@XmlElement(name = "Data")
			public DToKhaiMD_Data getData() {
				return data;
			}

			public void setData(DToKhaiMD_Data data) {
				this.data = data;
			}

			@XmlRootElement(name = "Data")
			public static class DToKhaiMD_Data {
				private String SOTK = "";
				private String NGAY_DK = "";
				private String SO_HDTM = "";
				private String MA_GH = "";
				private String TONGTGTT = "";
				private String _XorN = "";
				private String TEN_PTVT = "";
				private String Ten_DV_L1 = "";
				private String SO_HD = "";
				private String NGAY_HD = "";
				private String TYGIA_VND = "";
				private String MA_NT = "";
				private String DV_DT = "";
				
				
				@XmlElement(name = "DV_DT")
				public String getDV_DT() {
					return DV_DT;
				}
				
				public void setDV_DT(String DV_DT) {
					this.DV_DT = DV_DT;
				}
				@XmlElement(name = "MA_NT")
				public String getMA_NT() {
					return MA_NT;
				}
				
				public void setMA_NT(String MA_NT) {
					this.MA_NT = MA_NT;
				}
				@XmlElement(name = "TYGIA_VND")
				public String getTYGIA_VND() {
					return TYGIA_VND;
				}
				
				public void setTYGIA_VND(String TYGIA_VND) {
					this.TYGIA_VND = TYGIA_VND;
				}
				
				
				@XmlElement(name = "Ten_DV_L1")
				public String getTen_DV_L1() {
					return Ten_DV_L1;
				}

				public void setTen_DV_L1(String Ten_DV_L1) {
					this.Ten_DV_L1 = Ten_DV_L1;
				}
				
				@XmlElement(name = "SO_HD")
				public String getSO_HD() {
					return SO_HD;
				}
				
				public void setSO_HD(String SO_HD) {
					this.SO_HD = SO_HD;
				}
				
				@XmlElement(name = "NGAY_HD")
				public String getNGAY_HD() {
					return NGAY_HD;
				}
				
				public void setNGAY_HD(String NGAY_HD) {
					this.NGAY_HD = NGAY_HD;
				}
				
				@XmlElement(name = "SOTK")
				public String getSOTK() {
					return SOTK;
				}
				
				public void setSOTK(String SOTK) {
					this.SOTK = SOTK;
				}
				
				@XmlElement(name = "TEN_PTVT")
				public String getTEN_PTVT() {
					return TEN_PTVT;
				}

				public void setTEN_PTVT(String TEN_PTVT) {
					this.TEN_PTVT = TEN_PTVT;
				}
				
				@XmlElement(name = "_XorN")
				public String get_XorN() {
					return _XorN;
				}

				public void set_XorN(String _XorN) {
					this._XorN = _XorN;
				}
				
				@XmlElement(name = "TONGTGTT")
				public String getTONGTGTT() {
					return TONGTGTT;
				}

				public void setTONGTGTT(String TONGTGTT) {
					this.TONGTGTT = TONGTGTT;
				}
				
				@XmlElement(name = "MA_GH")
				public String getMA_GH() {
					return MA_GH;
				}

				public void setMA_GH(String MA_GH) {
					this.MA_GH = MA_GH;
				}

				@XmlElement(name = "NGAY_DK")
				public String getNGAY_DK() {
					return NGAY_DK;
				}

				public void setNGAY_DK(String nGAY_DK) {
					this.NGAY_DK = nGAY_DK;
				}
				
				@XmlElement(name = "SO_HDTM")
				public String getSO_HDTM() {
					return SO_HDTM;
				}

				public void setSO_HDTM(String sO_HDTM) {
					this.SO_HDTM = sO_HDTM;
				}
			}
		}
	}
	
//	public DMSG_OUT_REPs getdMSG_OUT_REPs() {
//		return dMSG_OUT_REPs;
//	}
//	public void setdMSG_OUT_REPs(DMSG_OUT_REPs dMSG_OUT_REPs) {
//		this.dMSG_OUT_REPs = dMSG_OUT_REPs;
//	}
	
	@XmlRootElement(name = "DHangMDDKs")
	public static class DHangMDDKs {
		
		private List<DHangMDDK> dHangMDDK;
		
		@XmlElement(name = "DHangMDDK")
		public List<DHangMDDK> getdHangMDDK() {
			return dHangMDDK;
		}

		public void setdHangMDDK(List<DHangMDDK> dHangMDDK) {
			this.dHangMDDK = dHangMDDK;
		}
		
        @XmlRootElement(name = "DHangMDDK")
        public static class DHangMDDK {
    		private DHangMDDK_Data data;
    		
			@XmlElement(name = "Data")
			public DHangMDDK_Data getData() {
				return data;
			}

			public void setData(DHangMDDK_Data data) {
				this.data = data;
			}
    		
			@XmlRootElement(name = "Data")
			public static class DHangMDDK_Data {
				private String MA_NPL_SP = "";
				private String TEN_NUOC_XX = "";
				private String LUONG = "";
				private String DGIA_TT = "";
				private String THUEKHAC_TRGIA_TT = "";
				private String MA_LH = "";
				private String STTHANG = "";
				private String DGIA_KB = "";
				private String MA_DVT = "";
				private String MA_HANGKB = "";
				private String TEN_HANG = "";
				private String TRIGIA_KB = "";
				private String TGKB_VND = "";
				private String NUOC_XX = "";
				
				
				@XmlElement(name = "NUOC_XX")
				public String getNUOC_XX() {
					return NUOC_XX;
				}

				public void setNUOC_XX(String NUOC_XX) {
					this.NUOC_XX = NUOC_XX;
				}
				@XmlElement(name = "TGKB_VND")
				public String getTGKB_VND() {
					return TGKB_VND;
				}
				
				public void setTGKB_VND(String TGKB_VND) {
					this.TGKB_VND = TGKB_VND;
				}
				
				@XmlElement(name = "TRIGIA_KB")
				public String getTRIGIA_KB() {
					return TRIGIA_KB;
				}
				
				public void setTRIGIA_KB(String TRIGIA_KB) {
					this.TRIGIA_KB = TRIGIA_KB;
				}
				@XmlElement(name = "TEN_HANG")
				public String getTEN_HANG() {
					return TEN_HANG;
				}
				
				public void setTEN_HANG(String TEN_HANG) {
					this.TEN_HANG = TEN_HANG;
				}
				
				@XmlElement(name = "MA_HANGKB")
				public String getMA_HANGKB() {
					return MA_HANGKB;
				}

				public void setMA_HANGKB(String MA_HANGKB) {
					this.MA_HANGKB = MA_HANGKB;
				}
				@XmlElement(name = "MA_LH")
				public String getMA_LH() {
					return MA_LH;
				}
				
				public void setMA_LH(String MA_LH) {
					this.MA_LH = MA_LH;
				}
				@XmlElement(name = "STTHANG")
				public String getSTTHANG() {
					return STTHANG;
				}

				public void setSTTHANG(String STTHANG) {
					this.STTHANG = STTHANG;
				}
				@XmlElement(name = "DGIA_KB")
				public String getDGIA_KB() {
					return DGIA_KB;
				}

				public void setDGIA_KB(String DGIA_KB) {
					this.DGIA_KB = DGIA_KB;
				}
				@XmlElement(name = "MA_DVT")
				public String getMA_DVT() {
					return MA_DVT;
				}

				public void setMA_DVT(String MA_DVT) {
					this.MA_DVT = MA_DVT;
				}
				
				@XmlElement(name = "DGIA_TT")
				public String getDGIA_TT() {
					return DGIA_TT;
				}

				public void setDGIA_TT(String DGIA_TT) {
					this.DGIA_TT = DGIA_TT;
				}
				
				@XmlElement(name = "THUEKHAC_TRGIA_TT")
				public String getTHUEKHAC_TRGIA_TT() {
					return THUEKHAC_TRGIA_TT;
				}

				public void setTHUEKHAC_TRGIA_TT(String THUEKHAC_TRGIA_TT) {
					this.THUEKHAC_TRGIA_TT = THUEKHAC_TRGIA_TT;
				}
				
				@XmlElement(name = "MA_NPL_SP")
				public String getMA_NPL_SP() {
					return MA_NPL_SP;
				}

				public void setMA_NPL_SP(String MA_NPL_SP) {
					this.MA_NPL_SP = MA_NPL_SP;
				}
				
				@XmlElement(name = "TEN_NUOC_XX")
				public String getTEN_NUOC_XX() {
					return TEN_NUOC_XX;
				}

				public void setTEN_NUOC_XX(String TEN_NUOC_XX) {
					this.TEN_NUOC_XX = TEN_NUOC_XX;
				}
				
				@XmlElement(name = "LUONG")
				public String getLUONG() {
					return LUONG;
				}

				public void setLUONG(String LUONG) {
					this.LUONG = LUONG;
				}
			}
    		
        }

	}
}