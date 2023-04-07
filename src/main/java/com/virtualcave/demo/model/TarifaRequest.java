package  com.virtualcave.demo.model;

import java.sql.Timestamp;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public class TarifaRequest {
	
	@NotEmpty
	@NotNull
    private Long id;
	
	@NotNull
	private Long brand_id;

    @NotNull    
    private Long productId;
    
    private Timestamp start_date;
    
    private Timestamp end_date;
    
    private Long price;
    
    private String currency_code;
    
    public TarifaRequest() {
    }

    
    public TarifaRequest(Long id, Long brand_id, Long productId, Timestamp start_date, Timestamp end_date, 
    		Long price, String currency_code) {
        this.id = id;
        this.brand_id = brand_id;
        this.productId = productId;
        this.start_date = start_date;
        this.end_date = end_date;
        this.price = price;
        this.currency_code = currency_code;        
    }    

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getProductId() {
		return productId;
	}

	public void setProductId(Long productId) {
		this.productId = productId;
	}

	public Timestamp getStart_date() {
		return start_date;
	}

	public void setStart_date(Timestamp start_date) {
		this.start_date = start_date;
	}

	public Timestamp getEnd_date() {
		return end_date;
	}

	public void setEnd_date(Timestamp end_date) {
		this.end_date = end_date;
	}

	public Long getPrice() {
		return price;
	}

	public void setPrice(Long price) {
		this.price = price;
	}

	public String getCurrency_code() {
		return currency_code;
	}

	public void setCurrency_code(String currency_code) {
		this.currency_code = currency_code;
	}
		

	public Long getBrand_id() {
		return brand_id;
	}


	public void setBrand_id(Long brand_id) {
		this.brand_id = brand_id;
	}


	@Override
    public String toString() {
        return "TarifaRequest{" +
                "id='" + id + '\'' +
                ", brand_id=" + brand_id +'\'' +   
                ", productId=" + productId +'\'' +                
                ", start_date=" + start_date +'\'' +
                ", end_date=" + end_date +'\'' +
                ", price=" + price +'\'' +
                ", currency_code=" + currency_code +
                '}';
    }	
}
