package com.necture.laundryPoints.entity;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

// this has been used by admin but currently we aren't using any functionality of 
// admin so we can used it directly
@Entity
@Table(name = "cloth")
public class Cloth {

	@Id
	@GeneratedValue(generator = "UUID")
	private UUID id;

	private String clothName;

	private double price;
	
	@OneToMany(mappedBy = "cloth")
	private List<OrderCreationDetail> orderCreationDetails = new ArrayList<>();


	public UUID getId() {
		return id;
	}

	public String getClothName() {
		StringBuilder result = new StringBuilder();

        // Flag to indicate that the next character should be capitalized
        Boolean capitalizeNext = true;
        char[] characters = clothName.toCharArray();

        for (char c : characters) {
            if (Character.isWhitespace(c) || c == '-') {
                // If the character is whitespace, set the flag to capitalize the next character
            	result.append(Character.toUpperCase(c));
                capitalizeNext = true;
            } else if (capitalizeNext) {
                // If the flag is set, capitalize the character and append it to the result
                result.append(Character.toUpperCase(c));
                capitalizeNext = false;
            } else {
                // If the flag is not set, append the character as is
                result.append(c);
            }
        }

		return result.toString();
	}

	public void setClothName(String clothName) {
		
		if(!clothName.matches("[a-zA-z ]+$")) {
			throw new RuntimeException("Please enter valid name. Name must contain alphabet or hyphen");
		}
		
		this.clothName =  clothName.toLowerCase().trim().replaceAll("\\s+", " ");
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "Cloth [id=" + id + ", clothName=" + clothName + ", price=" + price + "]";
	}

}
