package br.edu.cefsa.ftt.ec;

/*********
 * Reference:
 * https://en.wikipedia.org/wiki/JavaBeans
 * https://pt.wikipedia.org/wiki/Plain_Old_Java_Objects
 */

public class ProductBean implements java.io.Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private int pId;
	private String pDescription;
	private float pValue;
	
	public ProductBean(int pId, String pDescription, float pValue) {
		
		super();
		
		this.pId = pId;
		this.pDescription = pDescription;
		this.pValue = pValue;
	}

	public ProductBean(String pId, String pDescription, String pValue) {
		
		super();
		
		this.setpId(pId);
		this.setpDescription(pDescription);
		this.setpValue(pValue);
	}	

	public ProductBean(String pId) {
		
		super();
		
		this.setpId(pId);
		
	}	
	
	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public void setpId(String pId) {
		this.pId = Integer.valueOf(pId);
	}
	public String getpDescription() {
		return pDescription;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public float getpValue() {
		return pValue;
	}
	public void setpValue(float pValue) {
		this.pValue = pValue;
	}
	public void setpValue(String pValue) {
		this.pValue = Float.valueOf(pValue);
	}	

	@Override
	public String toString() {
		return "ProductBean [pId=" + pId + ", pDescription=" + pDescription + ", pValue=" + pValue + "]";
	}

	@Override
	public boolean equals(Object obj) {
		
	    if (obj instanceof ProductBean)
	    	if (this.getpId() == ((ProductBean)obj).getpId())
	            return true;
	            
	    return false;
	} //equals

}
