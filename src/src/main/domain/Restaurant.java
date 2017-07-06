package src.main.domain;

public class Restaurant {
	private String 업종명;
	private String 인허가일자;
	private String 업소명;
	private String 소재지_도로명;
	private String 소재지_지번;
	private String 소재지전화;
	private String 업태명;
	
	public Restaurant(String 업소명) {
		this.업소명 = 업소명;
	}

	public Restaurant(String 업종명, String 인허가일자, String 업소명, String 소재지_도로명, String 소재지_지번, String 소재지전화, String 업태명) {
		super();
		this.업종명 = 업종명;
		this.인허가일자 = 인허가일자;
		this.업소명 = 업소명;
		this.소재지_도로명 = 소재지_도로명;
		this.소재지_지번 = 소재지_지번;
		this.소재지전화 = 소재지전화;
		this.업태명 = 업태명;
	}

	@Override
	public String toString() {
		return "Restaurant [업종명=" + 업종명 + ", 인허가일자=" + 인허가일자 + ", 업소명=" + 업소명 + ", 소재지_도로명=" + 소재지_도로명 + ", 소재지_지번="
				+ 소재지_지번 + ", 소재지전화=" + 소재지전화 + ", 업태명=" + 업태명 + "]";
	}
}
